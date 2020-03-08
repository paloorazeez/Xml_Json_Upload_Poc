package com.example.Liyakhat_Poc.model;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Product
{
    @XmlAttribute(required = true)
    private Integer clients;

    @XmlAttribute(required = true)
    private String name;

    @XmlElement(name = "branch")
    private String branch;


    public Integer getClients() {
        return clients;
    }

    public void setClients(Integer clients) {
        this.clients = clients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public String toString()
    {
        return " \n Product [clients = "+clients+", name = "+name+", branch = "+branch+"] \n";
    }
}

