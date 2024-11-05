package com.example.customers.repository;

import com.example.customers.entities.Customers;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customers, Integer> {

    //hibernate, hace solo por detras la función, solo debemos declarar la interfaz
    List<Customers> findByEmailOrName(String email, String name);

    // Esto es SQL
    // SQL va por tablas
    @Query("SELECT * FROM 'customers' WHERE 'email' LIKE '%gmail%' OR 'name' LIKE '%gmail%';")
    List<Customers> findByEmailOrName2(String email, String name);

    // Esto es HQL (Hibernate)
    // Similar a SQL, pero HQL no va por tablas
    // Va por clases, es decir, debemos referenciar a la clase de Customers

    @Query("SELECT c FROM Customers c WHERE email LIKE %:email% OR name LIKE %:name%")

    //Customers c , "c" es la abrebiatura de Customers, es un nombre
    //:email, busca el email tal cual
    //%:email% busca los que contengan

    List<Customers> findByEmailOrName3(@Param("email") String email, @Param("name") String name);

}
