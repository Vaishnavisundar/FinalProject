package com.capgemini.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.model.FeedBack;

public interface FeedbackCommonRepository extends JpaRepository<FeedBack, Integer> {

	@Query("Select f from FeedBack f where f.id=?1")
	public FeedBack getComments(int id);

	@Query("Select f from FeedBack f,Merchant m where m.id=?1")
	public List<FeedBack> postMerchantComments(int merchantId);

	@Query("Select p.id from Product p where p.merchant.id=?1")
	public List<Integer> getProductIdFromMerchantId(int merchantId);

	@Query("Select p.feedback from Product p where p.id=?1")
	public List<FeedBack> getFeedbackIdForThatProductId(int productId);

}
