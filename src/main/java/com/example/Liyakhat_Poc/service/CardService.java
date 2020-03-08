package com.example.Liyakhat_Poc.service;

import com.example.Liyakhat_Poc.entity.CardRepository;
import com.example.Liyakhat_Poc.entity.DBEmpCard;
import com.example.Liyakhat_Poc.model.EmployeeCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class CardService implements ICardService {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public EmployeeCard[] getFreeCards() {

        List<DBEmpCard> freeCards = cardRepository.findFreeCards();
        EmployeeCard[] cardList = new EmployeeCard[(freeCards != null)?freeCards.size():0];;
        if(!CollectionUtils.isEmpty(freeCards)) {

            IntStream.range(0, freeCards.size()).forEach(index -> {
                EmployeeCard card = new EmployeeCard();
                card.setNumber(freeCards.get(index).getNumber());
                cardList[index] = card;


            });
        }

        return cardList;
    }
}
