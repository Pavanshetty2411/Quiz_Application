package com.example.Quiz.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Quiz.Service.QuestionService;
import com.example.Quiz.model.Question;


@RestController
@RequestMapping("question")
public class QuestionController {
	@Autowired
    private QuestionService qs;
	
	@GetMapping("allquestions")
	public ResponseEntity<List<Question>> getallquestion(){
		return qs.getallq();
	}
	
	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>> bycat(@PathVariable String category){
		return qs.getbycat(category);
	}
	
	@PostMapping("add")
	public ResponseEntity<String> addq(@RequestBody Question q){
		return qs.addq(q);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteq(@PathVariable Integer id){
		return qs.deleteq(id);
	}
	@PutMapping("edit/{id}")
	public ResponseEntity<String> updateq(@PathVariable Integer id,@RequestBody Question nq){
		return qs.updateq(id,nq);
	}
	
}
