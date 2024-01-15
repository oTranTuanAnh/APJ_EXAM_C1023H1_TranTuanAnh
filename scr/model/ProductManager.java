package model;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private Product product;

    public ProductManager() {
    }

    public ProductManager(Product product) {
        this.product = product;
    }
    public static List<Product> productList = new ArrayList<>();
    public void addNewProduct(Product product){
        productList.add(product);
    }
    public void updateProduct(String idToEdit, String newId, String newName, double newPrice, double newQuantity, String newDescripts){
       for (Product p: productList){
           if (p.getId().equals(idToEdit)){
               p.setId(newId);
               p.setName(newName);
               p.setPrice(newPrice);
               p.setQuantity(newQuantity);
               p.setDescriptions(newDescripts);
           }
       }
    }
    public void deleteProduct(String id){
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId().equals(id)){
                productList.remove(productList.get(i));
            }
        }
    }
    public void showList(){
        for (Product p: productList){
            System.out.println(p);
        }
    }
    public boolean checkId(String id){
        boolean isCheked = false;
        for (Product p: productList){
            if (p.getId().equals(id)){
                isCheked = true;
            }
        }
        return isCheked;
    }
}
