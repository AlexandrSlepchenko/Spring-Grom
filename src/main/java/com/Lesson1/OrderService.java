package com.Lesson1;

import org.springframework.beans.factory.annotation.Autowired;

public class OrderService {
    private int[] ordersIds = new int[5];

    @Autowired
    private OrderDAO orderDAO;

    public Order save(Order order) {
        return null;
    }

    public void test(int index, int id) {
        ordersIds[index] = id;
    }
}
