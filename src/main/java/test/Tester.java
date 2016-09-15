/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.mycompany.test1.BookJpaController;
import com.mycompany.test1.CustomerJpaController;
import entity.Book;
import entity.Customer;
import enums.CustomerType;
import ex2.Address;
import java.util.ArrayList;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author josephawwal
 */
public class Tester {
    
    EntityManagerFactory EMF = Persistence.createEntityManagerFactory("com.mycompany_test1_jar_1.0-SNAPSHOTPU");
    EntityManagerFactory BMF = Persistence.createEntityManagerFactory("com.mycompany_test1_jar_1.0-SNAPSHOTPU");
    private CustomerJpaController custController = new CustomerJpaController(EMF);
    private BookJpaController  bookController = new BookJpaController(BMF);
    
    
    
    public static void main(String[] args) {
        
        Tester tester = new Tester();
        
        Customer customer = new Customer("abe", "lol");
        tester.custController.create(customer);
        
        Customer customer1 = new Customer("abe1", "lol1", CustomerType.GOLD);
        
        ArrayList<Address> addresses = new ArrayList<>();
        
        Address address = new Address("engvej", "copenhagen");
  
        
        
        addresses.add(address);
        
        
        Customer customer2 = new Customer("Timm", "Rasmussen", CustomerType.GOLD, addresses);
        address.setCustomer(customer2);
        
        tester.custController.create(customer1);
        
        Book book = new Book("lulz");
        
        tester.bookController.create(book);
        
        tester.custController.create(customer2);
        
       
        // the same
        
    }
    
}
