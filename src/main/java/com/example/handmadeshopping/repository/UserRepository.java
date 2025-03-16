package com.example.handmadeshopping.repository;

import EJB.model.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

@Stateless
public class UserRepository {

    @PersistenceContext(unitName = "handmadePU")
    private EntityManager entityManager;

    public User findByUsername(String name) {
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT u FROM User u WHERE u.name = :name", User.class);
        query.setParameter("name", name);
        List<User> users = query.getResultList();
        return users.isEmpty() ? null : users.get(0);
    }

    public void saveUser(User user) {
        entityManager.persist(user);
    }
}