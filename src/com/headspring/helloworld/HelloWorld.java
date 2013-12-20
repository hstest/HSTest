package com.headspring.helloworld;

import com.headspring.fizzbuzz.FizzBuzz;

/**
 * Created by Uri on 12/19/13.
 */
public class HelloWorld
{

    static public void main(String... args)
    {
        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.fizzBuzz(0, 100);
    }
}
