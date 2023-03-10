package chp12;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LimitWithStream {
    public static void main(String[] args) {
        List<String> strings = List.of("I","am","a","list","of","Strings");
        System.out.println("strings : "+strings);
        Stream<String> stream = strings.stream();
        Stream<String> limit = stream.limit(4);
        System.out.println("limit : "+limit);
        List<String> result = limit.collect(Collectors.toList());
        System.out.println("result : "+result);

        List<String> result2 = strings.stream()
                                    .sorted((one,two)-> one.compareToIgnoreCase(two))
                                    .skip(2)
                                    .limit(4)
                                    .collect(Collectors.toList());
        System.out.println("result2 : "+result2);

        System.out.println("------------------------");
        System.out.println("strings : "+strings);
        System.out.println("limit : "+limit);
    }
}
