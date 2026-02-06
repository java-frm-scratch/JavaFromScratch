package com.java.from.scratch.javaLatestFeatures.fourth_pattern_matching;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class OldWaywithoutPatternMatching {

    public static void main(String[] args) {
        Object obj = new Order("ORD123", 5000);

        if (obj instanceof Order) {
            Order order = (Order) obj;
            String id = order.getId();
            double amt = order.getAmt();
            System.out.println("Order ID: " + id + ", Amount: " + amt);
        }
        else{
            System.out.println("Unknown object type");
        }
    }
}
@AllArgsConstructor
@Getter
@Setter
class Order{
    String id;
    double amt;
}