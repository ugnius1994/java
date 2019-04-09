package lt.bta.java2.jpa.abrakadabra;

import javax.persistence.*;

//@Entity
//@Table(name = "cart", schema = "store", catalog = "")
public class CartEntity {
    private int id;
    private int qty;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "qty")
    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartEntity that = (CartEntity) o;

        if (id != that.id) return false;
        if (qty != that.qty) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + qty;
        return result;
    }
}
