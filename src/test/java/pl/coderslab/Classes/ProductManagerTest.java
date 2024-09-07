package pl.coderslab.Classes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductManagerTest {

    @Spy
    ProductRepository productRepository;
    @Test
    void addProducts() {
        ProductManager productManager = new ProductManager(productRepository);
        List<Product> productsToAdd = Arrays.asList(
                new Product("Laptop", 1500),
                new Product("Smartphone", 800)
        );

        productManager.addProducts(productsToAdd);

        ArgumentCaptor<Product> productListCaptor = ArgumentCaptor.forClass(Product.class);
        verify(productRepository,times(productsToAdd.size()))
                .addProduct(productListCaptor.capture());
        List<Product> capturedProducts = productListCaptor.getAllValues();

        assertEquals(productsToAdd,capturedProducts);
    }
}