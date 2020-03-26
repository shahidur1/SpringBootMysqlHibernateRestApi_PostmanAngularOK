/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;
import org.hibernate.Session;

/**
 *
 * @author Teacher
 */
@Service
public class UserDao {

    public User save(User obj) {
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(obj);
        s.getTransaction().commit();
        s.close();
        return obj;
    }
    

    public User update(User obj) {
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(obj);
        s.getTransaction().commit();
        s.close();
        return obj;
    }

    public User delete(User obj) {
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(obj);
        s.getTransaction().commit();
        s.close();
        return obj;
    }


    public List<User> showAll() {
        List<User> list = new ArrayList<User>();
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("From User");
        list = q.list();
        return list;
    }

    public List<User> showById(Integer id) {
        List<User> list = new ArrayList<User>();
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("From User u where u.id =:id");
        q.setParameter("id", id);
        list = q.list();
        return list;
    }
    public List<User> showByName(User obj) {
        List<User> list = new ArrayList<User>();
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("From User u where u.name =:name");
        q.setParameter("name", obj.getName());
        list = q.list();
        return list;
    }

    public static void main(String[] args) {
        UserDao d = new UserDao();
        //User s =d.showAll(new User(101)).get(0);
        User s= d.save(new User(7, "seven", "seven@gmail.com"));
        //User s = d.showById(new User(2)).get(0);
        System.out.println(s.getId());
        System.out.println(s.getName());
        System.out.println(s.getEmail());
    }
}
