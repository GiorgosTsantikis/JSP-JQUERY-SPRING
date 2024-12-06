package com.example.jspdemo.controller;

import com.example.jspdemo.model.Listing;
import com.example.jspdemo.service.ListingService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        model.addAttribute("title","Home");
        model.addAttribute("contentPage",
                "/WEB-INF/jsp/home-view.jsp");
        return "main";
    }

    @GetMapping("/listing/{id}")
    public String detailsView(@PathVariable int id, Model model){
        model.addAttribute("listing",this.listingService.getListingById(id));
        model.addAttribute("title","Listing Details");
        model.addAttribute("contentPage",
                "/WEB-INF/jsp/listing-view.jsp");
        return "main";
    }

    @GetMapping("/addListing")
    public String getAllListings(Model model) {
        model.addAttribute("title","Create Listing");
        model.addAttribute("contentPage",
                "/WEB-INF/jsp/create-listing.jsp");
        return "main";
    }

    @PostMapping("/addListing")
    public String createListing(@ModelAttribute Listing listing, Model model){
        listing.setPhoto("/assets/house.jpg");
        this.listingService.saveListing(listing);
        System.out.println(listing);
        model.addAttribute("title","Home");
        model.addAttribute("contentPage",
                "/WEB-INF/jsp/home-view.jsp");
        return "redirect:home";
    }

    @GetMapping("/editListing/{id}")
    public String editListing(@PathVariable int id,Model model){
        Listing listing=this.listingService.getListingById(id);
        model.addAttribute("listing",listing);
        model.addAttribute("title","Edit Listing");
        model.addAttribute("contentPage","/WEB-INF/jsp/edit-view.jsp");
        return "main";
    }

    @PostMapping("/updateListing/{id}")
    public String updateListing(@PathVariable int id,@ModelAttribute Listing listing,Model model){
        System.out.println("\n\n\n"+listing+"\n\n\n");
        this.listingService.updateListing(listing);
        return "redirect:/listing/"+id;
    }








}
