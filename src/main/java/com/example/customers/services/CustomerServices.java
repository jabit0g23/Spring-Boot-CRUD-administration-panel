package com.example.customers.services;

import com.example.customers.entities.Customers;

import java.util.List;

public interface CustomerServices {

    public Customers getCustomer(Integer id);

    public List<Customers> getAllCustomers();

    public void removeCustomer(Integer id);

    public void addCustomer(Customers customer);

    public void updateCustomer(Integer id, Customers updateCustomer);

    public List<Customers> searchCustomer(String email, String name);

}
