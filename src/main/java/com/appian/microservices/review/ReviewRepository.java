package com.appian.microservices.review;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review, String> {

  Review findBySkuAndCustomerId(String sku, String customerId);

  List<Review> findByCustomerId(String customerId);

  List<Review> findBySku(String sku);

  List<Review> findBySkuAndRating(String sku, int rating);
}
