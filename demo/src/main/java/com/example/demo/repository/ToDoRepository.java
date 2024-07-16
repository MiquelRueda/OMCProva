package com.example.demo.repository;

import com.example.demo.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {

    List<ToDo> findByUserId(Long userId);

    List<ToDo> findByCompleted(boolean completed);
}
