package com.example;

import java.util.List;

public class Lion {

    private boolean hasMane;
    Feline feline; // = new Feline();
    public Lion(String sex, Feline feline) throws Exception {
        this.feline = feline;
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - Самец или Самка");
        }
    }

    public int getKittens() {
        return feline.getKittens();
    }
    public int getKittens(int kittensCount) {
        return feline.getKittens(kittensCount);
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return feline.eatMeat(); //.getFood("Хищник");
    }
}
