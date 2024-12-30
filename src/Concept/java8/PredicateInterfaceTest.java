package Concept.java8;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class PredicateInterfaceTest {

    public static void main(String[] args) {



//        List<Integer> list = List.of(1, 2, 356, 7, 0, 10, 0, 1);
//
//        Map<Integer, Long> frequencyMap = list.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
//        System.out.println(frequencyMap);
//
//        String sentence = "Rakesh is a boy is";
//        String[] arr = sentence.split(" ");
//
//        Map<String, Long> stringMap = Arrays.stream(arr).collect(Collectors.groupingBy(x -> x, Collectors.counting()));
//        System.out.println(stringMap);
//
//        String name = "Rakesha";
//        Character[] charArray = { 'H', 'e', 'l', 'l', 'o' };
//        Stream<Character> stream = Arrays.stream(charArray);
//
//        String str = "testString";
//        char[] charArray1 = str.toCharArray();
//        Character[] charObjectArray = name.chars().mapToObj(c -> (char) c).toArray(Character[] :: new);
//        Map<Character, Long> charMap = Arrays.stream(charObjectArray).collect(Collectors.groupingBy(x -> x, Collectors.counting()));
//        System.out.println(charMap);
//
//        String str1 = "The big hero";
//        Character[] charArObj = str1.chars().mapToObj(i -> (char) i).toArray(Character[] :: new);
//        System.out.println(Arrays.toString(charArObj));
//        Map<Character, Long> charMap1 = Arrays.stream(charArObj).filter( c -> c != ' ')
//                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
//        System.out.println(charMap1);
        System.out.println( Instant.now());
    }
}
