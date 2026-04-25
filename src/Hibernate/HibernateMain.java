/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hibernate;

/**
 *
 Save & Retrieve
 */
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HibernateMain {
    public static void main(String[] args) {

        // Build SessionFactory from hibernate.cfg.xml
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            // --- Save ---
            Employee emp = new Employee("Alice", "Kigali");
            session.beginTransaction();
            session.save(emp);
            session.getTransaction().commit();
            System.out.println("Saved: " + emp.getFirstname());

            // --- Read ---
            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee retrieved = session.get(Employee.class, emp.getId());
            System.out.println("Retrieved: " + retrieved.getFirstname()
                               + " | " + retrieved.getLocation());
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}