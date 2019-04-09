package lt.bta.java2.jpa.abrakadabra;

import javax.persistence.*;
import java.math.BigDecimal;

//@Entity
//@Table(name = "inv_lines", schema = "store", catalog = "")
public class InvLinesEntity {
    private int id;
    private BigDecimal price;
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
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

        InvLinesEntity that = (InvLinesEntity) o;

        if (id != that.id) return false;
        if (qty != that.qty) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + qty;
        return result;
    }
}
