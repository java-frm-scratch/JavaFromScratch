package com.java.from.scratch.javaLatestFeatures.third_switch_enhancements;

public class SwitchWithEnhancements {
    public static void main(String[] args) {
        String status = "SUCCESS";
        String message = switch (status) {
            case "SUCCESS": yield "Payment completed";
            case "FAILED" : yield "Payment failed";
            case "PENDING" :yield "Payment is pending";
            default :yield "Unknown status";
        };
        System.out.println(message);



        //Example 2: Real world Example Role-based access control (RBAC)
        String role = "SUPER_ADMIN";

        String access = switch (role) {
            case "ADMIN", "SUPER_ADMIN" -> "Full Access";
            case "USER", "CUSTOMER" -> "Limited Access";
            default -> "No Access";
        };
        System.out.println(access);
    }
}
