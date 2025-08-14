package com.example.Quiz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Quiz.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer> {

}
