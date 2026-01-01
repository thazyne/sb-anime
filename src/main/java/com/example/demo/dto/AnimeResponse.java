package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimeResponse {

    private Long id;
    private String judul;
    private String genre;
    private String message;

    public AnimeResponse(Long id, String judul, String genre) {
        this.id = id;
        this.judul = judul;
        this.genre = genre;
    }

    public static AnimeResponse success(Long id, String judul, String genre, String message) {
        return new AnimeResponse(id, judul, genre, message);
    }
}
