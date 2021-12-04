import com.sun.glass.ui.monocle.util.C;
import entities.*;
import menus.MainMenu;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        new MainMenu().run();
    }
}
