package main.part10designpattern;

import java.math.BigDecimal;
import java.util.Arrays;
import main.part10designpattern.service.OrderProcessStep;
import main.part6stream.model.Order;
import main.part6stream.model.Order.OrderStatus;
import main.part6stream.model.OrderLine;

public class MyChainOfResponsibility {
    public static void main(String[] args) {

        OrderProcessStep initializeStep = new OrderProcessStep(
                order ->
                {
                    if (order.getStatus() == OrderStatus.CREATED) {
                        System.out.println("Start processing order " + order.getId());
                        order.setStatus(OrderStatus.IN_PROGRESS);
                    }
                });

        OrderProcessStep setOrderAmountStep = new OrderProcessStep(
                order ->
                {
                    if (order.getStatus() == OrderStatus.IN_PROGRESS) {
                        System.out.println("Setting amount of order " + order.getId());
                        order.setAmount(order.getOrderLines().stream()
                                .map(OrderLine::getAmount)
                                .reduce(BigDecimal.ZERO, BigDecimal::add));
                        
                    }
                });

        OrderProcessStep verifyOrderStep = new OrderProcessStep(
                order ->
                {
                    if (order.getStatus() ==OrderStatus.IN_PROGRESS) {
                        System.out.println("verifying Order" + order.getId());
                        if (order.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
                            order.setStatus(OrderStatus.ERROR); //amount 0이하면 에러
                        }
                    }
                });

        OrderProcessStep processPaymentStep = new OrderProcessStep(
                order->{
                    if (order.getStatus() == OrderStatus.IN_PROGRESS) {
                        System.out.println("process payment order " + order.getId());
                        order.setStatus(OrderStatus.PROCESSED);
                    }
                });

        OrderProcessStep handleErrorStep = new OrderProcessStep(
                order ->{
                    if(order.getStatus() == OrderStatus.ERROR) {
                        System.out.println("Error processing order " + order.getId());
                    }
                });
        
        OrderProcessStep completedProcessStep = new OrderProcessStep(
                order ->{
                    if (order.getStatus() ==OrderStatus.PROCESSED) {
                        System.out.println("finished processing order " + order.getId());
                    }
                });

        //위 스텝들을 엮어서 체인으로 만들기
        //각 스텝은 자신이 process 할 수 있는 것만 하고 다음으로 넘김
        OrderProcessStep chainOrderProcessStep = initializeStep
                .setNext(setOrderAmountStep)
                .setNext(verifyOrderStep)
                .setNext(handleErrorStep)
                .setNext(completedProcessStep);

        Order createdOrder = new Order()
                .setId(1001)
                .setStatus(OrderStatus.CREATED)
                .setOrderLines(Arrays.asList(new OrderLine().setAmount(BigDecimal.valueOf(1000)),
                        new OrderLine().setAmount(BigDecimal.valueOf(3000))));

        Order errorOrder = new Order()
                .setId(1002)
                .setStatus(OrderStatus.ERROR)
                .setOrderLines(Arrays.asList(new OrderLine().setAmount(BigDecimal.valueOf(1000)),
                        new OrderLine().setAmount(BigDecimal.valueOf(3000))));


        chainOrderProcessStep.process(createdOrder);
        System.out.println();
        chainOrderProcessStep.process(errorOrder);
    }
}
