package com.example.jspdemo.service;


import com.example.jspdemo.model.Listing;
import com.example.jspdemo.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ListingService {

    private ListingRepository listingRepository;
    private int listings=0;

    @Autowired
    public ListingService(ListingRepository listingRepository){
        this.listingRepository=listingRepository;
    }

    public List<Listing> getAllListings(){
        return this.listingRepository.findAll();
    }

    public Listing getListingById(int id){
        return this.listingRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Listing with id:"+id+" doesn't exist"));
    }

    public int saveListing(Listing listing){
        ++listings;
        System.out.println("\n\n\n new id "+listing.getId()+" before save \n\n\n");
        return this.listingRepository.save(listing).getId();
    }

    public Listing updateListing( Listing listing) {
        Optional<Listing> existingListing = listingRepository.findById(listing.getId());


        if (existingListing.isPresent()) {
            listing.setPhoto("/assets/house.jpg");
            return listingRepository.save(listing);
        } else {
            throw new RuntimeException("Listing not found  id:" + listing.getId());
        }
    }

    public void deleteListing(int id){
        --listings;
        Optional<Listing> listing=this.listingRepository.findById(id);
        if(listing.isPresent())
            this.listingRepository.deleteById(id);
        else
            throw new RuntimeException("Listing not found id:"+id);
    }

    public int getListings() {
        return listings;
    }
}
