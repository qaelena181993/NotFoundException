package ru.netology.domain;

public class ProductManager {
    private ProductRepository repo;

    public ProductManager(ProductRepository repo) {

        this.repo = repo;
    }

    public void add(Product product) {
        repo.save(product);
    }

    public Product[] findAll() {
        return repo.getSavedProd();
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repo.getSavedProd()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;

                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
