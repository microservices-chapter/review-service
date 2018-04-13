package com.appian.microservices.review;

public class Review {
  private String customerId;

  private String reviewHeader;
  private String reviewBody;
  private int rating;

  public Review() {
    this.customerId = "";
    this.reviewHeader = "";
    this.reviewBody = "";
    this.rating = 0;
  }

  public Review(String customerId, String reviewHeader, String reviewBody, int rating) {
    this.customerId = customerId;
    this.reviewHeader = reviewHeader;
    this.reviewBody = reviewBody;
    this.rating = rating;
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

  public int getRating() {
    return rating;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public void setReviewHeader(String reviewHeader) {
    this.reviewHeader = reviewHeader;
  }

  public void setReviewBody(String reviewBody) {
    this.reviewBody = reviewBody;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }
}
