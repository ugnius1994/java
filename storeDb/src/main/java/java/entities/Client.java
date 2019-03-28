package java.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity//jei norim, kad entity vardas sutaptu su klases vardu, varda nurodome @Table.
@Table(name = "clients")
@NamedEntityGraphs({
        @NamedEntityGraph(
                name = Client.GRAPH_INVOICE_ONLY,
                attributeNodes = @NamedAttributeNode(value = "invoices")
        ),
        @NamedEntityGraph(
                name = Client.GRAPH_INVOICE,
                attributeNodes = @NamedAttributeNode(value = "invoices", subgraph = "invoices-subgraph"),
                subgraphs = {
                        @NamedSubgraph(
                                name = "invoices-subgraph",
                                attributeNodes = @NamedAttributeNode(value = "invLines", subgraph = "line-product")
                        ),
                        @NamedSubgraph(
                                name = "line-product",
                                attributeNodes = @NamedAttributeNode(value = "product")
                        )
                }
        )
})
@NamedQueries({
        @NamedQuery(
                name = Client.QUERY_BY_CITY,
                query = "SELECT c FROM Client AS c WHERE c.city=:city ORDER BY c.name")
})


public class Client {

    public final static String GRAPH_INVOICE_ONLY = "clients-invoices-only";
    public final static String GRAPH_INVOICE = "clients-invoices-graph";
    public final static String QUERY_BY_CITY = "query.clients.by-city";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String city;
    private Integer discount;

    @Column(length = 10)
    private Integer post;

    @JsonIgnore
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
//    @Expose
    Set<Invoice> invoices;

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", discount=" + discount +
                ", post=" + post +
                ", invoices=" + invoices +
                '}';
    }

    public Integer getPost() {
        return post;
    }

    public void setPost(Integer post) {
        this.post = post;
    }

    public Set<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(Set<Invoice> invoices) {
        this.invoices = invoices;
    }
//    @Transient
//    private String addrr;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

}
