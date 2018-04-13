package com.appian.microservices.review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Review application.
 *
 * @author ben-edgar
 */
@SpringBootApplication
@RestController
public class ReviewApplication extends WebMvcConfigurerAdapter {

  @Autowired
  private CorrelationIdFilter correlationIdFilter;

  @Autowired
  private ReviewService reviewService;

  private static Logger LOG = LoggerFactory.getLogger("com.appian.microservices.review");

  public ReviewApplication() {

  }

  @GetMapping(value = "/review/{productId}")
  public @ResponseBody
  List<Review> list(
      @PathVariable
          String productId) {
    LOG.info("Hit the list endpoint!");
    return reviewService.getReviews(productId);
  }

  @PostMapping(value = "/review/{productId}")
  public @ResponseBody
  boolean add(
      @PathVariable
          String productId,
      @RequestBody
          Review review) {
    LOG.info("Hit the add endpoint!");
    return reviewService.addReview(productId, review);
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(correlationIdFilter);
  }

  public static void main(String[] args) {
    SpringApplication.run(ReviewApplication.class, args);
  }
}
