package com.appian.microservices.review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

@Service
public class ReviewService {

  Map<String,List<Review>> reviewMap;

  public ReviewService() {
    reviewMap = new HashMap<String,List<Review>>();
    List<Review> oneRecommendations = new ArrayList<Review>();
    oneRecommendations.add(new Review("1", "Best Product 1", "This is why its the best! 1", 5));
    List<Review> twoRecommendations = new ArrayList<Review>();
    twoRecommendations.add(new Review("2", "Best Product 2", "This is why its the best! 2", 4));

    reviewMap.put("1", oneRecommendations);
    reviewMap.put("2", twoRecommendations);
  }

  public List<Review> getReviews(String productId) {
    return reviewMap.get(productId);
  }

  public boolean addReview(String productId, Review review) {
    List<Review> reviews = reviewMap.get(productId) == null ? Lists.newArrayList() : reviewMap.get(productId);
    reviews.add(review);
    reviewMap.put(productId, reviews);
    return true;
  }

}
