package day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    OrderService orderService;

    @BeforeEach
    void init() {
        orderService = new OrderService();

        Product p1 = new Product("Tv", "IT", 2000);
        Product p2 = new Product("Laptop", "IT", 2400);
        Product p3 = new Product("Phone", "IT", 400);
        Product p4 = new Product("Lord of The Rings", "Book", 20);
        Product p5 = new Product("Harry Potter Collection", "Book", 120);

        Order o1 = new Order("pending", LocalDate.of(2021, 6, 7));
        o1.addProduct(p1);
        o1.addProduct(p2);
        o1.addProduct(p5);

        Order o2 = new Order("on delivery", LocalDate.of(2021, 6, 1));
        o2.addProduct(p3);
        o2.addProduct(p1);
        o2.addProduct(p2);

        Order o3 = new Order("pending", LocalDate.of(2021, 6, 7));
//        o3.addProduct(p1);
        o3.addProduct(p4);
        o3.addProduct(p5);

        Order o4 = new Order("on delivery", LocalDate.of(2021, 6, 1));
        o4.addProduct(p3);
        o4.addProduct(p1);
        o4.addProduct(p2);

        Order o5 = new Order("pending", LocalDate.of(2021, 6, 7));
        o5.addProduct(p1);
        o5.addProduct(p2);
        o5.addProduct(p5);

        orderService.saveOrder(o1);
        orderService.saveOrder(o2);
        orderService.saveOrder(o3);
        orderService.saveOrder(o4);
        orderService.saveOrder(o5);
    }

    @Test
    void testOrdersByStatus() {
        List<Order> result = orderService.getOrdersByStatus("pending");
        assertEquals(3, result.size());
    }

    @Test
    void testOrdersNumberByStatus() {
        assertEquals(3L, orderService.getNumberOfOrdersByStatus("pending"));
    }

    @Test
    void testOrdersBetweenDates() {
        List<Order> result = orderService.getOrdersBetween(LocalDate.of(2021, 5, 20),
                LocalDate.of(2021, 6, 5));
        assertEquals(2, result.size());
    }

    @Test
    void testHasProductsLessThan() {
        assertTrue(orderService.hasOrderWithLessProductThan(4));
        assertFalse(orderService.hasOrderWithLessProductThan(3));
    }

    @Test
    void testFindOrderWithMostProduct() {
        Optional<Order> result = orderService.findOrderWithMostProducts();
        assertTrue(result.isPresent());
    }

    @Test
    void testGetOrdersWithProductByCategory() {
        List<Order> result = orderService.getOrdersWithCategoryOfProduct("IT");
        assertEquals(4, result.size());
    }
}