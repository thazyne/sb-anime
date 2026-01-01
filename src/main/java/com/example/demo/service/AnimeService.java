package com.example.demo.service;

import com.example.demo.dto.AnimeRequest;
import com.example.demo.model.Anime;

import java.util.List;

public interface AnimeService {

    List<Anime> getAllAnime();

    Anime getAnimeById(Long id);

    Anime createAnime(AnimeRequest request);

    Anime updateAnime(Long id, AnimeRequest request);

    void deleteAnime(Long id);

    List<Anime> searchByGenre(String genre);

    List<Anime> searchByJudul(String judul);
}
