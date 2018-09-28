package com.metamagic.productreviewms.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.metamagic.productreviewms.dto.ProductReview;

public class ProductReviewService {

	private static final ProductReviewService productservice = new ProductReviewService();
	
	private HashMap<String, ProductReview> productmap = new LinkedHashMap<String, ProductReview>();
	
	private ProductReviewService(){
	}
	
	public static ProductReviewService getInstance(){
		return productservice;
	}
	
	public Collection<ProductReview> getProductReview(String id){
		final List<ProductReview> productreview = new ArrayList<ProductReview>();
		productreview.add(new ProductReview(id, "Ketan Gote", "Very Good, value for money", Integer.valueOf(9)));
		productreview.add(new ProductReview(id, "Sagar Jadhav", "Average Phone", Integer.valueOf(5)));
		productreview.add(new ProductReview(id, "Dattaram Gawas", "Good", Integer.valueOf(3)));
		productreview.add(new ProductReview(id, "Deepali Arvind", "Bad", Integer.valueOf(4)));
		productreview.add(new ProductReview(id, "Kedar Kokil", "Very Bad, not value for money", Integer.valueOf(1)));
		
		return productreview;
	}
}
