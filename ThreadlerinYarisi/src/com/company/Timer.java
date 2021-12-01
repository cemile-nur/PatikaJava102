package com.company;

public class Timer implements Runnable{

    int index;

    public Timer() {
        this.index = 0;
    }

    @Override
    public void run() {
        int number = Main.numbers.get(index);

        if (number % 2 == 0)
            Main.even.add(number);
        else
            Main.odd.add(number);

        System.out.println("İş bitti. "
                + Thread.currentThread().getName()
                + " Even Size:" + Main.even.size()
                + " Odd Size: " + Main.odd.size());
        index++;
    }
}
