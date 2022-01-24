package day01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class OrderService {

    private List<Order> orders = new ArrayList<>();


    public void saveOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrdersByStatus(String status) {
        return orders.stream()
                .filter(order -> order.getStatus().equals(status))
                .toList();
    }

    public long getNumberOfOrdersByStatus(String status) {
        return orders.stream()
                .filter(order -> order.getStatus().equals(status))
                .count();
    }

    public List<Order> getOrdersBetween(LocalDate from, LocalDate to) {
        return orders.stream()
                .filter(order -> order.getOrderDate().isAfter(from) &&
                        order.getOrderDate().isBefore(to))
                .toList();
    }

    public boolean hasOrderWithLessProductThan(int maxProduct) {
        return orders.stream()
                .anyMatch(o -> o.getProducts().size() < maxProduct);
    }

    public Optional<Order> findOrderWithMostProducts() {
        return orders.stream()
                .max(Comparator.comparingInt(o -> o.getProducts().size()));
    }

    public List<Order> getOrdersWithCategoryOfProduct(String category) {
        return orders.stream()
                .filter(o -> o.getProducts().stream()
                        .anyMatch(p -> p.getCategory().equals(category)))
                .toList();
    }
}
