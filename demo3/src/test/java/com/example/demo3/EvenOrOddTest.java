package com.example.demo3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class EvenOrOddTest {
    //paramterisedtest:- if we want to supply our method with multiple edgecases as parameters directly then we are
    //                   going to use the paramterised Test. We need to add an additional dependency junit-jupiter-params

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv",numLinesToSkip = 1)
    public void testEvenOrodd(String input, String expected){
        EvenOrOdd eo= new EvenOrOdd();
        assertEquals(expected,eo.evenOrOddNum((int)Integer.parseInt(input)));
    }

}