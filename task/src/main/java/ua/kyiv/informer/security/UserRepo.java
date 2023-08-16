package ua.kyiv.informer.security;

import jakarta.persistence.*;
import ua.kyiv.informer.logic.entity.UserApp;

public class UserRepo {


    public UserRepo() {
    }

    public UserApp findByUserName(String username) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("informerDS");
        EntityManager em = emf.createEntityManager();
        TypedQuery<UserApp> query = em.createNamedQuery("User.findUsername", UserApp.class);
        query.setParameter("username", username);
        return query.getSingleResult();
    }
}
