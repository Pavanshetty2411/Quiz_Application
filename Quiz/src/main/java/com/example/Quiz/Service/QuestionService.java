package com.example.Quiz.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.Quiz.dao.QuestionDao;
import com.example.Quiz.model.Question;

@Service
public class QuestionService {
	@Autowired
	private QuestionDao qd;
	
	public ResponseEntity<List<Question>> getallq(){
		try {
            return new ResponseEntity<>(qd.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Question>> getbycat(String category) {
		try {
            return new ResponseEntity<>(qd.findByCategory(category), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addq(Question q) {
		try {
			qd.save(q);
            return new ResponseEntity<>("Question Added Sucessfully", HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Question Adding Failed", HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> deleteq(Integer id) {
		try {
			qd.deleteById(id);
            return new ResponseEntity<>("Question Deleted Sucessfully", HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Question Deleting Failed", HttpStatus.BAD_REQUEST);
		
	}

	public ResponseEntity<String> updateq(Integer id, Question nq) {
		try {
			Optional<Question> q1=qd.findById(id);
			Question q2=q1.get();
			q2.setQ_title(nq.getQ_title());
			q2.setCategory(nq.getCategory());
			q2.setO1(nq.getO1());
			q2.setO2(nq.getO2());
			q2.setO3(nq.getO3());
			q2.setO4(nq.getO4());
			q2.setR_a(nq.getR_a());
			q2.setD_l(nq.getD_l());
			qd.save(q2);
            return new ResponseEntity<>("Question Updated Sucessfully", HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Question Updating Failed", HttpStatus.BAD_REQUEST);
	}
	
	
	
	

}
