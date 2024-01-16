package java8.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> l;
        list.add(3);
        list.add(2);
        list.add(4);
        list.add(1);
        System.out.println("Original List : " + list);

        //filter
        System.out.println("Even elements in the list are: ");
        l = list.stream()
        .peek(System.out::println) //just to check
        .filter(i -> i % 2 == 0).toList();
        System.out.println(l);
        // list.stream().filter(i -> i % 2 == 0).forEach(System.out::println);

        //map
        l = list.stream().map(i -> i * 2).toList();
        System.out.println("Elements multiplied by 2 in the list are: "+ l);

        //sorted stream of l
        l = l.stream().sorted().toList();
        System.out.println("Sorted Stream Elements: "+l);
        
        //reverse sorted stream of l
        l = l.stream().sorted((a,b)->b.compareTo(a)).toList();
        System.out.println("Reverse Sorted Stream Elements: "+l);
        
        //min
        Integer min = l.stream().min((a,b)->a.compareTo(b)).get();
        System.out.println("Minimum element is: "+min);

        //max
        Integer max = l.stream().max((a,b)->a.compareTo(b)).get();
        System.out.println("Maximum element is: "+max);
        
        //forEach
        l.stream().forEach((s)->System.out.print(s+" "));
        l.stream().forEach(System.out::print);

        //toArray
        Integer arr[] = l.toArray(Integer[]::new);
        System.out.println("\nArray Representation of List:");
        for (int i=0; i < arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }

        long n = Stream.of(arr).count();
        System.out.println("\nNumber of elements in Array: "+n);

        
    }
}
