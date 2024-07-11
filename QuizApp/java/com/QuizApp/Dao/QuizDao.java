package com.QuizApp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.QuizApp.Model.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer> {

}
