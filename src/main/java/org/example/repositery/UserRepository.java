package org.example.repositery;

import jakarta.persistence.*;
import org.example.entity.Users;

public class UserRepository {

   public Users findUser(String userName, String password){
       EntityManagerFactory unit = Persistence.createEntityManagerFactory("Unit");
       EntityManager em = unit.createEntityManager();
       EntityTransaction transaction = em.getTransaction();
       transaction.begin();
       try {

           if (userName == null || password == null) {
               return null;
           }
           TypedQuery<Users> query = em.createQuery("from Users where userName = :userName and password = :password", Users.class);
           query.setParameter("userName", userName);
           query.setParameter("password", password);
           Users singleResult = query.getSingleResult();
           if (singleResult != null) {
               return singleResult;
           } else {
               return null;
           }
       }
       finally {
           transaction.commit();
       }
   }

   public Users createUser(Users user){
       EntityManagerFactory unit = Persistence.createEntityManagerFactory("Unit");
       EntityManager em = unit.createEntityManager();
       EntityTransaction transaction = em.getTransaction();
       transaction.begin();
       try {
           String userName = user.getUserName();
           String password = user.getPassword();
           boolean b = userExist(userName, password);
           if (b) {
               return null;
           }
           else{
               em.persist(user);
               return user;
           }
       }
       finally {
           transaction.commit();
       }
   }

   public boolean userExist(String userName, String password){
       EntityManagerFactory unit = Persistence.createEntityManagerFactory("Unit");
       EntityManager em = unit.createEntityManager();
       EntityTransaction transaction = em.getTransaction();
       transaction.begin();
       try {

           if (userName == null || password == null) {
               return false;
           }
           TypedQuery<Users> query = em.createQuery("from Users where userName = :userName and password = :password", Users.class);
           query.setParameter("userName", userName);
           query.setParameter("password", password);
           Users singleResult = query.getSingleResult();
           if (singleResult != null) {
               return true;
           } else {
               return false;
           }
       }
       finally {
           transaction.commit();
       }

   }
}
