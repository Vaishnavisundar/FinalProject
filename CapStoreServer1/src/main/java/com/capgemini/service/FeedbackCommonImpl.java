package com.capgemini.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.model.FeedBack;
import com.capgemini.repository.FeedbackCommonRepository;

@Service
public class FeedbackCommonImpl implements FeedbackCommon {

	@Autowired
	private FeedbackCommonRepository repo;

	@Override
	public FeedBack getComments(int id) {
		return repo.getComments(id);
	}

	@Override
	public List<FeedBack> displayAllFeedback() {
		return repo.findAll();
	}

	@Override
	public List<List<FeedBack>> postMerchantComments(int merchantId) {
		
		List<Integer> productIdList = new ArrayList<Integer>();
		List<List<FeedBack>> feedbackIdList = new ArrayList<>();
         
		productIdList = repo.getProductIdFromMerchantId(merchantId);
		
		for (Integer id : productIdList) {
			if (!repo.getFeedbackIdForThatProductId(id).isEmpty()) {
				feedbackIdList.add(repo.getFeedbackIdForThatProductId(id));
			}
			}
		
		repo.postMerchantComments(merchantId);
		return feedbackIdList;
	}

	@Override
	public FeedBack reponseToCustomer(FeedBack feedback) {
		return repo.save(feedback);
	}

}