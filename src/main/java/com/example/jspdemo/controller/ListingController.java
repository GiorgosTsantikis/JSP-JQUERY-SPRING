package com.example.jspdemo.controller;

import com.example.jspdemo.model.Listing;
import com.example.jspdemo.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ListingController {

    private ListingService listingService;

    @Autowired
    public ListingController(ListingService listingService){
        this.listingService=listingService;
    }

    @GetMapping("/home")
    public String homeView(Model model){
        model.addAttribute("listings",this.listingService.getAllListings());
        model.addAttribute("contentPage",
                "/WEB-INF/jsp/home-view.jsp");
        return "main";
    }

    @GetMapping("/listing/{id}")
    public String detailsView(@PathVariable int id, Model model){
        model.addAttribute("listing",this.listingService.getListingById(id));
        model.addAttribute("contentPage",
                "/WEB-INF/jsp/listing-view.jsp");
        return "main";
    }

    @GetMapping("/addListing")
    public String getAllListings(Model model) {
        model.addAttribute("contentPage",
                "/WEB-INF/jsp/create-listing.jsp");
        return "main";
    }






}
