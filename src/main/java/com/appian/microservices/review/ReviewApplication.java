package com.appian.microservices.review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Review application.
 *
 * @author ben-edgar
 */
@SpringBootApplication
@RestController
public class ReviewApplication {

  private static Logger LOG = LoggerFactory.getLogger(ReviewApplication.class);

  Map<String,List<Review>> reviewMap;

  public ReviewApplication() {
    reviewMap = new HashMap<String,List<Review>>();
    List<Review> oneRecommendations = new ArrayList<Review>();
    oneRecommendations.add(new Review("1", "Best Product 1", "This is why its the best! 1"));
    List<Review> twoRecommendations = new ArrayList<Review>();
    twoRecommendations.add(new Review("2", "Best Product 2", "This is why its the best! 2"));

    reviewMap.put("1", oneRecommendations);
    reviewMap.put("2", twoRecommendations);
  }

  @GetMapping(value = "/review/{productId}")
  public @ResponseBody
  List<Review> list(
      @PathVariable
          String productId) {
    LOG.info("Hit the list endpoint!");
    return reviewMap.get(productId);
  }

  @PostMapping(value = "/review/{productId}")
  public @ResponseBody
  boolean add(
      @PathVariable
          String productId,
      @RequestBody
          Review review) {
    LOG.info("Hit the add endpoint!");
    List<Review> reviews = reviewMap.get(productId);
    reviews.add(review);
    reviewMap.put(productId, reviews);
    return true;
  }

  public static void main(String[] args) {
    SpringApplication.run(ReviewApplication.class, args);
  }
}
