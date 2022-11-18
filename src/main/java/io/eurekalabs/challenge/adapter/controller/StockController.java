package io.eurekalabs.challenge.adapter.controller;

import io.eurekalabs.challenge.application.port.in.GetStock;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
@Api(tags = "stock")
public class StockController {

    private final GetStock getStock;

    public StockController(GetStock getStock) {
        this.getStock = getStock;
    }

    @GetMapping("/{stockSymbol}")
    @ApiOperation(value = "Get companies stock")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Stock of company based on company symbol")})
    public ResponseEntity<String> getStock(@PathVariable("stockSymbol") String stockSymbol) {
        return ResponseEntity.ok(
                getStock.apply(stockSymbol)
        );
    }

}
