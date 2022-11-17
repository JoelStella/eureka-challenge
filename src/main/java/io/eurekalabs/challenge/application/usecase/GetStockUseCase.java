package io.eurekalabs.challenge.application.usecase;

import io.eurekalabs.challenge.application.port.in.GetStock;
import io.eurekalabs.challenge.application.port.out.StockGateway;
import org.springframework.stereotype.Service;

@Service
public class GetStockUseCase implements GetStock {

    private final StockGateway stockGateway;

    public GetStockUseCase(StockGateway stockGateway) {
        this.stockGateway = stockGateway;
    }

    @Override
    public String apply(String stockSymbol) {
        return stockGateway.getStocks(stockSymbol);
    }
}
