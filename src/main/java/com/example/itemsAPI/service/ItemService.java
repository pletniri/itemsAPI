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

    public List<Item> all() {
        //TODO implement this method
        return itemRepository.findAll();
//        return item;

    }

    public Optional<Item> findById(int id) {
        //TODO implement this method
        return itemRepository.findById(id);

    }

    public Item addItem(Item item) {
        return itemRepository.save(item);
    }


    public void delete(int id) {
        //TODO implement this method
        itemRepository.deleteById(id);

    }
}

