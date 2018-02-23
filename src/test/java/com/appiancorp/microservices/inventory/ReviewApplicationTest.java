package com.appiancorp.microservices.inventory;

import com.appian.microservices.review.Review;
import com.appian.microservices.review.ReviewApplication;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ReviewApplicationTest {
    @Test
    public void testList() {
        ReviewApplication inventoryApplication = new ReviewApplication();
        List<Review> list = inventoryApplication.list("1");
        Assert.assertThat(list.size(), CoreMatchers.equalTo(1));
    }
}
