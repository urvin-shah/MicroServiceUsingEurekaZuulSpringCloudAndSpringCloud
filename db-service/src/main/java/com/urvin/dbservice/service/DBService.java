package com.urvin.dbservice.service;

import com.urvin.dbservice.domain.Quote;
import com.urvin.dbservice.model.Quotes;
import com.urvin.dbservice.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DBService {

    @Autowired
    QuoteRepository quoteRepository;

    public List<String> getQuotesByUsername(String username) {
        if(username != null) {
            return quoteRepository.findQuoteByUsername(username)
                    .stream()
                    .map(Quote::getQuote)
                    .collect(Collectors.toList());
        }
        return null;
    }

    public List<String> addQuotes(Quotes quotes) {
        if(quotes != null) {
            quotes.getQuotes()
                    .stream()
                    .map(quote-> new Quote(quotes.getUsername(),quote))
                    .forEach(quote->quoteRepository.save(quote));

            return getQuotesByUsername(quotes.getUsername());
        }
        return null;
    }

    public List<String> deleteQuote(String username) {
        if(username != null && !username.isEmpty()) {
            List<Quote> quotes = quoteRepository.findQuoteByUsername(username);
            if(quotes != null) {
                quoteRepository.delete(quotes);
            }
        }
        return getQuotesByUsername(username);
    }
}
