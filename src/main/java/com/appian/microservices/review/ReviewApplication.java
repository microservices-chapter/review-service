package com.appian.microservices.review;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Review application.
 *
 * @author ben-edgar
 */
@SpringBootApplication
@RestController
@EnableSwagger2
public class ReviewApplication extends WebMvcConfigurerAdapter {

  @Autowired
  private CorrelationIdFilter correlationIdFilter;

  @Autowired
  private ReviewService reviewService;

  private static Logger LOG = LoggerFactory.getLogger("com.appian.microservices.review");

  public ReviewApplication() {

  }

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build()
        .pathMapping("/");
  }

  @GetMapping(value = "/review/list")
  public @ResponseBody
  List<Review> listAll() {
    LOG.info("Hit the listAll endpoint!");
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

  @GetMapping(value = "/review/list/product/{sku}/rating/{rating}")
  public @ResponseBody
  List<Review> listBySkuAndRating(
      @PathVariable
          String sku,
      @PathVariable
          int rating) {
    LOG.info("Hit the listBySkuAndRating endpoint!");
    return reviewService.listBySkuAndRating(sku, rating);
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
