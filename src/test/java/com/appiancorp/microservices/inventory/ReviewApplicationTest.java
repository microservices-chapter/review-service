package com.appiancorp.microservices.inventory;

import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import com.appian.microservices.review.Review;
import com.appian.microservices.review.ReviewApplication;

public class ReviewApplicationTest {
    @Test
    public void testList() {
        ReviewApplication inventoryApplication = new ReviewApplication();
//        List<Review> list = inventoryApplication.listBySku("1");
//        Assert.assertThat(list.size(), CoreMatchers.equalTo(0));
    }
}
