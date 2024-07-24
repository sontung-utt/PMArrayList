package manager;

import java.util.ArrayList;

import model.Product;

public class ProductManager implements IManager<Product>{
    ArrayList<Product> listProduct;

    public ProductManager() {
        this.listProduct = new ArrayList<>();
    }
    @Override
    public void add(Product product) {
        listProduct.add(product);
    }

    @Override
    public void remove(int id) {
        int index = findIndexById(id);
        listProduct.remove(index);
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < listProduct.size(); i++) {
            if(listProduct.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void update(int id, Product product) {
        int index = findIndexById(id);
        listProduct.set(index, product);
    }

    @Override
    public ArrayList<Product> getAll() {
        return listProduct;
    }

    @Override
    public ArrayList<Product> findByName(String name) {
        ArrayList<Product> products = new ArrayList<>();
        for(int i = 0; i < listProduct.size(); i++) {
            if(listProduct.get(i).getName().toLowerCase().contains(name.toLowerCase())) {
                products.add(listProduct.get(i));
            }
        }
        return products;
    }

    public ArrayList<Product> findByBrand(String brand) {
        ArrayList<Product> products = new ArrayList<>();
        for(int i = 0; i < listProduct.size(); i++) {
            if(listProduct.get(i).getBrand().equalsIgnoreCase(brand)) {
                products.add(listProduct.get(i));
            }
        }
        return products;
    }

    public ArrayList<Product> findByRangePrice(double minPrice, double maxPrice) {
        ArrayList<Product> products = new ArrayList<>();
        for(int i = 0; i < listProduct.size(); i++) {
            if(listProduct.get(i).getPrice() >= minPrice && listProduct.get(i).getPrice() <= maxPrice) {
                products.add(listProduct.get(i));
            }
        }
        return products;
    }
}
