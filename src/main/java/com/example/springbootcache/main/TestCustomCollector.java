package com.example.springbootcache.main;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class TestCustomCollector {
    public static void main(String args[]){
        System.out.println("Hello");

        Map<String,Integer> hp = new HashMap<>();
        hp.put("maths",12);
        hp.put("English",13);

        Map<String,Integer> hp1 = new HashMap<>();
        hp.put("maths",22);
        hp.put("Science",13);

        Map<String,Integer> hp2 = new HashMap<>(hp);
        hp1.forEach((key ,Value) -> hp2.merge(key,Value, (v1 , v2) -> v1+v2));

        hp2.forEach((k,v) -> System.out.println(k +"Test"+v));


        List<Double> numbers = Arrays.asList(1.0, 1.1, 1.4, 1.7, 1.4, 5.4, 9.9);
        Map<Integer, Integer> histogram = numbers.stream().collect(toHistogram(1));
        histogram.forEach((k,v) -> System.out.println(k+" "+v));
    }

    public static HistagramCollector toHistogram(int bucketSize) {
        return new HistagramCollector(bucketSize);
    }





}

class HistagramCollector implements Collector<Double, Map<Integer, Integer>,Map<Integer, Integer>> {
    private int bucketSize;
    HistagramCollector(int bucketSize) {
        this.bucketSize = bucketSize;
    }

    @Override
    public Supplier<Map<Integer, Integer>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<Integer, Integer>, Double> accumulator() {
        return (map, val) -> map.merge((int)(val / bucketSize), 1,
                            (a, b) -> a + 1);

    }

    @Override
    public BinaryOperator<Map<Integer, Integer>> combiner() {
        return (map1, map2) -> {
            map2.forEach((k, v) -> map1.merge(k, v, (v1, v2) -> v1 + v2));
            return map1;
        };
    }

    @Override
    public Function<Map<Integer, Integer>, Map<Integer, Integer>> finisher() {
       return  Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        Set<Characteristics> t1 =  new HashSet<>();
        t1.add(Characteristics.CONCURRENT);
        t1.add( Characteristics.UNORDERED);
        return t1;
    }
}