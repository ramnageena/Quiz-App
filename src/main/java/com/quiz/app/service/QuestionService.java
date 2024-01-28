package com.quiz.app.service;

import java.util.List;

import com.quiz.app.model.Question;

public interface QuestionService {
    
	//Get all Question
	List<Question> getALlQuestion();
	
	//Get Question through particular ID
	Question getQuestionById(Integer qId);
	
	// Create a new Question
	Question createQuestion(Question question);
	
	//Update the existing Question
	Question updateQuestion(Question question, Integer qId);
	
	//delete Question by Id
	void deleteById(Integer qId);
	
	List<Question> getQuestionByCategory(String category);
}
