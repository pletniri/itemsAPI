package com.example.itemsAPI.controller;

import com.example.itemsAPI.controller.dto.ItemDto;
import com.example.itemsAPI.repository.entity.Item;
import com.example.itemsAPI.repository.entity.ItemRepository;
import com.example.itemsAPI.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/item")
public class ItemController{

    @Autowired
    private final ItemService itemService;


    public ItemController(@Autowired ItemService itemService )
    {
        this.itemService = itemService;
    }

    @GetMapping("/all")
    public Iterable<Item> getItems(){
        return itemService.all();
    }

    @GetMapping("/{id}")
    public Optional<Item> findItemById
            (@PathVariable Integer id ){
        return itemService.findById( id );
    }

    @PostMapping
    public Item save( @RequestBody ItemDto itemDto )
    {
        return itemService.addItem( new Item ( itemDto ) );

    }


    @PutMapping( "/{id}" )
    public void update( @RequestBody ItemDto itemDto,
                        @PathVariable Integer id )
    {
        Item item = itemService.findById( id ).get();
        item.setName( itemDto.getName() );
        item.setDescription( itemDto.getDescription() );
        item.setImageUrl( itemDto.getImageUrl() );
        itemService.addItem( item );

    }


    @DeleteMapping( "/{id}" )
    public void delete( @PathVariable Integer id )
    {
        itemService.delete( id );
    }
}

