package main.part6stream;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import main.part6stream.model.Order;
import main.part6stream.model.Order.OrderStatus;
import main.part6stream.model.OrderLine;
import main.part6stream.model.OrderLine.OrderLineType;

/**
 * Flat Map
 * Map + Flatten
 * 데이터에 함수를 적용한 후 중첩된 stream 을 연결하여 하나의 stream 으로 return
 */
public class MyFlatMap {
    public static void main(String[] args) {
        String[][] cities = new String[][]{
                {"Seoul", "Busan"},
                {"New York"," LA"},
                {"Bangkok"," Chiang mai"}
        };
        Stream<String[]> cityStream = Arrays.stream(cities);

        //map 으로 stream 을 바꿔준다면 stream 안에 stream 이 들어있는 형태러 바뀐다.
        Stream<Stream<String>> mapStream = cityStream.map(x->Arrays.stream(x));
        List<Stream<String>> cityStreamList = mapStream.collect(Collectors.toList());

        Stream<String[]>cityStream2 = Arrays.stream(cities);
        Stream<String> flatMapCity = cityStream2.flatMap(x -> Arrays.stream(x));
        //도시들이 하나의 리스트로 합쳐짐
        List<String> flatMapCityList = flatMapCity.collect(Collectors.toList());
        System.out.println(flatMapCityList);

        Order order1 = new Order()
                .setId(1001)
                .setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setId(10001)
                                .setType(OrderLineType.PURCHASE)
                                .setAmount(BigDecimal.valueOf(5000)),
                        new OrderLine()
                                .setId(10002)
                                .setType(OrderLineType.PURCHASE)
                                .setAmount(BigDecimal.valueOf(60000))
                ));

        Order order2 = new Order()
                .setId(1001)
                .setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setId(10003)
                                .setType(OrderLineType.PURCHASE)
                                .setAmount(BigDecimal.valueOf(3300)),
                        new OrderLine()
                                .setId(10004)
                                .setType(OrderLineType.DISCOUNT)
                                .setAmount(BigDecimal.valueOf(-1000))
                ));

        Order order3 = new Order()
                .setId(1001)
                .setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setId(10005)
                                .setType(OrderLineType.PURCHASE)
                                .setAmount(BigDecimal.valueOf(2200))
                ));

        //오더들을 하나로 합치기
        List<Order> orders = Arrays.asList(order1, order2, order3);
        List<OrderLine> orderLines = orders.stream()  //Stream<Order>
                .map(Order::getOrderLines) //Stream<List<OrderLine>>
                .flatMap(List::stream) //Stream<OrderLine>
                .collect(Collectors.toList());

        System.out.println(orderLines);
    }
}
