package com.example.Quiz.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Quiz.Service.QuizService;
import com.example.Quiz.model.QuestiontoUser;
import com.example.Quiz.model.Quiz;
import com.example.Quiz.model.Response;

@RestController
@RequestMapping("quiz")
public class QuizContoller {
	@Autowired
	private QuizService qs;
	
	@PostMapping("create")
	public ResponseEntity<String> createq(@RequestParam String cat,@RequestParam int numq,@RequestParam String title){
		return qs.createq(cat,numq,title);
	}
	
	@GetMapping("getallquiz")
	public ResponseEntity<List<Quiz>> getallq(){
		return qs.findallq();
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<List<QuestiontoUser>> getbyid(@PathVariable Integer id){
		return qs.getQuizQuestions(id);
	}
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submit(@PathVariable Integer id,@RequestBody List<Response> response){
		return qs.calculate(id,response);
	}
	


}
