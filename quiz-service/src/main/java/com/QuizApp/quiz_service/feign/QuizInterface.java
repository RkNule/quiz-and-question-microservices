package com.QuizApp.quiz_service.feign;

import java.util.List;

//import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.QuizApp.quiz_service.Model.QuestionWrapper;
import com.QuizApp.quiz_service.Model.Response;



@FeignClient("QUESTION-SERVICE")

public interface  QuizInterface {

	@GetMapping("question/generate")
	 ResponseEntity<List<Integer>> getQuestionsForQuiz 
	(@RequestParam String categoryName, @RequestParam Integer numQuestions );
	
	@PostMapping("question/getQuestions")
	ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds);
	
	@PostMapping("question/getScore")
	ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
	
	
}