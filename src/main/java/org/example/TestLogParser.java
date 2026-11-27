package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestLogParser {

    private static List<TestResult> results = new ArrayList<>();
    private static List<Error> errors = new ArrayList<>();

    public static void parse(List<String> lines) {

        for (String line : lines) {
            String[] words = line.split("\\|");

            if (words.length != 3) {
                errors.add(new Error(line, "Не хватает разделителя"));
                continue;
            }

            if (!Status.isValid(words[1])) {
                errors.add(new Error(line, String.format("неизвестный статус: %s", words[1])));
                continue;
            }

            long time = 0;

            try {
                time = Long.parseLong(words[2]);
            } catch (NumberFormatException e) {
                errors.add(new Error(line, String.format("не число вместо времени: %s", words[2])));
                continue;
            }

            if (time < 0) {
                errors.add(new Error(line, String.format("отрицательная длительность: %s", words[2])));
                continue;
            }

            boolean swaped = false;

            for (int i = 0; i < results.size(); i++) {
                // методы equals() и hashCode() работают автоматически для record классов.
                if(results.get(i).name().equals(words[0])){
                    results.set(i, new TestResult(words[0], Status.valueOf(words[1]), time));
                    swaped = true;
                }
            }

            if (!swaped){
                results.add(new TestResult(words[0], Status.valueOf(words[1]), time));
            }
        }
    }

    public static Optional<TestResult> firstFailed(List<TestResult> results){
        return results.stream()
                .filter(e -> e.status().equals(Status.FAILED))
                .findFirst();
    }

    public static List<TestResult> getResults(){
        return results;
    }

    public static List<Error> getErrors(){
        return errors;
    }
}
