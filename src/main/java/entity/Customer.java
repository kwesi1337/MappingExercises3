/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import enums.CustomerType;
import ex2.Address;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author josephawwal
 */
@Entity
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String firstName;
    private String lastName;
    private List<String> hobbies = new ArrayList<>();
    

    @OneToMany(mappedBy = "customer",cascade=CascadeType.PERSIST)
    private List<Address> addresses = new ArrayList();
    
    
    
    private String addHobby(String s) {
        
        return s;
    }
    
    @Enumerated(EnumType.STRING)
    private CustomerType enums;

    public CustomerType getEnums() {
        return enums;
    }

    public void setEnums(CustomerType enums) {
        this.enums = enums;
    }
    
    public void setAdress(){
        
        
    }
    
    public Customer(){
        
        
    }
    
    
    
    
    public Customer(String firstName, String lastName){
        
        this.firstName = firstName;
        this.lastName = lastName;
        
    }
    
    public Customer(String firstName, String lastName, CustomerType enums){
        this.firstName = firstName;
        this.lastName = lastName;
        this.enums = enums;
        
    }
    
     
    public Customer(String firstName, String lastName, CustomerType enums, ArrayList<Address> addresses){
        this.firstName = firstName;
        this.lastName = lastName;
        this.enums = enums;
        this.addresses = addresses;
        
    }
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Customer[ id=" + id + " ]";
    }
    
}
