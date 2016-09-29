package lambdasinaction.chap7;

import java.util.stream.*;

public class ParallelStreams {

    /**
     * 1~n的数字求和
     * @param n
     * @return
     */
    public static long iterativeSum(long n) {
        long result = 0;
        for (long i = 0; i <= n; i++) {
            result += i;
        }
        return result;
    }

    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).reduce(Long::sum).get();
    }

    /**
     * 并行化
     * @param n
     * @return
     */
    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(Long::sum).get();
    }

    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n).reduce(Long::sum).getAsLong();
    }

    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n).parallel().reduce(Long::sum).getAsLong();
    }

    public static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).forEach(accumulator::add);
        return accumulator.total;
    }

    public static long sideEffectParallelSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }

    public static class Accumulator {
        private long total = 0;

        public void add(long value) {
            total += value;
        }
    }

    public static void main(String[] args) {
        Long num = 10000l;
        System.out.println(iterativeSum(num));
        System.out.println(sequentialSum(num));
        System.out.println(parallelSum(num));
        System.out.println(rangedSum(num));
        System.out.println(parallelRangedSum(num));
        System.out.println(sideEffectSum(num));
        System.out.println(sideEffectParallelSum(num));

        //系统可用核数
        System.out.println(Runtime.getRuntime().availableProcessors());
        //改变并行线程池大小
        System.setProperty("jav.util.concurrent.ForkJoinPool.common.parallelism","12");

    }
}
