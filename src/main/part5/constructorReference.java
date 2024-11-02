package main.part5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import main.part4.model.User;
import main.part5.model.Car;
import main.part5.model.Sedan;
import main.part5.model.Suv;
import main.part5.model.Van;

/**
 * constructorReference ClassName::new 클래스의 constructor 를 지정할 때
 */
public class constructorReference {

    public static void main(String[] args) {
        Map<String, BiFunction<String, String, Car>> carTypeConstructor = new HashMap<>();
        carTypeConstructor.put("sedan", Sedan::new);
        carTypeConstructor.put("suv", Suv::new);
        carTypeConstructor.put("van", Van::new);

        User user = new User(1, "Lee");
        //userCreator = (Integer id< String name) -> new User() 이런 식으로도 가능하지만
        BiFunction<Integer, String, User> userCreator = User::new;
        User user2 = userCreator.apply(3,"Java");
        System.out.println(user2);

        String[][] inputs = new String[][] {
                {"sedan", "Sonata", "Hyundai"},
                {"van", "Sienna", "Toyota"},
                {"sedan", "Model s", "Tesla"},
                {"suv", "Sorento", "KIA"}
        };

        List<Car> cars = new ArrayList<>();
        for (int i=0; i< inputs.length; i++){
            String[] input = inputs[i];
            String carType = input[0];
            String name = input[1];
            String brand = input[2];

            //이름과 브랜드를 주면 apply 를 통해 해당 type 에 해당하는 object 를 만들어 list 에 추가
            cars.add(carTypeConstructor.get(carType).apply(name, brand));
        }

        for( Car car: cars){
            car.drive();
        }
    }
}
