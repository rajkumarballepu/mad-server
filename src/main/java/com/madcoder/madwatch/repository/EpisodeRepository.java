package com.madcoder.madwatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.madcoder.madwatch.model.Episode;

public interface EpisodeRepository extends JpaRepository<Episode, Integer> {

}
