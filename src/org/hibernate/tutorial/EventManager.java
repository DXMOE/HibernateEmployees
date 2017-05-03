package org.hibernate.tutorial;

import org.hibernate.Session;

import java.util.*;
import org.hibernate.HibernateException;

import org.hibernate.tutorial.domain.Employees;
import org.hibernate.tutorial.util.HibernateUtil;

public class EventManager {

    public static void main(String[] args) throws HibernateException {
        EventManager mgr = new EventManager();

        if (args[0].equals("store")) {
            mgr.createAndStoreEmployees("Nuevo evento", new Date());
        }

        HibernateUtil.getSessionFactory().close();
    }

    private void createAndStoreEmployees(String title, Date theDate) throws HibernateException {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Employees theEvent = new Employees();
        theEvent.setFullname(title);
        theEvent.setDate(theDate);
        session.save(theEvent);
       
        session.close();
    }

}