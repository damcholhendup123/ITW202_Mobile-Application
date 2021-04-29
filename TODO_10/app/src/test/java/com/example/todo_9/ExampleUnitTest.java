package com.example.todo_9;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)

public class ExampleUnitTest {
  private Calculator mCalculator;


@Before
public void setUp(){
    mCalculator = new Calculator();
}



@Test
//Add more tests for the add() method. Add unit tests for the other calculation methods as well
public void AddTwoNumbers(){
    double result = mCalculator.Add(1d,5d);
    assertThat(result, is(equalTo(6d)));
}
@Test
    public void AddTwoNumbersNegative(){
    double result = mCalculator.Add(-1d, 2d);
    assertThat(result, is(equalTo(1d)));
}



 @Test
 //Add a unit test called subTwoNumbers() that tests the sub() method.
 public void SubTwoNumbers(){
     double result = mCalculator.Sub(1d, 2d);
     assertThat(result, is(equalTo(-1d)));
 }
    @Test
    //Add a unit test called subWorksWithNegativeResults()
    // that tests the sub() method where the given calculation results in a negative number.
    public void SubWorkWithNegativeResults(){
        double result = mCalculator.Sub(-2d, -1d);
        assertThat(result, is(equalTo(-1d)));
    }




    @Test
    //Add a unit test called mulTwoNumbers() that tests the mul() method.
    public void MulTwoNumbers(){
        double result = mCalculator.Mul(1d, 2d);
        assertThat(result, is(equalTo(2d)));
    }
    @Test
    //Add a unit test called mulTwoNumbersZero() that tests the mul() method with at least one argument as zero.
    public void MulTwoNumbersZero(){
        double result = mCalculator.Mul(11d, 0d);
        assertThat(result, is(equalTo(0d)));
    }





    @Test
    //Add a unit test called divTwoNumbers() that tests the div() method with two non-zero arguments.
    public void DivTwoNumbers(){
        double result = mCalculator.Div(2d, 2d);
        assertThat(result, is(equalTo(1d)));
    }

//Add a unit test called divTwoNumbersZero() that tests the div()
// method with a double dividend and zero as the divider.
    @Test(expected = IllegalArgumentException.class)
    public void DivTwoNumbersZero(){
        double result = mCalculator.Div(2d, 0d);
          }






}