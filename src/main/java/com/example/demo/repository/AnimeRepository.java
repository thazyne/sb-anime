package com.example.demo.repository;

import com.example.demo.model.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long> {

    // Custom query method untuk mencari anime berdasarkan genre
    List<Anime> findByGenreContainingIgnoreCase(String genre);

    // Custom query method untuk mencari anime berdasarkan judul
    List<Anime> findByJudulContainingIgnoreCase(String judul);
}
