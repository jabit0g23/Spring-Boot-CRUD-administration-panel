package com.example.customers.repository;

import com.example.customers.entities.Customers;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customers, Integer> {

    // Spring Data JPA crea automáticamente la consulta derivada por nombre de método
    List<Customers> findByEmailOrName(String email, String name);

    // Esto es SQL nativo, corregido. Se debe usar la anotación nativeQuery = true
    @Query(value = "SELECT * FROM customers WHERE email LIKE %:email% OR name LIKE %:name%", nativeQuery = true)
    List<Customers> findByEmailOrName2(@Param("email") String email, @Param("name") String name);

    // Esto es HQL (Hibernate), donde se hace referencia a la clase en lugar de la tabla
    @Query("SELECT c FROM Customers c WHERE c.email LIKE %:email% OR c.name LIKE %:name%")
    List<Customers> findByEmailOrName3(@Param("email") String email, @Param("name") String name);

}
