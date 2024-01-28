package com.quiz.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.app.model.Quiz;

@Repository
public interface QuizReposistory  extends JpaRepository<Quiz, Integer>{

}
