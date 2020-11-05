package com.example.springbootcache.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {
    public static void main(String args[]){
        //System.out.println("Hi");
       // test12344(i -> i+"hello");
        List<List<String>> list =  new ArrayList<>();
        List<String> s1 = Arrays.asList(new String[]{"gani", "Gani1"});
        List<String> s2 = Arrays.asList(new String[]{"gani11", "Gani111"});
        List<String> s3 = Arrays.asList(new String[]{"gani111", "Gani1111"});
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.stream().flatMap(x -> x.stream()).filter(x -> x.equals("gani")).forEach(
                x -> System.out.println(x));


        List<String> k1 = Arrays.asList("Hi","Hello","Hi","Hello");
        Map<String,Long> h1= k1.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        h1.forEach((k,j) -> System.out.println(k +" "+j));


    }

    public static void test12344(test1 r){
       String g =  r.test1234(2);
       System.out.println(g);
    }
}

@FunctionalInterface
interface test1 {
    String test1234(int j);
}
