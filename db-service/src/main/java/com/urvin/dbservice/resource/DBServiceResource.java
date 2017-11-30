package com.urvin.dbservice.resource;

import com.urvin.dbservice.model.Quotes;
import com.urvin.dbservice.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/db")
public class DBServiceResource {

    @Autowired
    DBService dbService;

    @GetMapping("/{username}")
    public List<String> getQuotes(@PathVariable("username") String username) {
        return dbService.getQuotesByUsername(username);
    }

    @PostMapping("/add")
    public List<String> addQuote(@RequestBody Quotes quotes) {
        return dbService.addQuotes(quotes);
    }

    @DeleteMapping("/delete/{username}")
    public List<String> deleteQuote(@PathVariable("username") String username) {
        return dbService.deleteQuote(username);
    }

}
