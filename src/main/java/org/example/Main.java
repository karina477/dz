package org.example;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        URL resource = Main.class.getClassLoader().getResource("run.log");

        List<String> content = null;

        try (Stream<String> lines = Files.lines(Path.of(resource.toURI()), StandardCharsets.UTF_8)) {
            content = lines.toList();
        } catch (Exception e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }

        TestLogParser.parse(content);
        System.out.println("Результаты:");

        for (TestResult testResult: TestLogParser.getResults()){
            System.out.println(String.format("\t%s — %s (%d ms)", testResult.name(), testResult.status(), testResult.durationMs()));
        }

        System.out.println("Битые строки:");

        for (Error error: TestLogParser.getErrors()){
            System.out.println(String.format("\t%s — %s", error.line(), error.description()));
        }

        Optional<TestResult> firstFail = TestLogParser.firstFailed(TestLogParser.getResults());

        if (firstFail.isPresent()){
            System.out.println(String.format("Первый упавший: %s", firstFail.get().name()));
        }
        else {
            System.out.println("Первый упавший: Падений нет");
        }
    }
}