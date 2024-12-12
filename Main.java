import java.util.*;
import java.util.stream.Collectors;

class StreamTerminalOperationsExample {
    public static void main(String[] args) {

        //List of names
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("Reflection","Collection","Stream"),
                Arrays.asList("Structure","State","Flow"),
                Arrays.asList("Sorting","Mapping","Reduction","Stream")
        );
        //Create a set to hold intermediate results
        Set<String> intermediateResults = new HashSet<>();

        System.out.println("------------------------Intermediate Operation-----------------------------------");

        //Stream pipeline demonstrating intermediate results
        List<String> results = listOfLists.stream()
                .flatMap(List::stream)
                .filter(s -> s.startsWith("S"))
                .map(String::toUpperCase)
                .distinct()
                .sorted()
                .peek(s ->intermediateResults.add(s))
                .collect(Collectors.toList());

        //Print intermediate
        System.out.println("\nIntermediate Results:");
        intermediateResults.forEach(System.out::println);

        //Print the final result
        System.out.println("\nFinal Results:");
        results.forEach(System.out::println);

        System.out.println("------------------------Terminal Operation-----------------------------------");

        List<String> names = Arrays.asList(
                "Reflection","Collection","Stream",
                "Structure","State","Sorting");

        //For Each
        System.out.println("for Each:");
        names.stream().forEach(System.out::println);

        //Collect strings that starts with s
        List<String> snames = names.stream()
                .filter(name -> name.startsWith("S"))
                .collect(Collectors.toList());
        System.out.println("\nNames that starts with s:");
        snames.forEach(System.out::println);

        //reduce:Concatenate all names into single stream
        String concatenate = names.stream()
                .reduce(""
                        ,(partialString ,element) -> partialString + " " + element);
        System.out.println("\nConcatenated names:");
        System.out.println(concatenate.trim());

        //Count the number of names
        long count = names.stream().count();
        System.out.println("\nCount:");
        System.out.println(count);

        //FindFirst: Find the first name
        Optional<String> fname = names.stream().findFirst();
        System.out.println("\nFirst names:");
        fname.isPresent();

        //allmatch:Check if all the names starts with s
        boolean allStartsWithS = names.stream().allMatch(
                name -> name.startsWith("S"));
        System.out.println("\nAllMatch:");
        System.out.println(allStartsWithS);

        //anyMatch:Check if any name match with S
        boolean anyStarts = names.stream().anyMatch(
                name -> name.startsWith("S")
        );
        System.out.println("\nAnyMatch:");
        System.out.println(anyStarts);

    }

}