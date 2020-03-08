package com.example.Liyakhat_Poc.model;

import lombok.Data;

public @Data class Town {


    private  String name;
    private int population;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
