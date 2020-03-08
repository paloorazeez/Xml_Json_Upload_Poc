package com.example.Liyakhat_Poc.model;

import lombok.Data;

public @Data class EmployeeCard {


    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
