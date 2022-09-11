package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Product Book1 = new Book(1, "Левиафан", 600, "Борис Акунин");
    Product Book2 = new Book(2, "Шантарам", 500, "Грегори Дэвид Робертс");
    Product Smartphone1 = new Smartphone(3, "OnePlus 8", 40_000, "OnePlus Technology");
    Product Smartphone2 = new Smartphone(4, "Samsung Galaxy A52", 30_000, "Samsung Electronics");

    @BeforeEach
    public void setUp() {
        manager.add(Book1);
        manager.add(Book2);
        manager.add(Smartphone1);
        manager.add(Smartphone2);
    }

    @Test
    public void shouldGetAllProd() {

        Product[] expected = {Book1, Book2, Smartphone1, Smartphone2};
        Product[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFindNameOfBook1() {
        Product[] expected = {Book1};
        Product[] actual = manager.searchBy("Левиафан");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNameOfBook2() {
        Product[] expected = {Book2};
        Product[] actual = manager.searchBy("Шантарам");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSmartphone1Name() {
        Product[] expected = {Smartphone1};
        Product[] actual = manager.searchBy("OnePlus 8");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSmartphone2Name() {
        Product[] expected = {Smartphone2};
        Product[] actual = manager.searchBy("Samsung Galaxy A52");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindAuthor() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Грегори Дэвид Робертс");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {
        Product product = new Product();

        product.setId(1);

        int expected = 1;
        int actual = product.getId();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByPrice() {
        Product product = new Product();

        product.setPrice(600);

        int expected = 600;
        int actual = product.getPrice();
        Assertions.assertEquals(expected, actual);
    }
}
