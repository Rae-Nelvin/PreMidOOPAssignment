package premidassg;

public class TransactionDetail {
    
    private String minyakName;
    private int quantity;
    private int price;

    public TransactionDetail(String minyakName, int quantity, int price) {

        this.setMinyakName(minyakName);
        this.setQuantity(quantity);
        this.setPrice(price);

    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getMinyakName() {
        return minyakName;
    }

    public void setMinyakName(String minyakName) {
        this.minyakName = minyakName;
    }

}
