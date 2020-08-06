package com.qthonservices.practisemcqservices.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "practisemcq")
public class PractiseMcq {
	private String id;
	  private String skills ;
	  private String taxonomy;
	  private String difficultylevel;
	 private String classification;
	 private String multipleanswers;
	  private String topic;
	  private String questionsource;
	  private String questiontext;
	  private String option1;
	  private String option1correct;
	  private String option2;
	  private String option2correct;
	  private String option3;
	  private String option3correct;
	  
	  @DynamoDBHashKey
	  public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@DynamoDBAttribute
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	
	@DynamoDBAttribute
	public String getTaxonomy() {
		return taxonomy;
	}
	public void setTaxonomy(String taxonomy) {
		this.taxonomy = taxonomy;
	}
	
	@DynamoDBAttribute
	public String getDifficultylevel() {
		return difficultylevel;
	}
	public void setDifficultylevel(String difficultylevel) {
		this.difficultylevel = difficultylevel;
	}
	
	@DynamoDBAttribute
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	
	@DynamoDBAttribute
	public String getMultipleanswers() {
		return multipleanswers;
	}
	public void setMultipleanswers(String multipleanswers) {
		this.multipleanswers = multipleanswers;
	}
	
	@DynamoDBAttribute
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	@DynamoDBAttribute
	public String getQuestionsource() {
		return questionsource;
	}
	public void setQuestionsource(String questionsource) {
		this.questionsource = questionsource;
	}
	
	@DynamoDBAttribute
	public String getQuestiontext() {
		return questiontext;
	}
	public void setQuestiontext(String questiontext) {
		this.questiontext = questiontext;
	}
	
	@DynamoDBAttribute
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	
	
	@DynamoDBAttribute
	public String getOption1correct() {
		return option1correct;
	}
	public void setOption1correct(String option1correct) {
		this.option1correct = option1correct;
	}
	
	@DynamoDBAttribute
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	
	@DynamoDBAttribute
	public String getOption2correct() {
		return option2correct;
	}
	public void setOption2correct(String option2correct) {
		this.option2correct = option2correct;
	}
	
	@DynamoDBAttribute
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	
	@DynamoDBAttribute
	public String getOption3correct() {
		return option3correct;
	}
	public void setOption3correct(String option3correct) {
		this.option3correct = option3correct;
	}
	
	@DynamoDBAttribute
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	
	@DynamoDBAttribute
	public String getOption4correct() {
		return option4correct;
	}
	public void setOption4correct(String option4correct) {
		this.option4correct = option4correct;
	}
	
	@DynamoDBAttribute
	public String getOption5() {
		return option5;
	}
	public void setOption5(String option5) {
		this.option5 = option5;
	}
	
	@DynamoDBAttribute
	public String getOption5correct() {
		return option5correct;
	}
	public void setOption5correct(String option5correct) {
		this.option5correct = option5correct;
	}
	
	@DynamoDBAttribute
	public String getSubmitter() {
		return submitter;
	}
	public void setSubmitter(String submitter) {
		this.submitter = submitter;
	}
	
	
	@DynamoDBAttribute
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	@DynamoDBAttribute
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private String option4;
	  private String option4correct;
	  private String option5;
	  private String option5correct;

	 
	    private String submitter;
	    private String comments;
	    private String status;
	
}
