package premidassg;

public class Transaction {
    
    private String ID;
    private String date;
    private TransactionDetail transactionDetail[] = new TransactionDetail[1];
    private String consumentName;
    private String tellerName;
    private int totalHarga;
    
    public Transaction(String ID, String consumentName, String tellerName, int totalHarga, TransactionDetail transactionDetail[], String date) {
        
        this.setID(ID);
        this.setConsumentName(consumentName);
        this.setTellerName(tellerName);
        this.setTotalHarga(totalHarga);
        this.setDate(date);
        this.setTransactionDetail2(transactionDetail);
        
    }

    public TransactionDetail[] getTransactionDetail() {
        return transactionDetail;
    }

    public int getTransactionDetailSize() {
        return transactionDetail.length;
    }

    public void setTransactionDetail2(TransactionDetail transactionDetail[]) {
        this.transactionDetail = transactionDetail;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }

    public String getTellerName() {
        return tellerName;
    }

    public void setTellerName(String tellerName) {
        this.tellerName = tellerName;
    }

    public String getConsumentName() {
        return consumentName;
    }

    public void setConsumentName(String consumentName) {
        this.consumentName = consumentName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        this.ID = iD;
    }

}
