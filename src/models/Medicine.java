package models;

public class Medicine {
    private String medicineId;
    private String name;
    private String manufacturer;
    private  double price;
    private int stockQuantity;


    public Medicine(String medicineId,
                    String name,
                    String manufacturer,
                    double price,
                    int stockQuantity){
        this.medicineId = medicineId;
        this.manufacturer= manufacturer;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.name= name;
    }
    public void updateStock(int quantity) {
        this.stockQuantity = this.stockQuantity + quantity;
    }
    public void displayMedicineInfo() {
        System.out.println("=== Medicine Information ===");
        System.out.println("Medicine ID: " + medicineId);
        System.out.println("Name: " + name);
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Price: " + price);
        System.out.println("Stock Quantity: " + stockQuantity);
    }


}
