package com.example;

import java.util.List;

public class Alex extends Lion {
    Feline feline;

    public Alex(Feline feline) throws Exception {
        super("Самец", feline);
        this.feline = feline;

    }

    public List<String> getFriends() {
        return List.of("Мартин", "Глория", "Мелман");
    }

    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }

    @Override
    public int getKittens() {
        return 0;
    }

    public String getFamily() {
        return feline.getFamily();
    }

}
