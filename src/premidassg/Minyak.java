package premidassg;

public class Minyak {
    
    private String ID;
    private String name;
    private String brand;
    private int quantity;
    private int price;

    public Minyak(String ID, String name, String brand, int quantity, int price) {

        this.setID(ID);
        this.setName(name);
        this.setBrand(brand);
        this.setQuantity(quantity);
        this.setPrice(price);

    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        this.ID = iD;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
