package sb.bisht.microservice.orderservice;

import sb.bisht.microservice.orderservice.entity.Order;
import sb.bisht.microservice.orderservice.util.StringToObject;

import java.lang.reflect.InvocationTargetException;

public class Misc {

    public static void main(String[] args) throws Exception {

        String s = "{\"userId\":1,\"order\":\"Samsung N\",\"price\":\"1000000\",\"orderPlacedOn\":1622130279662}";
        Order order = StringToObject.fromString(s, Order.class);
        System.out.println("Order must be empty for now"+ order);

//        String str ="\"userId";
//        System.out.println(str +" is "+isDoubleQuoted(str));
    }

    static boolean isDoubleQuoted(String s) {
        if(s.charAt(0)==34 && s.charAt(s.length()-1)==34){
            return true;
        }
        if(s.charAt(0)!=34 || s.charAt(s.length()-1)!=34){
            return false;
        }
        return false;
    }
}
