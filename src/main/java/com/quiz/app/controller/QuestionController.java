package com.quiz.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.app.exception.ApiResponse;
import com.quiz.app.model.Question;
import com.quiz.app.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@GetMapping()
	public ResponseEntity<List<Question>> getALlQuestion(){
		List<Question> allQuestion = questionService.getALlQuestion();		
		return new ResponseEntity<List<Question>>(allQuestion,HttpStatus.OK);
		
	}

	@GetMapping("/{id}")
	public ResponseEntity<Question> getQuestionById(@PathVariable Integer id){
		Question question = questionService.getQuestionById(id);
		return new ResponseEntity<Question>(question,HttpStatus.FOUND);
		
	}
	
	@PostMapping()
	public ResponseEntity<Question> newQuestion(@RequestBody Question question){
		Question que = questionService.createQuestion(question);
		return new ResponseEntity<Question>(que,HttpStatus.CREATED);
		
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Question> updateQuestion(@RequestBody Question question ,@PathVariable Integer id){
		Question updateQuestion = questionService.updateQuestion(question, id);
		return new ResponseEntity<Question>(updateQuestion,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteById(@PathVariable Integer id){
		          questionService.deleteById(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Question Deleted Successfully"),HttpStatus.OK);
		
	}
	
	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
	 List<Question> questionByCategory = questionService.getQuestionByCategory(category);
		return new ResponseEntity<List<Question>>(questionByCategory,HttpStatus.FOUND);
		
	}
	
	
}
