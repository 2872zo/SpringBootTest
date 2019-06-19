package com.example.demo.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.db.entity.Movie;
import com.example.demo.repository.MovieRepository;

@RestController
public class MovieCollectController {
    @Autowired
    MovieRepository movieRepository;

    Logger logger = LoggerFactory.getLogger(MovieCollectController.class);

    @RequestMapping(value = "/movie", method = RequestMethod.GET)
    public Page<Movie> findMovies(Pageable pageable) throws Exception {
        Page<Movie> movie = movieRepository.findAll(pageable);
        return movie;
    }

    @RequestMapping(value = "/movie/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<Movie> findMovieById(@PathVariable(value = "id") int id) throws Exception {
        Optional<Movie> movie = movieRepository.findById(id);

        return movie;
    }

//    public static void main(String[] args) {
//        SpringApplication.run(MovieCollectController.class, args);
//    }
}
