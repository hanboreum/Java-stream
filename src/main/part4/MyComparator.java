package main.part4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import main.part4.model.User;
//Comparator 두 개의 객체를 비교해 정렬하는데 사용
public class MyComparator {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Kim"));
        users.add(new User(6, "Lee"));
        users.add(new User(4, "Park"));
        System.out.println(users);

        //u1의 id 가 더 작을 때는 음수를 return, u1 u2 같다면 0 return,  u2의 id가 더 작을 땐 양수 return
        Comparator<User> idComparator = (User u1, User u2) ->{
            return u1.getId() - u2.getId();
        };
        Collections.sort(null, null);
    }
}
