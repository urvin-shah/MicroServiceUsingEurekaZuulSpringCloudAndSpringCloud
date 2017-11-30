package com.urvin.stockservice.service;

import com.urvin.stockservice.domain.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import javax.xml.ws.Response;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockService {
    @Autowired
    RestTemplate restTemplate;

    public List<Quote> getQuoteByUser(String username) {
        ResponseEntity<List<String>> quotesResponse = restTemplate.exchange("http://db-service/rest/db/" + username, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<String>>() {
                });

        List<String> quotes = quotesResponse.getBody();

        return quotes.stream()
                .map(quote -> {
                    Stock stock = getStockPrice(quote);
                    return new Quote(quote,stock.getPrice());
                })
                .collect(Collectors.toList());
    }

    private Stock getStockPrice(String quote) {
        try {
            System.out.println("The value of quote:" + quote);
            return new Stock("GOOG",15.00);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
class Stock {
    private String name;
    private double price;

    public Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}