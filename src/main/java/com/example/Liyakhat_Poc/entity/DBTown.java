package com.example.Liyakhat_Poc.entity;

import com.example.Liyakhat_Poc.model.Town;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

@Entity
@Table(name = "towns")
public class DBTown implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String name;

    private int population;

    //@OneToMany(cascade = CascadeType.ALL)
   // @JoinColumn(name = "town_id")
    @JsonIgnore
    @OneToMany
    private List<DBBranch> branchList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<DBBranch> getBranchList() {
        return branchList;
    }

    public void setBranchList(List<DBBranch> branchList) {
        this.branchList = branchList;
    }

    public DBTown(){

    }

    public DBTown(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public DBTown(Town town) {
       this(town.getName(), town.getPopulation());
        //this.name = town.getName();
        //this.population = town.getPopulation();
    }

    @Override
    public String toString() {
        return "DBTown{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", population=" + population +
                '}';
    }
}
