package main.part10designpattern;

import main.part10designpattern.model.Price;
import main.part10designpattern.service.BasicPriceProcessor;
import main.part10designpattern.service.DiscountPriceProcessor;
import main.part10designpattern.service.PriceProcessor;
import main.part10designpattern.service.TaxPriceProcessor;

public class MyDecoratorPattern {

    public static void main(String[] args) {
        Price unProcessedPrice = new Price("Original Price");
        PriceProcessor basicProcessor = new BasicPriceProcessor();
        PriceProcessor discountProcessor = new DiscountPriceProcessor();
        PriceProcessor taxProcessor = new TaxPriceProcessor();

        PriceProcessor decoratedProcessor = basicProcessor
                .andThen(discountProcessor)
                .andThen(taxProcessor);

        Price processedPrice = decoratedProcessor.process(unProcessedPrice);
        System.out.println(processedPrice.getPrice());

        PriceProcessor decoratedProcessor2 = basicProcessor
                .andThen(taxProcessor)
                .andThen(price -> new Price(price.getPrice() + ", then apply another procedure"));
        Price processedPrice2 = decoratedProcessor2.process(unProcessedPrice);
        System.out.println(processedPrice2.getPrice());
    }
}
