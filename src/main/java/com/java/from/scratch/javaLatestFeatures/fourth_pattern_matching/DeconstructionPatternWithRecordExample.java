package com.java.from.scratch.javaLatestFeatures.fourth_pattern_matching;

public class DeconstructionPatternWithRecordExample {

    public static void main(String[] args) {
        Object obj = new OrderRecord("ORD123", 5000);


        if (obj instanceof OrderRecord(_, double amt)) {
            //System.out.println("Order ID: " + id + ", Amount: " + amt);
         System.out.println( " Amount: " + amt);
        }
    }
}

record OrderRecord(String id,double amt){

}
