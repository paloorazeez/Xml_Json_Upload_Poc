package com.example.Liyakhat_Poc.entity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CardRepository extends CrudRepository<DBEmpCard, Long> {
    DBEmpCard findByNumber(String card);

    @Query(" Select c from DBEmpCard c where c not in(select e.card from  DBEmployee e) ")
    List<DBEmpCard> findFreeCards();
}
