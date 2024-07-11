package com.QuizApp.quiz_service.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.QuizApp.quiz_service.Model.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer> {

}
