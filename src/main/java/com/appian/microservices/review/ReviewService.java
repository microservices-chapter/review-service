package com.appian.microservices.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

  // docker run --name mongodb -p 27017:27017 mongo
  // docker start mongodb
  // show dbs
  // show collections
  // db.test_table.find( {} )
  // db.test_table.find( { _id: "2" } )

  @Autowired
  private ReviewRepository repo;

  public ReviewService() {
  }

  public List<Review> listAll() {
    return repo.findAll();
  }

  public List<Review> listBySku(String sku) {
    return repo.findBySku(sku);
  }

  public List<Review> listBySkuAndRating(String sku, int rating) {
    return repo.findBySkuAndRating(sku, rating);
  }

  public List<Review> listByCustomerId(String customerId) {
    return repo.findByCustomerId(customerId);
  }

  public Review add(Review review) {
    Review prevReview = repo.findBySkuAndCustomerId(review.getSku(), review.getCustomerId());
    if (prevReview == null) {
      return repo.save(review);
    }
    prevReview.setHeader(review.getHeader());
    prevReview.setBody(review.getBody());
    prevReview.setRating(review.getRating());
    return repo.save(review);
  }

}
