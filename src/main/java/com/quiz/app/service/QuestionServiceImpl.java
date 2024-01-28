package com.quiz.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.app.exception.ResourceNotFoundException;
import com.quiz.app.model.Question;
import com.quiz.app.repository.QuestionRepo;

@Service
public  class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepo questionRepo;

	@Override
	public List<Question> getALlQuestion() {
		List<Question> allQuestions = questionRepo.findAll();
		return allQuestions;
	}

	@Override
	public Question getQuestionById(Integer qId) {
		Question question = questionRepo.findById(qId)
				.orElseThrow(() -> new ResourceNotFoundException("Question", "Question Id", qId));

		return question;
	}

	@Override
	public Question createQuestion(Question question) {
		Question save = questionRepo.save(question);
		return save;
	}

	@Override
	public Question updateQuestion(Question question, Integer qId) {
		Question existQuestion = getQuestionById(qId);
		existQuestion.setQuestionTitle(question.getQuestionTitle());
		existQuestion.setOption1(question.getOption1()!=null ? question.getOption1(): existQuestion.getOption1());
		existQuestion.setOption2(question.getOption2());
		existQuestion.setOption3(question.getOption3());
		existQuestion.setOption4(question.getOption4());
		existQuestion.setRightAnswer(question.getRightAnswer());
		existQuestion.setDifficultyLevel(question.getDifficultyLevel());
		existQuestion.setCategory(question.getCategory());

		Question update = questionRepo.save(existQuestion);
		return update;
	}

	@Override
	public void deleteById(Integer qId) {
		Question questionById = getQuestionById(qId);
		questionRepo.delete(questionById);

	}

	@Override
	public List<Question> getQuestionByCategory(String category) {
	List<Question> list = questionRepo.findByCategory(category);
		return list;
	}



	

}
