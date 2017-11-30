package com.urvin.dbservice.domain;

import javax.persistence.*;

@Entity(name="quote")
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name ="user_name")
    private String username;

    @Column(name="quote")
    private String quote;

    public Quote() {
    }

    public Quote(String username, String quote) {
        this.username = username;
        this.quote = quote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
