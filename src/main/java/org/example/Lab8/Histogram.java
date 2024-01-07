package org.example.Lab8;

import java.util.List;
import java.util.Map;

public class Histogram {

    public static void generateHistogram(String title, Map<String, Double> data) {
        System.out.println(title);

        List<Map.Entry<String, Double>> sortedData = data.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .toList();

        double maxValue = sortedData.stream().mapToDouble(Map.Entry::getValue).max().orElse(1.0);

        for (Map.Entry<String, Double> entry : sortedData) {
            String label = entry.getKey();
            double value = entry.getValue();
            int scaledValue = (int) (value / maxValue * 50);

            System.out.printf("%-15s | %-50s %.2f%n", label, "#".repeat(scaledValue), value);
        }

        System.out.println();
    }
}
