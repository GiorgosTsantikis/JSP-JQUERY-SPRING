package com.example.jspdemo.repository;

import com.example.jspdemo.model.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListingRepository extends JpaRepository<Listing,Integer> {
}
