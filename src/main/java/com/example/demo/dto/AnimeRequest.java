package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimeRequest {

    @NotBlank(message = "Judul tidak boleh kosong")
    @Size(min = 1, max = 255, message = "Judul harus antara 1-255 karakter")
    private String judul;

    @NotBlank(message = "Genre tidak boleh kosong")
    @Size(min = 1, max = 255, message = "Genre harus antara 1-255 karakter")
    private String genre;
}
