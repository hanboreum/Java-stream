package main.part10designpattern.service;

import main.part10designpattern.model.Price;

public class DiscountPriceProcessor implements PriceProcessor{

    @Override
    public Price process(Price price) {
        return new Price(price.getPrice() + ", then applied discount. " );
    }
}
