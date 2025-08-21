package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

public class LionParametrizedTest {

    private Feline feline;

    @BeforeEach
    public void setUp() {
        feline = Mockito.mock(Feline.class);
    }
    @ParameterizedTest
    @MethodSource ("data")
    public void LionParameterizedTest(String sex, boolean hasMane) throws Exception {
        Lion lion = new Lion(feline, sex);
        boolean expected = hasMane;
        boolean actual = lion.doesHaveMane();
        Assertions.assertEquals(expected, actual);

    }
    public static Object[][] data() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }
}
