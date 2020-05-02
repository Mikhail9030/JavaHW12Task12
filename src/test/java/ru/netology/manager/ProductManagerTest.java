package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repository=new ProductRepository();
    ProductManager manager;

    Product book1=new Book(1, "День", 99999, "Валерий");
    Product book2=new Book(13, "Ночь", 1990, "Василий");
    Product phone1=new Smartphone(99, "One Action", 1550000, "Motorola");
    Product phone2=new Smartphone(7, "Galaxy A10", 793000, "Samsung");
    Product phone3=new Smartphone(2, "G7 Plus", 1139000, "Motorola");
    Product product1=new Product(5, "None", 10);

    @BeforeEach
    void setUp() {
        manager=new ProductManager(repository);
        manager.add(book1);
        manager.add(phone1);
        manager.add(product1);
        manager.add(phone2);
        manager.add(book2);
        manager.add(phone3);
    }

    @Test
    void searchByNotFoundTest() {
        Product[] actual=manager.searchBy("Москва");
        Product[] expected=new Product[0];

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByAuthorBookOneFoundTest() {
        Product[] actual=manager.searchBy("василий");
        Product[] expected=new Product[]{book2};

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByNameBookOneFoundTest() {
        Product[] actual=manager.searchBy("ДЕНЬ");
        Product[] expected=new Product[]{book1};

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByNamePhoneOneFoundTest() {
        Product[] actual=manager.searchBy("gaLaxy a10");
        Product[] expected=new Product[]{phone2};

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByVendorPhoneSeveralFoundTest() {
        Product[] actual=manager.searchBy("motoroLa");
        Product[] expected=new Product[]{phone1, phone3};

        assertArrayEquals(expected, actual);
    }
}