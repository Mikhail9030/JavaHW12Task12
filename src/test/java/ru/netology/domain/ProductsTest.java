package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductsTest {

    private Product book1 = new Book(1, "День", 99999, "Валерий");
    private Product phone1 = new Smartphone(99, "One Action", 1550000, "Motorola");
    private Product product1 = new Product(5, "None", 10);

    @Test
    void matchesBookNameMatch() {
        boolean actual = book1.matches("день");
        assertTrue(actual);
    }

    @Test
    void matchesBookNameNotMatch() {
        boolean actual = book1.matches("ночь");
        assertFalse(actual);
    }

    @Test
    void matchesBookAuthorMatch() {
        boolean actual = book1.matches("вАлерий");
        assertTrue(actual);
    }

    @Test
    void matchesBookAuthorNotMatch() {
        boolean actual = book1.matches("Вале рий");
        assertFalse(actual);
    }

    @Test
    void matchesPhoneNameMatch() {
        boolean actual = phone1.matches("one action");
        assertTrue(actual);
    }

    @Test
    void matchesPhoneNameNotMatch() {
        boolean actual = phone1.matches("One Actions");
        assertFalse(actual);
    }

    @Test
    void matchesPhoneVendorMatch() {
        boolean actual = phone1.matches("motoroLa");
        assertTrue(actual);
    }

    @Test
    void matchesPhoneVendorNotMatch() {
        boolean actual = phone1.matches("Motorolla");
        assertFalse(actual);
    }

    @Test
    void matchesProductNameMatch() {
        boolean actual = product1.matches("NONE");
        assertTrue(actual);
    }

    @Test
    void matchesProductNameNotMatch() {
        boolean actual = product1.matches("No One");
        assertFalse(actual);
    }

}