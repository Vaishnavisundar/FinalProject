package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.model.FeedBack;
import com.capgemini.service.FeedbackCommon;

@RestController
public class FeedbackController {

	@Autowired
	FeedbackCommon service;

	// to get particular comment
	@RequestMapping(value = "/getcomment")
	public FeedBack getCommentsFromCustomer(int id) {
		return service.getComments(id);
	}

	// to post all comments in admin page
	@RequestMapping(value = "/admincomments", method = RequestMethod.POST)
	public List<FeedBack> postAllcomments(@RequestBody FeedBack feedback) {
		return service.displayAllFeedback();
	}

	// to post the comments for a particular merchant in the merchant page
	// enter the merchant id to get the required feedback for that merchant regarding the product
	@RequestMapping(value = "/merchantcomments",method = RequestMethod.POST)
	public List<List<FeedBack>> postMerchantComments(int id) {
		return service.postMerchantComments(id);
	}

	// to give response to the customer for the comment
	@RequestMapping(value = "/response", method = RequestMethod.POST)
	public FeedBack responseToCustomer(@RequestBody FeedBack feedback) {
		return service.reponseToCustomer(feedback);
	}
}
