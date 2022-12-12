package com.example.itemsAPI.repository.entity;

import com.example.itemsAPI.repository.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called itemRepository
// CRUD refers Create, Read, Update, Delete
public interface ItemRepository extends JpaRepository<Item, Integer>
{

    //should  I add methods here?

//    List<Item> findByName(String name);

// @Query("select s from Item s where s.name = :name")
// List<Item> findByName(@Param("name") String name);

}