package com.appian.microservices.review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

  public List<Review> listByCustomerId(String customerId) {
    return repo.findByCustomerId(customerId);
  }

  public Review add(Review review) {
    return repo.save(review);
  }

}
