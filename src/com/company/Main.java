package com.company;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Map<String, Integer> words = countWords("а а б   б б! в г - г г г");
        words.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(Main::display);
    }

    private static Map<String, Integer> countWords(String s) {
        String[] words = s.replaceAll("[^^a-zA-Zа-яА-Я ]", "").toLowerCase().split("\\s+");
        return Arrays.stream(words)
                .collect(Collectors.toMap(w -> w, w -> 1, (i, i2) -> i + 1));
    }

    private static void display(Map.Entry<String, Integer> entry) {
        System.out.println(entry.getKey() + " " + entry.getValue());
    }
}
