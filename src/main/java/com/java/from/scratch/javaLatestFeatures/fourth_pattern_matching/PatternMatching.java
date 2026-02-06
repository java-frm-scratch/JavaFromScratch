package com.java.from.scratch.javaLatestFeatures.fourth_pattern_matching;

public class PatternMatching {

    public static void main(String[] args) {

        Object obj = new Order("ORD123", 5000);

        if (obj instanceof Order order) {
            // no need to typecast like  Order order = (Order) obj;
            String id = order.getId();
            double amt = order.getAmt();
            System.out.println("Order ID: " + id + ", Amount: " + amt);
        }

    }
}
