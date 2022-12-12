package com.example.itemsAPI.service;

import com.example.itemsAPI.repository.entity.Item;
import com.example.itemsAPI.repository.entity.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(@Autowired ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getItem() {
        //TODO implement this method
        return itemRepository.findAll();
//        return item;

    }

    public Optional<Item> findById(int id) {
        //TODO implement this method
        return itemRepository.findById(id);

    }

//    public List<Item> findByName(String name) {
//        return itemRepository.findByName(name);
//    }

    public Item addNewItem(Item item) {
        return itemRepository.save(item);
    }


    public void delete(int id) {
        //TODO implement this method
        itemRepository.deleteById(id);

    }



}


//    public List<Item> all()
//    {
//        //TODO implement this method
//        List<Item> result = new ArrayList<>();
//        itemRepository.findAll().forEach( result::add );
//        return result;
//    }




//package org.generation.ItemsAPI.service;
//
//        import org.generation.ItemsAPI.repository.entity.Item;
//
//        import java.util.List;
//
//public interface ItemService
//{
//
//    Item save( Item item );
//
//    void delete( int itemId );
//
//    List<Item> all();
//
//    Item findById( int itemId );
//
//}
//    @PostMapping
//    public Item save( @RequestBody ItemDto itemDto )
//    {
//        return itemService.save( new Item( itemDto ) );
//    }
//Item newItem = new Item(itemDto);
//
//System.out.println("New Item: " + newItem.getPrice() + newItem.getId() + newItem.getItemName());