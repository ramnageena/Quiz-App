package com.quiz.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.app.exception.ResourceNotFoundException;
import com.quiz.app.model.Question;
import com.quiz.app.model.QuestionWrapper;
import com.quiz.app.model.Quiz;
import com.quiz.app.model.ResultResponse;
import com.quiz.app.repository.QuestionRepo;
import com.quiz.app.repository.QuizReposistory;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuizReposistory quizReposistory;

	@Autowired
	private QuestionRepo questionRepo;

	@Override
	public String createQuiz(String category, int numQ, String title) {
		List<Question> questions = questionRepo.findRandomQuestionByCategory(category, numQ);
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizReposistory.save(quiz);
		return "Success";
	}

	@Override
	public List<QuestionWrapper> getQuizQuestion(Integer id) {
		Quiz quiz = quizReposistory.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Quiz", "Quiz Id", id));
		List<Question> questionsFromDB = quiz.getQuestions();
		List<QuestionWrapper> questionForUser = new ArrayList<QuestionWrapper>();
		for (Question q : questionsFromDB) {

			QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(),
					q.getOption3(), q.getOption4());
			questionForUser.add(qw);
		}

		return questionForUser;
	}

	@Override
	public Integer calculateResult(Integer id, List<ResultResponse> responses) {
		Quiz quiz = quizReposistory.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Quiz", "Quiz Id", id));
		List<Question> questions = quiz.getQuestions();
		int right = 0;
		int i = 0;

		for (ResultResponse response : responses) {
			if (response.getResponse().equals(questions.get(i).getRightAnswer()))
				right++;

			i++;
		}
		return right;
	}

}
