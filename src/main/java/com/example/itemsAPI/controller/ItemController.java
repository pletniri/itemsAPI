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

    @GetMapping("getItems/all")
    public List<Item> getItems(){
        return itemService.getItem();
    }

    @GetMapping("findItemById/{id}")
    public Optional<Item> findItemById(@PathVariable Integer id ){
        return itemService.findById( id );
    }

//    @GetMapping("findItemByName/{name}")
//    public List<Item> findByName(@PathVariable String name) { return itemService.findByName(name);}

//    @RequestMapping(value = "/findByName/{name}", method = RequestMethod.GET)
//    @ResponseBody
//    public List<Item> findByName(@PathVariable String name, @PathVariable String rollNumber) {
//        List<Item> itemResponse = (List<Item>) itemService.findByName(name);
//        return itemResponse;
//    }

    @PostMapping("save/all")
    public Item save( @RequestBody ItemDto itemDto )
    {
        return itemService.addNewItem( new Item ( itemDto ) );

    }


    @PutMapping( "addItem/{id}" )
    public void addItem( @RequestBody ItemDto itemDto,
                        @PathVariable Integer id )
    {
        Item item = itemService.findById( id ).get();
        item.setName( itemDto.getName() );
        item.setDescription( itemDto.getDescription() );
        item.setImageUrl( itemDto.getImageUrl() );
        itemService.addNewItem( item );
    }


    @DeleteMapping( "delete/{id}" )
    public void delete( @PathVariable Integer id )
    {
        itemService.delete( id );
    }
}

//@RestController
//@RequestMapping
//public class StudentController {
//
//    @Autowired
//    private StudentService studentService;
//
//    @GetMapping(path = "students")
//    public List<Student> getStudents(){
//        return studentService.getStudents();
//    };
//
//
//}