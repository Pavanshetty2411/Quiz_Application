package com.example.Quiz.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Quiz.dao.QuestionDao;
import com.example.Quiz.dao.QuizDao;
import com.example.Quiz.model.Question;
import com.example.Quiz.model.QuestiontoUser;
import com.example.Quiz.model.Quiz;
import com.example.Quiz.model.Response;
@Service
public class QuizService {
	
	@Autowired
	private QuizDao qd;
	@Autowired
	private QuestionDao qud;

	public ResponseEntity<List<Quiz>> findallq() {
		try {
			return new ResponseEntity<>(qd.findAll(),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
		
	}

	public ResponseEntity<String> createq(String cat, int numq, String title) {
		try {
			List<Question> q=qud.findRandomQuestionsByCat(cat,numq);
			Quiz q1=new Quiz();
			q1.setTitle(title);
			q1.setquestions(q);
			qd.save(q1);
			return new ResponseEntity<>("Quiz Created",HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Quiz Not Created", HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<QuestiontoUser>> getQuizQuestions(Integer id) {
		try {
			Optional<Quiz> q=qd.findById(id);
			List<Question> qdb=q.get().getquestions();
			List<QuestiontoUser> qforuser=new ArrayList<>();
			for(Question q1:qdb) {
				QuestiontoUser qw=new QuestiontoUser(q1.getId(),q1.getQ_title(),q1.getO1(),q1.getO2(),q1.getO3(),q1.getO4());
				qforuser.add(qw);
			}
			return new ResponseEntity<>(qforuser,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<Integer> calculate(Integer id, List<Response> responses) {
		try {
			Quiz q=qd.findById(id).get();
			List<Question> qs=q.getquestions();
			int ra=0;
			int i=0;
			for(Response response:responses) {
				if(response.getResponse().equals(qs.get(i).getR_a())) {
					ra+=1;
				}
				i++;
			}
			return new ResponseEntity<>(ra, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		
	}

	

}
