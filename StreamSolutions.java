import java.util.*;
import java.util.stream.*;
import java.util.function.Function;

public class StreamSolutions {
    
    // 1. Sum of all even numbers
    public static int sumOfEvens(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    // 2. Convert a list of strings to a list of integers representing their lengths
    public static List<Integer> lengthsOfStrings(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }

    // 3. Find the maximum number in a list of integers
    public static int maxInList(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(NoSuchElementException::new);
    }

    // 4. Sort a list of strings in alphabetical order
    public static List<String> sortStrings(List<String> strings) {
        return strings.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    // 5. Count the number of unique words in a list of strings
    public static long countUniqueWords(List<String> words) {
        return words.stream()
                .distinct()
                .count();
    }

    // 6. Filter out all empty strings from a list
    public static List<String> filterEmptyStrings(List<String> strings) {
        return strings.stream()
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
    }

    // 7. Concatenate a list of strings into a single string, separated by commas
    public static String concatenateStrings(List<String> strings) {
        return strings.stream()
                .collect(Collectors.joining(","));
    }

    // 8. Find the average of a list of integers
    public static double averageOfList(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    // 9. Check if all elements in a list of integers are positive
    public static boolean allPositive(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(n -> n > 0);
    }

    // 10. Find the first non-empty string in a list of strings
    public static Optional<String> firstNonEmptyString(List<String> strings) {
        return strings.stream()
                .filter(s -> !s.isEmpty())
                .findFirst();
    }

    // 11. Collect all distinct characters from a list of strings
    public static Set<Character> distinctCharacters(List<String> strings) {
        return strings.stream()
                .flatMapToInt(String::chars)
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());
    }

    // 12. Partition a list of integers into even and odd numbers
    public static Map<Boolean, List<Integer>> partitionEvenOdd(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
    }

    // 13. Group a list of strings by their first character
    public static Map<Character, List<String>> groupByFirstCharacter(List<String> strings) {
        return strings.stream()
                .collect(Collectors.groupingBy(s -> s.charAt(0)));
    }

    // 14. Create a map from a list of strings, where the key is the string and the value is its length
    public static Map<String, Integer> mapToStringLengths(List<String> strings) {
        return strings.stream()
                .collect(Collectors.toMap(Function.identity(), String::length));
    }

    // 15. Check if any string in a list contains the letter "a"
    public static boolean containsLetterA(List<String> strings) {
        return strings.stream()
                .anyMatch(s -> s.contains("a"));
    }

    // 16. Find the longest string in a list of strings
    public static Optional<String> longestString(List<String> strings) {
        return strings.stream()
                .max(Comparator.comparingInt(String::length));
    }

    // 17. Generate a list of squares of integers from 1 to 10
    public static List<Integer> squaresOfOneToTen() {
        return IntStream.rangeClosed(1, 10)
                .map(n -> n * n)
                .boxed()
                .collect(Collectors.toList());
    }

    // 18. Flatten a list of lists of integers into a single list
    public static List<Integer> flattenListOfLists(List<List<Integer>> lists) {
        return lists.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    // 19. Find the sum of the squares of all odd numbers in a list
    public static int sumOfSquaresOfOdds(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 != 0)
                .map(n -> n * n)
                .mapToInt(Integer::intValue)
                .sum();
    }

    // 20. Create a comma-separated string from a list of integers
    public static String commaSeparatedIntegers(List<Integer> numbers) {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }

    // 21. Find the second largest number in a list of integers
    public static Optional<Integer> secondLargest(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
    }

    // 22. Calculate the product of all numbers in a list of integers
    public static int productOfList(List<Integer> numbers) {
        return numbers.stream()
                .reduce(1, (a, b) -> a * b);
    }

    // 23. Remove duplicate integers from a list
    public static List<Integer> removeDuplicates(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    // 24. Find the shortest string in a list of strings
    public static Optional<String> shortestString(List<String> strings) {
        return strings.stream()
                .min(Comparator.comparingInt(String::length));
    }

    // 25. Convert a list of strings to uppercase
    public static List<String> toUpperCase(List<String> strings) {
        return strings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    // 26. Group a list of strings by their length
    public static Map<Integer, List<String>> groupByStringLength(List<String> strings) {
        return strings.stream()
                .collect(Collectors.groupingBy(String::length));
    }

    // 27. Check if a list of integers contains any negative numbers
    public static boolean containsNegative(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(n -> n < 0);
    }

    // 28. Create a list of the first 10 Fibonacci numbers
    public static List<Integer> firstTenFibonacci() {
        return Stream.iterate(new int[]{0, 1}, fib -> new int[]{fib[1], fib[0] + fib[1]})
                .limit(10)
                .map(fib -> fib[0])
                .collect(Collectors.toList());
    }

    // 29. Find the sum of all numbers greater than 5 in a list of integers
    public static int sumGreaterThanFive(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n > 5)
                .mapToInt(Integer::intValue)
                .sum();
    }

    // 30. Sort a list of integers in descending order
    public static List<Integer> sortDescending(List<Integer> numbers) {
        return numbers.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    // 31. Count the occurrences of each character in a string
    public static Map<Character, Long> countCharacterOccurrences(String str) {
        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    // 32. Find the top 3 longest strings in a list
    public static List<String> topThreeLongestStrings(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    // 33. Create a map from a list of strings where the key is the string and the value is the number of vowels
    public static Map<String, Long> mapToVowelCounts(List<String> strings) {
        return strings.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        s -> s.chars().filter(c -> "aeiouAEIOU".indexOf(c) != -1).count()));
    }

    // 34. Filter a list of integers to only include prime numbers
    public static List<Integer> filterPrimes(List<Integer> numbers) {
        return numbers.stream()
                .filter(StreamSolutions::isPrime)
                .collect(Collectors.toList());
    }

    // Helper method to check if a number is prime
    private static boolean isPrime(int number) {
        if (number <= 1) return false;
        return IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(n -> number % n == 0);
    }

    // 35. Create a map grouping words by their length
    public static Map<Integer, List<String>> groupWordsByLength(List<String> words) {
        return words.stream()
                .collect(Collectors.groupingBy(String::length));
    }

    // 36. Check if all strings in a list are non-empty
    public static boolean allStringsNonEmpty(List<String> strings) {
        return strings.stream()
                .noneMatch(String::isEmpty);
    }

    // 37. Concatenate a list of strings, each surrounded by double quotes
    public static String concatenateWithQuotes(List<String> strings) {
        return strings.stream()
                .map(s -> "\"" + s + "\"")
                .collect(Collectors.joining(","));
    }

    // 38. Find the most frequent word in a list of strings
    public static Optional<String> mostFrequentWord(List<String> words) {
        return words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }

    // 39. Convert a list of integers to a list of their binary string representations
    public static List<String> toBinaryStrings(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    // 40. Find the sum of the first 100 even numbers
    public static int sumOfFirstHundredEvens() {
        return IntStream.iterate(2, n -> n + 2)
                .limit(100)
                .sum();
    }

    // 41. Filter a list of strings to only include those that start with a given prefix
    public static List<String> filterByPrefix(List<String> strings, String prefix) {
        return strings.stream()
                .filter(s -> s.startsWith(prefix))
                .collect(Collectors.toList());
    }

    // 42. Generate a list of the first 20 prime numbers
    public static List<Integer> firstTwentyPrimes() {
        return Stream.iterate(2, n -> n + 1)
                .filter(StreamSolutions::isPrime)
                .limit(20)
                .collect(Collectors.toList());
    }

    // 43. Count the number of vowels in each string in a list
    public static List<Long> countVowelsInStrings(List<String> strings) {
        return strings.stream()
                .map(s -> s.chars().filter(c -> "aeiouAEIOU".indexOf(c) != -1).count())
                .collect(Collectors.toList());
    }

    // 44. Create a map from a list of integers where the key is the integer and the value is its factorial
    public static Map<Integer, Integer> mapToFactorials(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.toMap(Function.identity(), StreamSolutions::factorial));
    }

    // Helper method to calculate factorial
    private static int factorial(int number) {
        return IntStream.rangeClosed(1, number)
                .reduce(1, (a, b) -> a * b);
    }

    // 45. Find the sum of the lengths of all strings in a list
    public static int sumOfStringLengths(List<String> strings) {
        return strings.stream()
                .mapToInt(String::length)
                .sum();
    }

    // 46. Check if a list of strings is sorted in alphabetical order
    public static boolean isSortedAlphabetically(List<String> strings) {
        return IntStream.range(0, strings.size() - 1)
                .allMatch(i -> strings.get(i).compareTo(strings.get(i + 1)) <= 0);
    }

    // 47. Find the longest word in a list of strings that contains the letter "e"
    public static Optional<String> longestStringWithE(List<String> strings) {
        return strings.stream()
                .filter(s -> s.contains("e"))
                .max(Comparator.comparingInt(String::length));
    }

    // 48. Group a list of integers by their remainder when divided by 3
    public static Map<Integer, List<Integer>> groupByRemainder(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.groupingBy(n -> n % 3));
    }

    // 49. Create a map from a list of strings where the key is the first character and the value is a list of words starting with that character
    public static Map<Character, List<String>> groupByFirstChar(List<String> strings) {
        return strings.stream()
                .collect(Collectors.groupingBy(s -> s.charAt(0)));
    }

    // 50. Find the median of a list of integers
    public static double medianOfList(List<Integer> numbers) {
        int size = numbers.size();
        List<Integer> sorted = numbers.stream().sorted().collect(Collectors.toList());
        return size % 2 == 0 ? 
            (sorted.get(size / 2 - 1) + sorted.get(size / 2)) / 2.0 : 
            sorted.get(size / 2);
    }

    public static void main(String[] args) {
        // Test the functions here
    }
}
