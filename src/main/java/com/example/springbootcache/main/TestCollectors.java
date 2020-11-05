package com.example.springbootcache.main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestCollectors {

    public static void main(String args[]){
        System.out.println("Hi am here");

        List<String> k1 = new ArrayList<>() ;
        k1.add("k1");
        k1.add("k2");
        k1.add("k3");
        k1.add("k4");







        List<Rating> k =  new ArrayList<>();
        k.add(new Rating(1));
        k.add(new Rating(5));
        k.add(new Rating(6));
        k.add(new Rating(8));
        SummarizedRatings sr = k.stream().collect(Collectors.collectingAndThen(
                Collectors.groupingBy(
                        i -> {
                          int mark  =    i.getMark() ;
                          if (mark >= 4 && mark <= 6) {
                              return RatingLevel.AVERAGE;
                          }
                          else if(mark < 4) {
                              return RatingLevel.BAD;
                          }
                          return RatingLevel.GOOD ;
                        } , Collectors.counting()
                ) ,
                m -> {
                    float prctGood = m.getOrDefault(RatingLevel.GOOD,
                            0L) / (float) k.size();
                    float prctAverage = m.getOrDefault(RatingLevel.AVERAGE,
                            0L) / (float) k.size();
                    float prctBad = m.getOrDefault(RatingLevel.BAD,
                            0L) / (float) k.size();
                    return new SummarizedRatings(prctGood, prctAverage, prctBad);
                }
        ));
      System.out.println(sr);
    }
}

enum RatingLevel {
    GOOD, AVERAGE, BAD
}

class Rating {
    public int getMark() {
        return mark;
    }

    private final int mark ;
    public Rating(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "mark=" + mark +
                '}';
    }
}

class SummarizedRatings {

    private float prctGood ;
    private float prctAverage ;
    private float prctBad;

    public SummarizedRatings(float prctGood, float prctAverage, float prctBad) {
        this.prctGood = prctGood;
        this.prctAverage = prctAverage;
        this.prctBad = prctBad;
    }

    public float getPrctGood() {
        return prctGood;
    }

    public void setPrctGood(float prctGood) {
        this.prctGood = prctGood;
    }

    public float getPrctAverage() {
        return prctAverage;
    }

    public void setPrctAverage(float prctAverage) {
        this.prctAverage = prctAverage;
    }

    public float getPrctBad() {
        return prctBad;
    }

    public void setPrctBad(float prctBad) {
        this.prctBad = prctBad;
    }

    @Override
    public String toString() {
        return "SummarizedRatings{" +
                "prctGood=" + prctGood +
                ", prctAverage=" + prctAverage +
                ", prctBad=" + prctBad +
                '}';
    }
}



