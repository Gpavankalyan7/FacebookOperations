package com.Facebook.Service;

import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.web.bind.annotation.RequestParam;


//this is the Service interface.

public interface FacebookService {

	public String generateFacebookAuthorizeUrl();
	
	public void generateFacebookAccesstoken(String code);

	public String getUserData();

    public PagedList<Post> getUserFeed(); 


}
