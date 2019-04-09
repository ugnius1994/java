package lt.bta.java2.api.requests;

public class AddInvoiceLineRequest {

    private int Id;
    private int qty;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
