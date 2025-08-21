package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class LionTest {

    private Feline feline;
    private Lion lion;

    @BeforeEach
    public void setUp() throws Exception {
        feline = Mockito.mock(Feline.class);
        lion = new Lion(feline, "Самец");
    }

    @Test
    public void getKittensPositiveNumberPositiveResult() {
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expected = 1;
        int actual = lion.getKittens();
        Assertions.assertEquals (expected, actual);
    }

    @Test
    public void doesHaveManeCheckValidSex() {
        Exception exception = Assertions.assertThrows(Exception.class, () -> new Lion(feline, "Неверно указан пол"));
        String expected = "Используйте допустимые значения пола животного - самец или самка";
        String actual = exception.getMessage();
        Assertions.assertTrue(actual.contains(expected));
    }

    @Test
    public void getFoodCorrectForLion() throws Exception {
        List<String> expected = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
        List<String> actual = lion.getFood();
        Assertions.assertEquals(expected, actual);
    }
}