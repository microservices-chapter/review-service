package com.appian.microservices.review;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "review")
@CompoundIndexes({
    @CompoundIndex(name = "sku_customerId", def = "{'sku': 1, 'customerId': 1}", unique = true)
})
public class Review {
  @Id
  private String id;

  private String customerId;
  private String sku;

  private String header;
  private String body;
  private int rating;

  public Review() {
    this.customerId = "";
    this.header = "";
    this.body = "";
    this.rating = 0;
  }

  public Review(String customerId, String sku, String header, String body, int rating) {
    this.customerId = customerId;
    this.sku = sku;
    this.header = header;
    this.body = body;
    this.rating = rating;
  }

  public String getCustomerId() {
    return customerId;
  }

  public String getHeader() {
    return header;
  }

  public String getBody() {
    return body;
  }

  public int getRating() {
    return rating;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public void setHeader(String header) {
    this.header = header;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }
}
