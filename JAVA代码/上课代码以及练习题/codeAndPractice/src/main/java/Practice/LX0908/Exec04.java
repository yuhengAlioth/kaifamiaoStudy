package Practice.LX0908;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Exec04 {

    public static List<Account> list = new ArrayList<>();
    public static int s = list.size();

    public static void main(String[] args) {
        list.add(new Account(10.00, "1234"));
        list.add(new Account(15.00, "5678"));
        list.add(new Account(0, "1010"));
        Map<Integer,Account> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put((int) list.get(i).getId(),list.get(i));
        }
//        map.put(s++,list);
        map.forEach(new BiConsumer<Integer, Account>() {
            @Override
            public void accept(Integer integer, Account account) {
                System.out.println(integer+"=="+account);
            }
        });
    }
}
