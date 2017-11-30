package com.urvin.stockservice.resource;

import com.netflix.discovery.converters.Auto;
import com.urvin.stockservice.domain.Quote;
import com.urvin.stockservice.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import yahoofinance.Stock;

import java.util.List;

@RestController
@RequestMapping("/rest/stock")
public class StockResource {

    @Autowired
    StockService stockService;

    @GetMapping("{username}")
    public List<Quote> getStock(@PathVariable("username") String username) {
        return stockService.getQuoteByUser(username);
    }
}
