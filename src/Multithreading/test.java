package Multithreading;

import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test {
    public static void main(String[] args) {
        String str = "welcome to java";
        // to find 1st repeating character
        Stream<Character> charStr = str.chars().mapToObj(c -> (char) c);
//        final Map<Character, Long> frequencyMap = charStr.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
//        charStr.reduce('', c -> {
//            if (frequencyMap.get(c) > 1) {
//                return c;
//            }
//            return '';
//        });

    }
//    static void printArray(Object str) {
//        for (int i=0; i<str.length; i++) {
//            if (str.) {
//
//            } else {
//
//            }
//            System.out.println(str[i]);
//        }
//    }
}
