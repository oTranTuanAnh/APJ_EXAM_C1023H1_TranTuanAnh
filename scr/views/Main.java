package views;

import model.Product;
import controller.ProductManager;

import java.util.Scanner;

public class Main {
    public static int intInput(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    public static double doubleInput(){
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }
    public static String stringInput(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        int choice = -1;
        Scanner in = new Scanner(System.in);

        while (choice != 0){
            System.out.println("--------------------------------------------------------");
            System.out.println("______________CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM_______________________");
            System.out.println("Chọn chức năng theo số (để tiếp tục)");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Tìm sản phẩm có giá đắt nhất");
            System.out.println("7. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("9. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = in.nextInt();

            switch (choice){
                case 1:
                    productManager.showList();
                    break;
                case 2:
                    System.out.println("Nhập thông tin sản phẩm:");
                    System.out.println("Nhập mã sản phẩm: ");
                    String id = stringInput();
                    System.out.println("Nhập tên sản phẩm: ");
                    String name = stringInput();
                    System.out.println("Nhập giá sản phẩm: ");
                    double price = doubleInput();
                    System.out.println("Nhập số lượng: ");
                    double quantity = doubleInput();
                    System.out.println("Nhập mô tả: ");
                    String descriptions = stringInput();
                    Product newProduct = new Product(id, name, price, quantity, descriptions);
                    productManager.addNewProduct(newProduct);
                    break;
                case 3:
                    String idToEdit = "";
                    do {
                        System.out.println("Nhập mã sản phẩm cần sửa: ");
                        idToEdit = stringInput();
                        if (!productManager.checkId(idToEdit)){
                            System.out.println("Không tìm thấy sản phẩm trên.");
                            System.out.println("Mời nhập lại!");
                        }else {
                            break;
                        }
                    }while (true);
                    System.out.println("Nhập thông tin mới:");
                    System.out.println("Nhập mã sản phẩm: ");
                    String idNew = stringInput();
                    System.out.println("Nhập tên sản phẩm: ");
                    String nameNew = stringInput();
                    System.out.println("Nhập giá sản phẩm: ");
                    double priceNew = doubleInput();
                    System.out.println("Nhập số lượng: ");
                    double quantityNew = doubleInput();
                    System.out.println("Nhập mô tả: ");
                    String descriptionsNew = stringInput();
                    productManager.updateProduct(idToEdit, idNew, nameNew, priceNew, quantityNew, descriptionsNew);
                    System.out.println("Cập nhật sản phẩm thành công!");

                    break;
                case 4:
                    String idToDelete = "";
                    do {
                        System.out.println("Nhập mã sản phẩm muốn xóa: ");
                        idToDelete = stringInput();
                        if (!productManager.checkId(idToDelete)){
                            System.out.println("Không tìm thấy sản phẩm trên.");
                            System.out.println("Mời nhập lại!");
                        }else {
                            break;
                        }
                    }while (true);
                    productManager.deleteProduct(idToDelete);
                    System.out.println("Xóa thành công!");

                    break;
                case 5:
                    System.out.println("______________________________________");
                    System.out.println("Sắp xếp sản phẩm theo:");
                    System.out.println("1. Giá tăng dần");
                    System.out.println("2. Giá giảm dần");
                    System.out.println("3. Quay lại");
                    int choiceNumberArrange = intInput();
                    switch (choiceNumberArrange){
                        case 1:
                            productManager.arrangedLowToHighPrice();
                            productManager.showList();
                            break;
                        case 2:
                            productManager.arrangedHighToLowPrice();
                            productManager.showList();
                            break;
                        case 3:
                            break;
                    }

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 9:
                    System.exit(0);
            }
        }

    }

}
