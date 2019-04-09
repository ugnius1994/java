package lt.bta.java2;

import lt.bta.java2.jpa.entities.Invoice;
import lt.bta.java2.jpa.helpers.EntityManagerHelper;
import lt.bta.java2.jpa.services.Dao;

public class Main {

    public static void main(String[] args) {

        System.out.println(gautiDBtoString());
    }

    public static String gautiDBtoString() {

//        Dao<Client> clientDaoX = new Dao<>();
//        Client clientX = clientDaoX.read(Client.class, 1);
//        System.out.println(clientX.toStringClientInvoices());


//        EntityManager em = EntityManagerHelper.getEntityManager();
//        if (false){
        // R nuskaito product lenta
//            Dao<Client> clientDao = new Dao<>();
//            Client client = clientDao.read(1, Client.CLIENTS_INVOICES_ONLY); // grafo pavadinimas
//            System.out.println("Dao<Client> ---------------------");
//            System.out.println(client.toStringClientInvoices());
//            System.out.println("Dao<Client> ---------------------");
//        }


        // R nuskaito product lenta
        Dao<Invoice> invoiceDao = new Dao<>(Invoice.class);
        Invoice invoice = invoiceDao.read(1, "invoices_line"); // grafo pavadinimas

        return invoice.toString();
    }
}
