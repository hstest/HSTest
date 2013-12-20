package com.headspring.fizzbuzz;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Uri on 12/20/13.
 */
public class FizzBuzzTest
{
    private FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    public void testDiv3Only()
    {

        assertThat(fizzBuzz.fazz(3), is("fizz"));
        assertThat(fizzBuzz.fazz(33), is("fizz"));
        assertThat(fizzBuzz.fazz(99), is("fizz"));
    }

    @Test
    public void testDiv5Only()
    {
        assertThat(fizzBuzz.fazz(5), is("buzz"));
        assertThat(fizzBuzz.fazz(20), is("buzz"));
        assertThat(fizzBuzz.fazz(85), is("buzz"));
    }

    @Test
    public void testDivByBoth()
    {
        assertThat(fizzBuzz.fazz(15), is("fizz buzz"));
        assertThat(fizzBuzz.fazz(30), is("fizz buzz"));
        assertThat(fizzBuzz.fazz(45), is("fizz buzz"));
    }

    @Test
    public void testDivByNone()
    {
        assertThat(fizzBuzz.fazz(4), is("4"));
        assertThat(fizzBuzz.fazz(13), is("13"));
    }

    @Test
    public void testFizzDivX()
    {
        fizzBuzz.setTasks(new FizzBuzz.DivXTask(3, "hello"),
                          new FizzBuzz.DivXTask(5, "world"));
        assertThat(fizzBuzz.fazz(3), is("hello"));
        assertThat(fizzBuzz.fazz(5), is("world"));
    }

    @Test
    public void testITask()
    {
        ITask task1 = new ITask() {
            @Override
            public boolean test(int i) {
                return i % 13 == 0 ;
            }

            @Override
            public String description()
            {
                return "task1";
            }
        };

        ITask task2 = new ITask() {
            @Override
            public boolean test(int i) {
                return i % 7 == 0;
            }

            @Override
            public String description() {
                return "task2";
            }
        };
        fizzBuzz.setTasks(task1, task2);
        assertThat(fizzBuzz.fazz(13), is(task1.description()));
        assertThat(fizzBuzz.fazz(7), is(task2.description()));
        assertThat(fizzBuzz.fazz(13*7), is(task1.description()+" "+task2.description()));
        assertThat(fizzBuzz.fazz(2), is("2"));
    }

    @Test
    public void testOutputToFile() throws FileNotFoundException
    {
        Random random = new Random();
        String fileName = "outtest"+random.nextInt()+".txt";
        File file = new File(fileName);
        fizzBuzz.setOutput(new PrintStream(file));
        fizzBuzz.fizzBuzz(1,50);
        assertThat(file.exists(), is(true));
    }

}
