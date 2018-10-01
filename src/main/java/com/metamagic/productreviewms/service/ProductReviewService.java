package com.metamagic.productreviewms.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

import com.metamagic.productreviewms.dto.ProductReview;

public class ProductReviewService {

	private static final ProductReviewService productservice = new ProductReviewService();
	
	private HashMap<String, ProductReview> productmap = new LinkedHashMap<String, ProductReview>();
	
	private final List<String> users = new ArrayList<String>();
	private final List<String> desc = new ArrayList<String>();
	private final List<Integer> rating = new ArrayList<Integer>();
	
	private Random random = new Random();
	
	private ProductReviewService(){
		users.add("Araf Karsh");users.add("Ketan Gote");users.add("Buck Kulkarni");
		users.add("Sagar Jadhav");users.add("Dattaram Gawas");users.add("Kedar Kokil");
		users.add("Deepali Arvind");users.add("Rashmi Thakkar");users.add("Ashwini Arge");
		users.add("Medha Jadhav");users.add("Ankita Jain");users.add("Manisha Boddu");
		
		desc.add("I received the phone on Sunday, the 8th and everything was working fine right until less than 24 hours later when the phone automatically died on me with 98% battery on it. Tried switching it on, plugged in the charger, alternate charger, hard reset, followed Apple chat support troubleshooting steps but nothing. It is just a dead brick. ");
		desc.add("Awesome product. Exceeded expectations. Lightening fast delivery. Got it on the same day of the India launch. ");
		desc.add("Wow... I am the first person got it in the Bengaluru... very happy.... Phone looks very great.... excellent to use... iphone makes their brand.... ya it is almost equal to iphone 7 plus with some upgradations... worth to buy for gadget lovers... I too like that...");
		desc.add("all good in this phone but must need for camera improvement.Camera click photos in very low size.front camera is better then rear.");
		desc.add("And for people who are finding it difficult to order the phone in flash sale, I have small tips for you. ");
		
		rating.add(9);rating.add(8);rating.add(4);rating.add(6);rating.add(5);
		
	}
	
	public static ProductReviewService getInstance(){
		return productservice;
	}
	
	public Collection<ProductReview> getProductReview(String id){
		final List<ProductReview> productreview = new ArrayList<ProductReview>();
		for (int i = 0; i < 5; i++) {
			productreview.add(new ProductReview(id, this.getRandomList(users), this.getRandomList(desc), this.getRandomList(rating)));	
		}
		
		
		return productreview;
	}
	
	public <T> T getRandomList(List<T> list) {
	    int index = random.nextInt(list.size());
	    return list.get(index);
	    
	}
}
