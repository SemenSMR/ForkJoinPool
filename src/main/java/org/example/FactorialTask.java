package org.example;

import java.util.concurrent.RecursiveTask;

public class FactorialTask extends RecursiveTask<Long> {
    public final int n;

    public FactorialTask(int n) {
        this.n = n;
    }

    @Override
    protected Long compute() {
        if (n == 0 || n == 1) {
            return 1L;
        }


        FactorialTask factorialTask = new FactorialTask(n - 1);
        factorialTask.fork();

        long result = n * factorialTask.join();

        return result;
    }
}

