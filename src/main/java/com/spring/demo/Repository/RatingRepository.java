package com.spring.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.demo.Entity.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, String> {
}