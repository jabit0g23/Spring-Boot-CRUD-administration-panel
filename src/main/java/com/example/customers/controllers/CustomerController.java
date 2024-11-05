package com.example.customers.controllers;

import com.example.customers.entities.Customers;
import com.example.customers.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CustomerController {

    @Autowired //hace que la variable CustomerServices se cargue;
    //Estoy importando la interface, y no CustomerServicesimp, esto hace el codigo un poco más desacoplado
    //Autowired es similar a un 'Singleton'
    private CustomerServices services;

    @GetMapping("/customer/{id}") //traer un cliente
    public Customers getCustomer(@PathVariable Integer id){
        return services.getCustomer(id);
    }

    @GetMapping("/customer") //traer todos los clientes
    public List<Customers> getAllCustomers(){
        return services.getAllCustomers();
    }

    @DeleteMapping("/customer/{id}") //Eliminar cliente
    public void removeCustomer(@PathVariable Integer id){
        services.removeCustomer(id);
    }

    @PostMapping("/customer") //Agregar cliente
    public void addCustomer(@RequestBody Customers customer){
        services.addCustomer(customer);
    }

    @PutMapping("/customer/{id}") //Modificar cliente
    public void updateCustomer(@PathVariable Integer id, @RequestBody Customers updateCustomer){
        services.updateCustomer(id, updateCustomer);
    }

    //http://localhost:8080/customer/search?name=javier
    @GetMapping("/customer/search") //Buscar cliente
    public List<Customers> searchCustomer(@RequestParam(name = "email" , required = false) String email,
                                          @RequestParam(name = "name", required = false) String name){

        return  services.searchCustomer(email, name);
    }
}
