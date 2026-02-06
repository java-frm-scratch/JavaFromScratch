package com.java.from.scratch.javaLatestFeatures.sixth_virtual_threads_project_loom;

public class OrderProcessor {
    private final PaymentService paymentService = new PaymentService();
    private final InventoryService inventoryService = new InventoryService();
    private final OrderRepository repository = new OrderRepository();
    private final NotificationService notificationService = new NotificationService();

    void process(Order order) throws InterruptedException {
        paymentService.pay(order);
        inventoryService.reserve(order);
        repository.save(order);
        notificationService.notifyUser(order);
    }
}
