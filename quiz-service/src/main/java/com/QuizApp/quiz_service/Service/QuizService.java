package com.QuizApp.quiz_service.Service;

import java.util.ArrayList;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.QuizApp.quiz_service.Dao.QuizDao;
import com.QuizApp.quiz_service.Model.QuestionWrapper;
import com.QuizApp.quiz_service.Model.Quiz;
import com.QuizApp.quiz_service.Model.Response;
import com.QuizApp.quiz_service.feign.QuizInterface;

@Service
//@EnableFeignClients
public class QuizService {

//	@Autowired
	//QuestionDao questionDao;
	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuizInterface quizInterface;
	

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		
	List<Integer> questions = quizInterface.getQuestionsForQuiz(category, numQ).getBody();
	Quiz quiz = new Quiz();
	quiz.setTitle(title);
	quiz.setQuestionIds(questions);
	quizDao.save(quiz);
		
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
	Quiz quiz = quizDao.findById(id).get();
	List<Integer> questionIds = quiz.getQuestionIds();
	
	ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionsFromId(questionIds);
	return questions;
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		
		ResponseEntity<Integer> score = quizInterface.getScore(responses);
		
		return score;
	}
	
}
