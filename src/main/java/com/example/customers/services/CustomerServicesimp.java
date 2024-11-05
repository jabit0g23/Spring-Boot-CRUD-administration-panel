package com.example.customers.services;

import com.example.customers.entities.Customers;
import com.example.customers.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServicesimp implements CustomerServices {

    @Autowired
    private CustomerRepository repository;

    public Customers getCustomer(Integer id){
        Optional<Customers> customer = repository.findById(id);
        if(customer.isPresent()){
           return customer.get();
        }
        return null;
    }

    public List<Customers> getAllCustomers(){
        List<Customers> list = new ArrayList<>();
        Iterable<Customers> customers = repository.findAll();
        for (Customers customer : customers) {
            list.add(customer);
        }

        return list;
    }

    public void removeCustomer(Integer id){
        repository.deleteById(id);
    }

    /*
    {
    "name": "Test",
    "lastname": "Test",
    "email": "Test",
    "address": "Test"
    }
    */

    public void addCustomer(Customers customer){
        repository.save(customer);
    }

    public void updateCustomer(Integer id, Customers updateCustomer){
        updateCustomer.setId(id);
        repository.save((updateCustomer));
    }

    public List<Customers> searchCustomer(String email, String name){
        return repository.findByEmailOrName(email, name);
    }

}
