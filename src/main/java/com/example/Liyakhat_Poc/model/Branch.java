package com.example.Liyakhat_Poc.model;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public  class Branch {

    private String name;
    private String town;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "name='" + name + '\'' +
                ", town='" + town + '\'' +
                '}';
    }
}
