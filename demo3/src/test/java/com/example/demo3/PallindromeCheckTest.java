package com.example.demo3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PallindromeCheckTest {
    //paramterisedtest:- if we want to supply our method with multiple edgecases as parameters directly then we are
    //                   going to use the paramterised Test. We need to add an additional dependency junit-jupiter-params

    @ParameterizedTest
    @ValueSource(strings={"racecar","radar","elle","suheab"})
    public void testIsPallindrome(String str){
        PallindromeCheck pc= new PallindromeCheck();
        assertEquals(true,pc.isPallindrome(str));
    }

}