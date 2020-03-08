package com.example.Liyakhat_Poc.model;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee
{
    @XmlAttribute
    private String position;

    @XmlElement(name = "branch")
    private String branch;

    @XmlAttribute(name = "first-name")
    private String firstName;

    @XmlElement(name = "card")
    private String card;

    @XmlAttribute(name = "last-name")
    private String lastName;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return " \n Employee{" +
                "position='" + position + '\'' +
                ", branch='" + branch + '\'' +
                ", firstName='" + firstName + '\'' +
                ", card='" + card + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

