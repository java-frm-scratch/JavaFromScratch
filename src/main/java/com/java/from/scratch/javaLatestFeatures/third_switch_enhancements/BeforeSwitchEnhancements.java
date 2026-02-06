package com.java.from.scratch.javaLatestFeatures.third_switch_enhancements;

public class BeforeSwitchEnhancements {
    public static void main(String[] args) {
        String status = "FAILED";
        String message;

        switch (status) {
            case "SUCCESS":
                message = "Payment completed";
               break;
            case "FAILED":
                message = "Payment failed";
                break;
            case "PENDING":
                message = "Payment is pending";
                break;
            default:
                message = "Unknown status";
        }
        System.out.println(message);
    }
}
