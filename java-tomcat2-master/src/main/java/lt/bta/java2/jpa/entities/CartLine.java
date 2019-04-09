package lt.bta.java2.jpa.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity(name = "cart_lines")
//@NamedEntityGraph(
//        name = CartLine.CART_PRODUCT_LINE,
//        attributeNodes = @NamedAttributeNode(
//                value = "product")
//)
//@NamedQueries({
//        @NamedQuery(
//                name = Client.QUERY_BY_CITY,
//                query = "SELECT c FROM cart_lines c WHERE c.userId = :userId"
//        )
//})
public class CartLine {

    public final static String CART_PRODUCT_LINE = "cart-product";
    public final static String QUERY_CART_PRODUCT_LIST_BY_ID = "query-cart-product";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int qty;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "product_id")
    private int productId;
//    @JsonIgnore // POST įkelia su null reikšme, nesvarbu koks FetchType
//    @ManyToOne(fetch = FetchType.LAZY) // be @JsonIgnore meta 400 klaidą
//    private Product product;

    @Override
    public String toString() {
        return "CartLine{" +
                "id=" + id +
                ", qty=" + qty +
                ", userId=" + userId +
//                ", productId=" + productId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
//    public Product getProduct() {
//        return product;
//    }
//    public void setProduct(Product product) {
//        this.product = product;
//    }
}
