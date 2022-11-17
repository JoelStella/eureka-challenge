package io.eurekalabs.challenge.adapter.gateway;

import io.eurekalabs.challenge.application.port.out.StockGateway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StockGatewayImpl implements StockGateway {

    private final RestTemplate restTemplate;
    private final String stockApiUrl;

    public StockGatewayImpl(RestTemplate restTemplate,
            @Value("${stock.api-url}") String stockApiUrl) {
        this.restTemplate = restTemplate;
        this.stockApiUrl = stockApiUrl;
    }

    @Override
    public String getStocks(String stockSymbol) {
        //TODO: save response API into a object
        var apiResponse =
                restTemplate.exchange(
                        String.format(stockApiUrl, stockSymbol),
                        HttpMethod.GET,
                        null,
                        String.class
                );
        return apiResponse.getBody();
    }
}
