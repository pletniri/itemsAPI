//package com.example.itemsAPI;
//import com.example.itemsAPI.repository.entity.Item;
//import com.example.itemsAPI.service.ItemService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//class LoadDatabase {
//
//    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
//
//    @Bean
//    CommandLineRunner initDatabase(ItemService itemService) {
//
//        return args -> {
//            log.info("Preloading " + itemService.addItem(new Item("car", "red", "url")));
//            log.info("Preloading " + itemService.addItem(new Item("track", "white", "url")));
//        };
//    }
//}