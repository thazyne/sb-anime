package com.example.demo.controller;

import com.example.demo.dto.AnimeRequest;
import com.example.demo.model.Anime;
import com.example.demo.service.AnimeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/anime")
@RequiredArgsConstructor
public class AnimeController {

    private final AnimeService animeService;

    // GET all anime
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllAnime() {
        List<Anime> animeList = animeService.getAllAnime();

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Data anime berhasil diambil");
        response.put("total", animeList.size());
        response.put("data", animeList);

        return ResponseEntity.ok(response);
    }

    // GET anime by ID
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getAnimeById(@PathVariable Long id) {
        Anime anime = animeService.getAnimeById(id);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Anime ditemukan");
        response.put("data", anime);

        return ResponseEntity.ok(response);
    }

    // POST create new anime with validation
    @PostMapping
    public ResponseEntity<Map<String, Object>> createAnime(@Valid @RequestBody AnimeRequest request) {
        Anime createdAnime = animeService.createAnime(request);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Anime berhasil ditambahkan");
        response.put("data", createdAnime);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // PUT update anime with validation
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateAnime(
            @PathVariable Long id,
            @Valid @RequestBody AnimeRequest request) {

        Anime updatedAnime = animeService.updateAnime(id, request);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Anime berhasil diupdate");
        response.put("data", updatedAnime);

        return ResponseEntity.ok(response);
    }

    // DELETE anime
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteAnime(@PathVariable Long id) {
        animeService.deleteAnime(id);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Anime dengan ID " + id + " berhasil dihapus");

        return ResponseEntity.ok(response);
    }

    // GET search by genre
    @GetMapping("/search/genre")
    public ResponseEntity<Map<String, Object>> searchByGenre(@RequestParam String genre) {
        List<Anime> animeList = animeService.searchByGenre(genre);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Hasil pencarian genre: " + genre);
        response.put("total", animeList.size());
        response.put("data", animeList);

        return ResponseEntity.ok(response);
    }

    // GET search by judul
    @GetMapping("/search/judul")
    public ResponseEntity<Map<String, Object>> searchByJudul(@RequestParam String judul) {
        List<Anime> animeList = animeService.searchByJudul(judul);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Hasil pencarian judul: " + judul);
        response.put("total", animeList.size());
        response.put("data", animeList);

        return ResponseEntity.ok(response);
    }
}
