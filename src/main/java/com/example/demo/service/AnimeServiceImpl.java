package com.example.demo.service;

import com.example.demo.dto.AnimeRequest;
import com.example.demo.exception.AnimeNotFoundException;
import com.example.demo.model.Anime;
import com.example.demo.repository.AnimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeServiceImpl implements AnimeService {

    private final AnimeRepository animeRepository;

    @Override
    public List<Anime> getAllAnime() {
        return animeRepository.findAll();
    }

    @Override
    public Anime getAnimeById(Long id) {
        return animeRepository.findById(id)
                .orElseThrow(() -> new AnimeNotFoundException(id));
    }

    @Override
    public Anime createAnime(AnimeRequest request) {
        // Validasi tambahan jika diperlukan
        validateAnimeRequest(request);

        Anime anime = new Anime();
        anime.setJudul(request.getJudul().trim());
        anime.setGenre(request.getGenre().trim());

        return animeRepository.save(anime);
    }

    @Override
    public Anime updateAnime(Long id, AnimeRequest request) {
        // Validasi tambahan
        validateAnimeRequest(request);

        Anime existingAnime = animeRepository.findById(id)
                .orElseThrow(() -> new AnimeNotFoundException(id));

        existingAnime.setJudul(request.getJudul().trim());
        existingAnime.setGenre(request.getGenre().trim());

        return animeRepository.save(existingAnime);
    }

    @Override
    public void deleteAnime(Long id) {
        if (!animeRepository.existsById(id)) {
            throw new AnimeNotFoundException(id);
        }
        animeRepository.deleteById(id);
    }

    @Override
    public List<Anime> searchByGenre(String genre) {
        if (genre == null || genre.trim().isEmpty()) {
            throw new IllegalArgumentException("Parameter genre tidak boleh kosong");
        }
        return animeRepository.findByGenreContainingIgnoreCase(genre.trim());
    }

    @Override
    public List<Anime> searchByJudul(String judul) {
        if (judul == null || judul.trim().isEmpty()) {
            throw new IllegalArgumentException("Parameter judul tidak boleh kosong");
        }
        return animeRepository.findByJudulContainingIgnoreCase(judul.trim());
    }

    // Private helper method untuk validasi tambahan
    private void validateAnimeRequest(AnimeRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Request body tidak boleh kosong");
        }

        // Validasi judul tidak hanya spasi
        if (request.getJudul() != null && request.getJudul().trim().isEmpty()) {
            throw new IllegalArgumentException("Judul tidak boleh hanya berisi spasi");
        }

        // Validasi genre tidak hanya spasi
        if (request.getGenre() != null && request.getGenre().trim().isEmpty()) {
            throw new IllegalArgumentException("Genre tidak boleh hanya berisi spasi");
        }
    }
}
