package io.eurekalabs.challenge.adapter.controller;

import io.eurekalabs.challenge.application.port.in.GetStock;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockController {

    private final GetStock getStock;

    public StockController(GetStock getStock) {
        this.getStock = getStock;
    }

    @GetMapping("/{stockSymbol}")
    public ResponseEntity<String> getStock(@PathVariable("stockSymbol") String stockSymbol) {
        return ResponseEntity.ok(
                getStock.apply(stockSymbol)
        );
    }

}
