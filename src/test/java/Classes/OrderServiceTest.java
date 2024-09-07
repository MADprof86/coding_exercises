package Classes;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class OrderServiceTest {



    @Test
    void calculateTotalPriceWithProperOrderReturnsPrice() {
        //given
        Product first = new Product("Paper",100.00);
        Product second = new Product("Rock",200);
        List<Product> productList = Arrays.asList(first,second);

        Order mock = mock(Order.class);
        OrderService orderService = new OrderService();
        //when
        when(mock.getProducts()).thenReturn(productList);
        double resultPrice = orderService.calculateTotalPrice(mock);
        //Then
        assertEquals(300,resultPrice);


    }
}