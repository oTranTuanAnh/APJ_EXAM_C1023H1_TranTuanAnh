package controller;

import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductManager {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    // CSV file header
    private static final String FILE_HEADER = "id,name,price,quantity,descriptions";
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
    public void arrangedLowToHighPrice(){
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
               if (o1.getPrice()>o2.getPrice()){
                   return 1;
               }else if (o1.getPrice() == o2.getPrice()){
                   return 0;
               }else return -1;
            }
        });
    }
    public void arrangedHighToLowPrice(){
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice()<o2.getPrice()){
                    return 1;
                }else if (o1.getPrice() == o2.getPrice()){
                    return 0;
                }else return -1;
            }
        });

    }
    public Product getMaxPriceProduct(){
        double maxPrice = 0;
        int indexMax = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getPrice() > maxPrice){
                maxPrice = productList.get(i).getPrice();
                indexMax = i;
            }
        }
        return productList.get(indexMax);
    }
    public void showProduct(Product product){
        System.out.println(product);
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
    public void writeFile(String path){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path);
            fileWriter.append(FILE_HEADER);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (Product pro : productList) {
                fileWriter.append(String.valueOf(pro.getId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(pro.getName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(pro.getPrice()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(pro.getQuantity()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(pro.getDescriptions());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }

            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }

    public void readFile(String path){
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                printProduct(parseCsvLine(line));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static List<String> parseCsvLine(String csvLine) {
        List<String> result = new ArrayList<String>();
        if (csvLine != null) {
            String[] splitData = csvLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    private static void printProduct(List<String> product) {
        System.out.println(
                "Product{" +
                        "id='" + product.get(0) + '\'' +
                        ", name='" + product.get(1) + '\'' +
                        ", price=" + product.get(2) +
                        ", quantity=" + product.get(3) +
                        ", descriptions='" + product.get(4) + '\'' +
                        '}');
    }
}
