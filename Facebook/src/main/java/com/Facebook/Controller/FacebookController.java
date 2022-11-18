package com.Facebook.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Facebook.Service.FacebookService;


@RestController
@RequestMapping("/")
public class FacebookController {
	
	@Autowired
	private FacebookService facebookService;

	@GetMapping
	public List<String> welcome()
	{
		List<String>urls=new ArrayList<String>();
		urls.add("http://localhost:8080/generateFacebookAuthorizeUrl");
		urls.add("http://localhost:8080/facebook");
		urls.add("http://localhost:8080/getUserdata");
		urls.add("http://localhost:8080/getUserFeed");

		return urls;
	}
	
	@GetMapping("/generateFacebookAuthorizeUrl")
	public String generateFacebookAuthorizeUrl()
	{
		return facebookService.generateFacebookAuthorizeUrl();

	}
	
	@GetMapping("/facebook")
	public void generateFacebookAccesstoken(@RequestParam("code") String code)
	{
		facebookService.generateFacebookAccesstoken(code);
	}
	@GetMapping("/getUserData")
	public String getUserdat()
	{
		return facebookService.getUserData();
	}
	
	@GetMapping("/getUserFeed")
	public PagedList<Post> getUserFeed()
	{
		return facebookService.getUserFeed();
	}
}
