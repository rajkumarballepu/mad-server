package com.madcoder.madwatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.madcoder.madwatch.model.Show;

public interface ShowRepository extends JpaRepository<Show, Integer> {

}
