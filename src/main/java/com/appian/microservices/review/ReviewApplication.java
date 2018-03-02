package com.appian.microservices.review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Review application.
 *
 * @author ben-edgar
 */
@SpringBootApplication
@RestController
public class ReviewApplication {

  Map<String, List<Review>> reviewMap;

  public ReviewApplication() {
    reviewMap = new HashMap<String, List<Review>>();
    List<Review> oneRecommendations = new ArrayList<Review>();
    oneRecommendations.add(new Review("1", "Best Product 1", "This is why its the best! 1"));
    List<Review> twoRecommendations = new ArrayList<Review>();
    twoRecommendations.add(new Review("2", "Best Product 2", "This is why its the best! 2"));

    reviewMap.put("1", oneRecommendations);
    reviewMap.put("2", twoRecommendations);
  }

  @GetMapping(value = "/review/{productId}")
  public  @ResponseBody List<Review> list(@PathVariable String productId) {
    return reviewMap.get(productId);
  }

  @PostMapping(value = "/review/{productId}")
  public  @ResponseBody boolean add(@PathVariable String productId, @RequestBody Review review) {
    List<Review> reviews = reviewMap.get(productId);
    reviews.add(review);
    reviewMap.put(productId, reviews);
    return true;
  }

  public static void main(String[] args) {
    SpringApplication.run(ReviewApplication.class, args);
  }
}
