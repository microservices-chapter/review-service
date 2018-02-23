package com.appian.microservices.review;

public class Review {
  private String customerId;
  private String reviewHeader;
  private String reviewBody;

  public Review(String customerId, String reviewHeader, String reviewBody) {
    this.customerId = customerId;
    this.reviewHeader = reviewHeader;
    this.reviewBody = reviewBody;
  }

  public String getCustomerId() {
    return customerId;
  }

  public String getReviewHeader() {
    return reviewHeader;
  }

  public String getReviewBody() {
    return reviewBody;
  }
}
