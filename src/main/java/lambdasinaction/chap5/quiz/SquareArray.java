package lambdasinaction.chap5.quiz;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by qianqb on 16/9/28.
 * 返回平方
 */
public class SquareArray {

    public static void main(String[] args) {
        Integer[] iArray = {1,2,3,4};
        Stream<Integer> iStream = Arrays.stream(iArray);
        List<Integer> squares = iStream.map(x->x*x).collect(Collectors.toList());
        squares.stream().forEach(e-> System.out.println(e));
    }
}
