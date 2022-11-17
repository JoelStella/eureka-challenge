package io.eurekalabs.challenge.application.port.in;

@FunctionalInterface
public interface GetStock {

    String apply(String stockSymbol);

}
