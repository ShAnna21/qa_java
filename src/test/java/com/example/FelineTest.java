package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

public class FelineTest {
    private Feline feline;

    @BeforeEach
    public void setUp() { feline = new Feline(); }

    @Test
    public void eatMeatTest()  throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = feline.eatMeat();
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void getFamilyTest() {
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getKittensCountTest() {
        int expected = 1;
        int actual= feline.getKittens();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void getKittensParametrizedTest() {
        int expected = new Random().nextInt(15);
        int actual = feline.getKittens(expected);
        Assertions.assertEquals(expected,actual);
    }

}