package org.example;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestPlanScanner {

    public static void buildPlan(Class<?> clazz) {
        List<TestStep> steps = new ArrayList<>();

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(TestId.class)) {
                TestId annotation = method.getAnnotation(TestId.class);
                steps.add(new TestStep(annotation.value(), method.getName(), annotation.order()));
            }
        }

        if (steps.isEmpty()) {
            System.out.println("Кейсов нет");
            return;
        }

        steps.sort(Comparator.comparingInt(TestStep::order));

        System.out.println(String.format("План прогона для %s:", clazz.getSimpleName()));
        for (int i = 0; i < steps.size(); i++) {
            System.out.printf("\t%d. %s → %s%n", i + 1, steps.get(i).id(), steps.get(i).methodName());
        }
    }
}
