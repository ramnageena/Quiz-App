package com.quiz.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quiz.app.model.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {
	
	//custom finder method to find based on Category
	List<Question>findByCategory(String category);

	@Query(value = "Select * from question_table q where q.category=:category ORDER BY RAND() LIMIT :numQ",nativeQuery = true)
      List<Question> findRandonQuestionByCategory(String category, int numQ);

}
