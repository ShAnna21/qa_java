package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CatTest {

    @Mock
    Feline feline;

    private Cat cat;

@BeforeEach
public void setUp() { cat = new Cat(feline); }

    @Test
    public void getSoundTest() {
        String expected = "Мяу";
        String actual = cat.getSound();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getFoodTestEatCat() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expected);
        List<String> actual = cat.getFood();
        Assertions.assertEquals(expected,actual);
    }
}