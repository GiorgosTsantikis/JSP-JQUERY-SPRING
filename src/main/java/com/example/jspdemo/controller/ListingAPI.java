package com.example.jspdemo.controller;

import com.example.jspdemo.service.ListingService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListingAPI {

    private ListingService listingService;

    public ListingAPI(ListingService listingService){
        this.listingService=listingService;
    }

    @GetMapping("/getListingNumber")
    public int getNumber(){
        return this.listingService.getListings();
    }

    @DeleteMapping("/listing/{id}")
    public void deleteListing(@PathVariable int id){
        this.listingService.deleteListing(id);
    }
}
