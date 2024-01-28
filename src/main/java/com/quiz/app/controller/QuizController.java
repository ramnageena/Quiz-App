package com.quiz.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.app.model.QuestionWrapper;
import com.quiz.app.model.ResultResponse;
import com.quiz.app.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	private QuizService quizService;
	
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestParam String category ,@RequestParam Integer numQ, @RequestParam String title){
		String createQuiz = quizService.createQuiz(category, numQ, title);
		return new ResponseEntity<String>(createQuiz,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<QuestionWrapper>>getQuizQuestion(@PathVariable Integer id){
		List<QuestionWrapper> quizQuestion = quizService.getQuizQuestion(id);
		return new ResponseEntity<List<QuestionWrapper>>(quizQuestion,HttpStatus.FOUND);
	}
	
	@PostMapping("submit/{id}")
	public ResponseEntity< Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<ResultResponse> responses){
		Integer calculateResult = quizService.calculateResult(id,responses);
		return new ResponseEntity<Integer>(calculateResult,HttpStatus.OK);
	}

}
