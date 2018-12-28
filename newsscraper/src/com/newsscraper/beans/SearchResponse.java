package com.newsscraper.beans;

public class SearchResponse {

	private String authorName;
	private String articleTitle;
	private String description;
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getArticleTitle() {
		return articleTitle;
	}
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public SearchResponse(String authorName, String articleTitle, String description) {
		super();
		this.authorName = authorName;
		this.articleTitle = articleTitle;
		this.description = description;
	}
	public SearchResponse() {
		// TODO Auto-generated constructor stub
	}
	
}
