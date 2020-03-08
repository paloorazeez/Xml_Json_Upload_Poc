package com.example.Liyakhat_Poc.service;

import com.example.Liyakhat_Poc.entity.CardRepository;
import com.example.Liyakhat_Poc.entity.DBEmpCard;
import com.example.Liyakhat_Poc.model.EmployeeCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService implements ICardService {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public List<EmployeeCard> getFreeCards() {

        List<EmployeeCard> cardList = new ArrayList<>();
        List<DBEmpCard> freeCards = cardRepository.findFreeCards();
        if(!CollectionUtils.isEmpty(freeCards))
        {
            freeCards.forEach(dc->{
                EmployeeCard card = new EmployeeCard();
                card.setNumber(dc.getNumber());
                cardList.add(card);
            });
        }

        return cardList;
    }
}
