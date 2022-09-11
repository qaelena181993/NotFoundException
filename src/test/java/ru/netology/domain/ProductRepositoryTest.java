package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductRepositoryTest {
    private ProductRepository repo = new ProductRepository();
    private Product Book1 = new Book(1, "Левиафан", 600, "Борис Акунин");
    private Product Book2 = new Book(2, "Шантарам", 500, "Грегори Дэвид Робертс");
    private Product Smartphone1 = new Smartphone(3, "OnePlus 8", 40_000, "OnePlus Technology");
    private Product Smartphone2 = new Smartphone(4, "Samsung Galaxy A52", 30_000, "Samsung Electronics");

    @BeforeEach
    @Test
    public void save() {
        repo.save(Book1);
        repo.save(Book2);
        repo.save(Smartphone1);
        repo.save(Smartphone2);
    }

    @Test
    public void getSavedProd() {
        Product[] expected = {Book1, Book2, Smartphone1, Smartphone2};
        Product[] actual = repo.getSavedProd();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeById() {
        repo.removeById(3);

        Product[] expected = {Book1, Book2, Smartphone2};
        Product[] actual = repo.getSavedProd();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeNonExistId() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(6);
        });
    }
}
