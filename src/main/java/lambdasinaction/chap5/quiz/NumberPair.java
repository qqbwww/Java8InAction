package lambdasinaction.chap5.quiz;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by qianqb on 16/9/28.
 * 返回所有数对
 */
public class NumberPair {

    public static void main(String[] args) {
        List<Integer> number1 = Arrays.asList(1,2,3);
        List<Integer> number2 = Arrays.asList(3,4);

        List<int[]> pairs =
                number1.stream().flatMap(i-> number2.stream().map(j -> new int[]{i,j}))
                .collect(toList());

        pairs.stream().forEach(array-> System.out.println(array[0]+"-" + array[1] ));


        pairs.stream().filter(array->(array[0]+array[1])%3==0 ).forEach(array->System.out.println(array[0]+"-" + array[1]));
    }

    public void better(){
        List<Integer> number1 = Arrays.asList(1,2,3);
        List<Integer> number2 = Arrays.asList(3,4);

        List<int[]> pairs =
                number1.stream()
                        .flatMap(i-> number2.stream().filter(j->(i+j)%3==0)
                        .map(j -> new int []{i,j}))
                .collect(toList());



    }
}
