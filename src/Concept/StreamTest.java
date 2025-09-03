package Concept;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class StreamTest {
    public static void main(String[] args) {
        List<Integer> numberList = List.of(1,0,9,6,5,11,3);

        int sum = numberList.stream()
                .filter( i -> i > 2)
                .peek( j -> System.out.println("filter : " + j))
                .map(k -> k*k)
                .peek(j -> System.out.println("map : " + j))
                .sorted((a,b) -> a-b)
                .peek(j -> System.out.println("sorted : " + j))
                .reduce(0,(i,j) -> i+j);


        System.out.println("final sum : " + sum);

        List<Integer> frequentNumbers = List.of(1,0,1,6,0,11,3);

        Map<Integer, Long> frequencyMap = frequentNumbers.stream()
                .collect(Collectors.groupingBy(
                i -> i , Collectors.counting()
        ));

        String str = "mynameisrakesh";
//        char[] charArr = str.toCharArray();
        List<Character> list = str.chars().mapToObj( i -> (char) i).collect(Collectors.toList());
        System.out.println("list of char : " + list);
        Map<Character, Long> countMap = list.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        System.out.println("map : " + countMap);
    }
}
