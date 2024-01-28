package com.quiz.app.service;

import java.util.List;

import com.quiz.app.model.QuestionWrapper;
import com.quiz.app.model.ResultResponse;

public interface QuizService {

	String createQuiz(String category,int numQ, String title);
	
	List<QuestionWrapper>getQuizQuestion(Integer id);

	Integer calculateResult(Integer id, List<ResultResponse> response);
}
