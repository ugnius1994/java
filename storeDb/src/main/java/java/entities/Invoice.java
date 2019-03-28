package java.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "invoices")
//@NamedEntityGraph(name = "invoice-Lines", attributeNodes = @NamedAttributeNode("invLines"))
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate date;
    private String number;
    private BigDecimal sum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @OneToMany(mappedBy = "invoice", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST /*All*/, orphanRemoval = true)
    private List<InvLine> invLines;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<InvLine> getInvLines() {
        return invLines;
    }

    public void setInvLines(List<InvLine> invLines) {
        this.invLines = invLines;
    }

//    public void addLine(InvLine line){
//        line.setInvoice(this);
//        getInvLines().add(line);
//    }

    @Override
    public String toString() {
        return "\nInvoice{" +
                "id=" + id +
                ", date=" + date +
                ", number='" + number + '\'' +
                ", sum=" + sum +
//                ", client=" + client +
                ", invLines=" + invLines +
                '}';
    }
}
