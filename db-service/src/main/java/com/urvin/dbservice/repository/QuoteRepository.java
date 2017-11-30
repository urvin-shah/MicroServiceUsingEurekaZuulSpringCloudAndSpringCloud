package com.urvin.dbservice.repository;

import com.urvin.dbservice.domain.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoteRepository extends JpaRepository<Quote,Integer>{
    public List<Quote> findQuoteByUsername(String username);
}
