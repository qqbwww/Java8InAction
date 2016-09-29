package lambdasinaction.chap4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 流只能消费一次
 * Created by qianqb on 16/9/28.
 */
public class IteratorOnce {

    public static void main(String[] args) {
        List<String> title = Arrays.asList("Java8","In","Action");
        Stream<String> s = title.stream();
        s.forEach(System.out::println);
        //已消费过,会抛异常
        s.forEach(System.out::println);
    }
}
