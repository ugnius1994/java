package DB.Main;

import javax.persistence.EntityManager;
import DB.helpers.EntityManagerHelper;

public class Main {
    public static void main(String[] args) {
        EntityManager em=EntityManagerHelper.getEntityManager();
    }
}
