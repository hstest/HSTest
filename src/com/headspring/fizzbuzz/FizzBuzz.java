package com.headspring.fizzbuzz;

/**
 * Created by Uri on 12/20/13.
 */
public class FizzBuzz
{
    ITask[] aTasks;

    /**
     * Default behavior defaults to original behavior
     */
    public FizzBuzz()
    {
        setTasks(new DivXTask(3, "fizz"),
                 new DivXTask(5, "buzz"));
    }

    public FizzBuzz setTasks(ITask... aTasks)
    {
        this.aTasks = aTasks;
        return this;
    }

    protected String fazz(int i)
    {
        String rslt = "";
        for(ITask task:aTasks)
        {
            if (task.test(i))
            {
                rslt += !rslt.equals("") ? " " + task.description() : task.description();
            }
        }
        if (rslt.equals("")) rslt += String.valueOf(i);
        return rslt;
    }

    public void fizzBuzz(int min, int max)
    {
        for(int i=min; i<=max; i++)
        {
            System.out.println(fazz(i));
        }
    }

    /**
     * Convenience class... task pass if input is divisible by divisor
     * Outputs description
     */
    public static class DivXTask implements ITask
    {
        final int divisor;
        final String desc;

        public DivXTask(int divisor, String desc)
        {
            this.divisor = divisor;
            this.desc = desc;
        }

        @Override
        public boolean test(int i) {
            return i%divisor == 0;
        }

        @Override
        public String description() {
            return desc;
        }
    }

    /**
     * Support arbitrary operators, replace Task
     * Modify library to support outputting the user wants instead of just the console.
     * jeff@headspring.com
     */
}