package com.example.Liyakhat_Poc.controller;

import com.example.Liyakhat_Poc.model.EmployeeCard;
import com.example.Liyakhat_Poc.service.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    @Autowired
    private ICardService cardService;

    @RequestMapping("/getFreeCards")
    public List<EmployeeCard> findFreeCards()
    {
        return cardService.getFreeCards();
    }
}
