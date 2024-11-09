package main.part10designpattern.service;

import main.part10designpattern.model.Price;

@FunctionalInterface
public interface PriceProcessor {
    Price process(Price price);

    //자신 다음에 실행될 price processor 을 받아옴
    default PriceProcessor andThen(PriceProcessor next) {
        return price -> next.process(process(price));
    }
}
