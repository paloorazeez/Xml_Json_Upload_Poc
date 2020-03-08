package com.example.Liyakhat_Poc.controller;

import com.example.Liyakhat_Poc.model.EmployeeCard;
import com.example.Liyakhat_Poc.service.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    @Autowired
    private ICardService cardService;

    @RequestMapping(value = "/getFreeCards", produces = "text/plain")
    public void findFreeCards(HttpServletResponse response)
    {
        EmployeeCard[] freeCards = cardService.getFreeCards();

        try {

                ICsvBeanWriter csvwriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
                String[] header = { "Number" };
                csvwriter.writeHeader(header);

                for (EmployeeCard card : freeCards) {
                        csvwriter.write(card, header);
                    }
        csvwriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
