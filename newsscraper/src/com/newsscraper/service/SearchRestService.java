package com.newsscraper.service;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.newsscraper.beans.SearchResponse;


//Rest path : //http://localhost:8090/newsscraper/rest/newsscraperservice/{operation_name}

@RestController
@RequestMapping(value="/rest/newsscraperservice" , produces = MediaType.APPLICATION_JSON_VALUE)
public class SearchRestService {

	@RequestMapping(value = "/getArticleDetailsByAuthor/{author}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody String getArticleDetailsByAuthor(@PathVariable String author) {

		String jsonResponse = null;
		SearchResponse response=new SearchResponse();
		ObjectMapper mapper = new ObjectMapper();
		try {
			if(author.equals("A") || author.equals("B") || author.equals("C")) {
				response.setAuthorName("ABC");
				response.setArticleTitle("AtricleA");
				response.setDescription("News Scraper Assignment");
			}else {
				response.setAuthorName("No Authors found");
			}
			jsonResponse = mapper.writeValueAsString(response);
		
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonResponse;
	
	}
	
	@RequestMapping(value = "/getAuthors/", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody String getAuthors(@PathVariable String author) {

		String jsonResponse = null;
		ObjectMapper mapper = new ObjectMapper();
		try {			
			List<SearchResponse> responseList=new ArrayList<>();
			responseList.add(new SearchResponse("A", "Atricle A", "News Scraper Assignment A"));
			responseList.add(new SearchResponse("B", "Atricle B", "News Scraper Assignment B"));
			responseList.add(new SearchResponse("C", "Atricle C", "News Scraper Assignment C"));
			responseList.add(new SearchResponse("D", "Atricle D", "News Scraper Assignment D"));
		    jsonResponse = mapper.writeValueAsString(responseList);
		
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonResponse;
	
	}
	
	
	@RequestMapping(value = "/getArticleDetailsByArticle/{article}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody String getArticleDetailsByArticle(@PathVariable String article) {

		String jsonResponse = null;
		SearchResponse response=new SearchResponse();
		ObjectMapper mapper = new ObjectMapper();
		try {
			
			if(article.equals("Article A") || article.equals("Article B") || article.equals("Article C")) {
				//Respond the Response object based on Article name
				List<SearchResponse> responseList=new ArrayList<>();
				responseList.add(new SearchResponse("B", "Atricle B", "News Scraper Assignment B"));
				responseList.add(new SearchResponse("C", "Atricle C", "News Scraper Assignment C"));
				jsonResponse = mapper.writeValueAsString(responseList);
			}else {
				response.setDescription("No Articles Found by article");
				jsonResponse = mapper.writeValueAsString(response);
			}
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonResponse;
	
	}
	
	@RequestMapping(value = "/getArticleDetailsByDescription/{description}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody String getArticleDetailsByDescription(@PathVariable String description) {

		String jsonResponse = null;
		SearchResponse response=new SearchResponse();
		ObjectMapper mapper = new ObjectMapper();
		try {
			
			if(response.getDescription().contains(description)) {
				//Respond the  List of Response objects based on description
				response.setAuthorName("ABC");
				response.setArticleTitle("AtricleA");
				response.setDescription("News Scraper Assignment");
			}else {
				response.setArticleTitle("No Article Found by Description");
			}
			jsonResponse = mapper.writeValueAsString(response);
		
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonResponse;
	
	}
}
