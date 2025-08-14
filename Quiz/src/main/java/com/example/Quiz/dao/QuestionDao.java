package com.example.Quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Quiz.model.Question;

public interface QuestionDao extends JpaRepository<Question, Integer> {

	List<Question> findByCategory(String category);
	@Query(
		    value = "SELECT * FROM question q WHERE q.category = :cat ORDER BY RANDOM() LIMIT :numQ",
		    nativeQuery = true
		)
		List<Question> findRandomQuestionsByCat(@Param("cat") String cat, @Param("numQ") int numQ);

	
}
