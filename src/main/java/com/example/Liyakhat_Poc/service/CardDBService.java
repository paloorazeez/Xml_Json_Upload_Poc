package com.example.Liyakhat_Poc.service;


import com.example.Liyakhat_Poc.entity.CardRepository;
import com.example.Liyakhat_Poc.entity.DBEmpCard;
import com.example.Liyakhat_Poc.entity.DBTown;
import com.example.Liyakhat_Poc.model.EmployeeCard;
import com.example.Liyakhat_Poc.model.Town;
import com.example.Liyakhat_Poc.util.IJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.IntStream;


@Service
public class CardDBService implements IDBService {

    @Autowired
    private IJsonUtil jsonUtil;

    @Autowired
    private CardRepository cardRepository;

    @Override
    public <T> void process(String input) {
        //convert the json to pojo
        EmployeeCard[] cards = jsonUtil.parseJsonString(input, EmployeeCard[].class);
        //convert input pojo to enitiy
        DBEmpCard[] dbEmpCards = convertToDBEntity(cards);
        Arrays.stream(dbEmpCards).forEach(System.out::println);
        //persist
        cardRepository.saveAll(Arrays.asList(dbEmpCards));
    }

    private DBEmpCard[] convertToDBEntity(EmployeeCard[] cards) {

        DBEmpCard[] dbEmpCards = new DBEmpCard[cards.length];
        IntStream.range(0,cards.length).forEach(index->
        {
            DBEmpCard dbEmpCard = new DBEmpCard(cards[index]);
            dbEmpCards[index] = dbEmpCard;
        });
        return dbEmpCards;
    }
}
