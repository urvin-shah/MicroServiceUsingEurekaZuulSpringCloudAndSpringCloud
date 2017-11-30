package com.urvin.stockservice.domain;

import java.math.BigDecimal;

public class Quote {

    private String quote;
    private double price;

    public Quote(String quote, double price) {
        this.quote = quote;
        this.price = price;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
