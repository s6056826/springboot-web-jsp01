package cn.dbw.springboot.springbootwebjsp;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Java8Test {
    @Test
    public void test1(){
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players =  Arrays.asList(atp);
         //players.forEach(System.out::println);
    }
}
