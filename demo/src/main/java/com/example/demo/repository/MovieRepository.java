package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.db.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
