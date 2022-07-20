package com.example.demo3;

import org.junit.Test;
import org.junit.jupiter.api.*;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests of a Calculator Operations")
class CalculatorTest {


    //concept:-
    //1. Manage the lifecycle of a test, means when does the instances created in the test class and when are they destroyed.
    //2. Donot use any variables instantiated only once
    //3. Instead we need the one different instance as we dont know the order of execution of the tests
    //4. There is a restriction on the usage of beforeAll and AfterAll annotations, they get executed even before , beforeEach
    //    annotation resulting in , the instances are not available to it. Only way to use those are making methods as static.


    //process
    //1.create the instance of the class under test
    //2.setup your expected output for your choice of input
    //3.Execute the code you want to test
    //4.verify the result is what you expect

    Calculator calculatorInstance;

    @BeforeEach
    void init() {
        calculatorInstance = new Calculator();
    }

//    @AfterEach
//    void cleanUp(){
      //calculatorInstance=null;
//    }

    @Test
    @Tag("calculator")
   @DisplayName("Addition of two numbers")
    public void addTwoNumbersTest() {
        //create the instance of the class under the test if its not a static method

//        Calculator calculatorInstance = new Calculator();

        //my expected output
        int expected = 2;
        //my expected inputs
        int number1 = 1, number2 = 1;
        //method call
        int actual = calculatorInstance.addNumbers(number1, number2);
        assertEquals(expected, actual);
    }

    @Test
    @Tag("calculator")
    @DisplayName("Division of two numbers")
    public void divisionOfTwoNumbersExceptionHandlingTest() {

        //Calculator calculatorInstance = new Calculator();

        //my expected output
        int expected = 2;
        //my expected inputs
        int number1 = 10, number2 = 5;
        //call the method

        //happy case
//        assertEquals(expected,
//                calculatorInstance.divideNumbers(number1, number2),
//                //Now using lambda here helps in, computing this string only if the test fails, not when it is passed.
//                () -> "Divide by zero should throw an arthimetic exception"
//        );

        //1.Fails as it will throw arthimetic exception, but we are expecting a NullPointerException
//        assertThrows(NullPointerException.class,
//                () -> calculatorInstance.divideNumbers(number1,0),
//        "Divide by zero should throw an arthimetic exception"
//        );

        //2.Fails if it will not throw arthimetic exception
//        assertThrows(ArithmeticException.class,
//                () -> calculatorInstance.divideNumbers(number1,number2),
//                "Divide by zero should throw an arthimetic exception"
//        );

        //3.Success if it throws an exception
        assertThrows(ArithmeticException.class,
                () -> calculatorInstance.divideNumbers(number1, 0),
                "Divide by zero should throw an arthimetic exception"
        );
    }

    @Test
    @Tag("calculator")
    @Disabled
    void testingDisabled() {
        fail("This test is under deveolpment, so must be skipped");
    }

    @Test
    void testingGetRemainderMethod(){

    }
    // 1.assertAll is a mechanism to run the bunch of the tests at once, if you are using multiple assertEquals with multiple
    // conditions then we can use this mechanism.
    @Test
    @Tag("calculator")
    @DisplayName("Mutliplication of two numbers with multiple edge cases")
    void testMultiply() {
        assertAll(
                () -> assertEquals(4, calculatorInstance.multiplyNumbers(2, 2)),
                () -> assertEquals(-4, calculatorInstance.multiplyNumbers(2, -2)),
                () -> assertEquals(4, calculatorInstance.multiplyNumbers(-2, -2)),
                () -> assertEquals(0, calculatorInstance.multiplyNumbers(2, 0))
        );
    }

    //2.Nested class to execute the set of edge cases of a test
    @Nested
    @Tag("calculator")
    class AddTest {

        @Test
        @DisplayName("Addition of two positive numbers")
        void testAddWithPositives() {
            assertEquals(4, calculatorInstance.addNumbers(2, 2));
        }

        @Test
        @DisplayName("Addition of a number with zero")
        void testAddWithPositiveAndZerp() {
            assertEquals(4, calculatorInstance.addNumbers(2, 2));
        }

        @Test
        @DisplayName("Addition of two negative numbers")
        void testAddWithNegatives() {
            assertEquals(-4, calculatorInstance.addNumbers(-2, -2));
        }

        @Test
        @DisplayName("Addition of negative and positive numbers")
        void testAddWithPositiveAndNegative() {
            assertEquals(0, calculatorInstance.addNumbers(2, -2));
        }
    }

    // Repeating the tests multiple times
    @RepeatedTest(3)
    @Tag("calculator")
    @DisplayName("Subtraction of two numbers")
    void subtractTwoNumbers(RepetitionInfo repetitionInfo) {
        int number1 = 0, number2 = 0, expected = 0;
        if (repetitionInfo.getCurrentRepetition() == 1) {
            number1 = 5;
            number2 = 3;
            expected = number1 - number2;
        } else if (repetitionInfo.getCurrentRepetition() == 2) {
            number1 = -5;
            number2 = -3;
            expected = number1 - number2;
        } else if (repetitionInfo.getCurrentRepetition() == 3) {
            number1 = 5;
            number2 = 3;
            expected = number1 - number2;
        }
        assertEquals(expected, calculatorInstance.subtractNumbers(number1, number2));
    }

    //Whenever you want to execute only some set of tests then we can use the @Tag Annotation,
    //Scenarios :- combination of both integration and unit tests, but we need to execute unit tests only
    // We have old unit tests, and also now we are developing new feature then in that case, we need only new unit tests
    //to execute so that it becomes very handy to us
    @Test
    @DisplayName("Area of a circle calculation")
    @Tag("area")
    public void computeAreaOfACircleTest() {
        //create the instance of the class under the test if its not a static method

        //Calculator calculatorInstance = new Calculator();
        //setup inputs and outputs

        assertEquals(314.1592653589793, calculatorInstance.computeCircleArea(10), "Should return this value");
    }
    @Test
    void getStringValue() throws NoSuchFieldException, IllegalAccessException {
        final Field field = calculatorInstance.getClass().getDeclaredField("str");
        field.setAccessible(true);
        field.set(calculatorInstance, "IP");
        //when
        final String result = calculatorInstance.getStr();
        //then
        assertEquals( result, "IP","field wasn't retrieved properly");
    }

    @Test
    void setStringValue() throws NoSuchFieldException,IllegalAccessException{
        //when
        calculatorInstance.setStr("abc");
        //then
        final Field field = calculatorInstance.getClass().getDeclaredField("str");
        field.setAccessible(true);
        assertEquals( field.get(calculatorInstance), "abc","field wasn't set properly");
    }


}
