package com.appian.microservices.review;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
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

  @GetMapping(value = "/review/list")
  public @ResponseBody
  List<Review> listAll() {
    LOG.info("Hit the listBySku endpoint!");
    return reviewService.listAll();
  }

  @GetMapping(value = "/review/list/product/{sku}")
  public @ResponseBody
  List<Review> listBySku(
      @PathVariable
          String sku) {
    LOG.info("Hit the listBySku endpoint!");
    return reviewService.listBySku(sku);
  }

  @GetMapping(value = "/review/list/customer/{customerId}")
  public @ResponseBody
  List<Review> listByCustomerId(
      @PathVariable
          String customerId) {
    LOG.info("Hit the listByCustomerId endpoint!");
    return reviewService.listByCustomerId(customerId);
  }

  @PostMapping(value = "/review/add")
  public @ResponseBody
  Review add(
      @RequestBody
          Review review) {
    LOG.info("Hit the add endpoint!");
    return reviewService.add(review);
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(correlationIdFilter);
  }

  public static void main(String[] args) {
    SpringApplication.run(ReviewApplication.class, args);
  }
}
