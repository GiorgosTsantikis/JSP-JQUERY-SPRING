package com.example.jspdemo.controller;

import com.example.jspdemo.model.Applicant;
import com.example.jspdemo.service.ListingService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/application/{id}")
    public Applicant acceptApplication(@RequestBody Applicant applicant, @PathVariable int id, Model model){
        System.out.println(applicant);


        return applicant;

    }
}
