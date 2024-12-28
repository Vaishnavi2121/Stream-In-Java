import java.util.*;
import java.util.stream.Collectors;
public class Practice {

public static void main(String[] args) {

            List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

            //Print sum
            Optional<Integer> sum = list.stream().reduce((a, b) -> a+b);
            System.out.println("sum:"+sum.get());

            //Print average
            double avg = list.stream().mapToInt(e -> e).average().getAsDouble();
            System.out.println("average:"+avg);

            List<Integer> list1 = Arrays.asList(10,20,30,40,50);

            //Square of each number,skip the squares if less than 100, average of remaining
            double filtered = list1.stream()
                    .map(e -> e*e)
                    .filter(e -> e>100)
                    .mapToInt(e -> e)
                    .average()
                    .getAsDouble();

            System.out.println("Filtered list:"+filtered);

            //Print even and odd numbers from the list
            List<Integer> list2 = Arrays.asList(1,3,2,5,56,76,45,88,97,43,10,20,30,40,50);

            List<Integer> evenList = list2.stream()
                    .filter(e -> e%2==0)
                    .collect(Collectors.toList());

            System.out.println("Even list:"+evenList);

            List<Integer> oddList = list2.stream()
                    .filter(e -> e%2!=0)
                    .collect(Collectors.toList());

            System.out.println("Odd list:"+oddList);

            //Find Duplicates
            List<Integer> l = Arrays.asList(1,2,3,2,5,7,4,9,24,43,5,65,45,23,99,100,65);

            Set<Integer> dup = l.stream()
                    .filter(e -> Collections.frequency(l,e)>1)
                    .collect(Collectors.toSet());
            System.out.println("Duplicate list:"+dup);

            //Min and Max
            int max = l.stream().max(Comparator.comparing(Integer::valueOf)).get();
            System.out.println(max);
            int min = l.stream().min(Comparator.comparing(Integer::valueOf)).get();
            System.out.println(min);

            //Ascending and Descending
            List<Integer> asc = l.stream()
                    .sorted()
                    .collect(Collectors.toList());

            System.out.println("Ascending list:"+asc);

            List<Integer> desc = l.stream()
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList());
            System.out.println("Descending list:"+desc);

            //Ignore numbers

            List<Integer> lm = l.stream()
                    .limit(12).collect(Collectors.toList());
            System.out.println(lm);

            int sum1 = l.stream().limit(12).reduce((a,b) -> a+b).get();
            System.out.println(sum1);
            //skip
            List<Integer> sk = l.stream().skip(12).collect(Collectors.toList());
            System.out.println(sk);

            int  sksum = l.stream().skip(12).reduce((a,b) -> a+b).get();
            System.out.println(sksum);
            int count = (int) l.stream().count();
            System.out.println(count);

            //get second highest number

            int secH = l.stream().sorted(Collections.reverseOrder()).distinct().skip(1).findFirst().get();
            System.out.println(secH);
            //Second lowest
            int secL = l.stream().sorted().distinct().skip(1).findFirst().get();
            System.out.println(secL);
        }
    }
