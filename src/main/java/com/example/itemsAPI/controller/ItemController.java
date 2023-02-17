```package com.example.itemsAPI.controller;

import com.example.itemsAPI.controller.dto.ItemDto;
import com.example.itemsAPI.repository.entity.Item;
//import com.example.itemsAPI.service.ItemNotFoundException;
import com.example.itemsAPI.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.reactive.WebFluxLinkBuilder.linkTo;
import static org.springframework.hateoas.server.reactive.WebFluxLinkBuilder.methodOn;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/item")
public class ItemController{

    @Autowired
    private final ItemService itemService;
//    private final ItemModelAssembler assembler;


    public ItemController(@Autowired
                          ItemService itemService)

    {
        this.itemService = itemService;
//        this.assembler = assembler;
    }

    @Configuration
    public class WebConfig implements WebMvcConfigurer {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOrigins("http://localhost:8080");
        }
    }

    @CrossOrigin("*")
    @GetMapping("/all")
    public Iterable<Item> getItems(){
        return itemService.all();
    }

//    @GetMapping("/items")
//    CollectionModel<EntityModel<Item>> all() {
//
//        List<EntityModel<Item>> items = itemService.all().stream() //
//                .map(assembler::toModel) //
//                .collect(Collectors.toList());
//
//        return CollectionModel.of(items, linkTo(methodOn(ItemController.class).all()).withSelfRel());
//    }

//    @GetMapping("/{id}")
//    EntityModel<Item> findItemById
//            (@PathVariable Integer id ){
//        Item item = itemService.findById( id )
//                .orElseThrow(() -> new ItemNotFoundException(id));
//        return assembler.toModel(item);
//    }
//
//    @GetMapping("/{id}")
//    EntityModel<Item> one(@PathVariable int id) {
//
//        Item item = itemService.findById(id) //
//                .orElseThrow(() -> new ItemNotFoundException(id));
//
//        return assembler.toModel(item);
//    }
    @CrossOrigin("*")
    @GetMapping("/{id}")
    public Optional<Item> findItemById
            (@PathVariable Integer id) {
        return itemService.findById(id);
    }

    @CrossOrigin("*")
    @PostMapping
    public Item save( @RequestBody ItemDto itemDto )
    {
        return itemService.addItem( new Item ( itemDto ) );

    }

    @CrossOrigin("*")
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

    @CrossOrigin("*")
    @DeleteMapping( "/{id}" )
    public void delete( @PathVariable Integer id )
    {
        itemService.delete( id );
    }
}```


