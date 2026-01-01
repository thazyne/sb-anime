# CRUD Anime - Spring Boot REST API

Aplikasi REST API untuk mengelola data anime menggunakan Spring Boot dan MySQL.

## Fitur

- Create, Read, Update, Delete (CRUD) data anime
- Validasi input dengan Bean Validation
- Error handling dengan custom exceptions
- Search anime berdasarkan judul atau genre

## Teknologi

- Java 17
- Spring Boot 4.0.1
- Spring Data JPA
- MySQL Database
- Lombok
- Maven

## Struktur Project

```
src/main/java/com/example/demo/
├── DemoApplication.java
├── controller/
│   └── AnimeController.java
├── dto/
│   ├── AnimeRequest.java
│   └── AnimeResponse.java
├── exception/
│   ├── AnimeNotFoundException.java
│   ├── ErrorResponse.java
│   └── GlobalExceptionHandler.java
├── model/
│   └── Anime.java
├── repository/
│   └── AnimeRepository.java
└── service/
    ├── AnimeService.java
    └── AnimeServiceImpl.java
```

## Prasyarat

- Java 17 atau lebih tinggi
- MySQL Server
- Maven

## Instalasi

1. Clone repository

```bash
git clone https://github.com/username/anime-crud-springboot.git
cd anime-crud-springboot
```

2. Buat database MySQL

```sql
CREATE DATABASE anime_db;
```

3. Konfigurasi database di `src/main/resources/application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/anime_db
spring.datasource.username=root
spring.datasource.password=your_password
```

4. Jalankan aplikasi

```bash
./mvnw spring-boot:run
```

Aplikasi akan berjalan di `http://localhost:8080`

## API Endpoints

### Anime

| Method | Endpoint | Deskripsi |
|--------|----------|-----------|
| GET | /anime | Mendapatkan semua anime |
| GET | /anime/{id} | Mendapatkan anime berdasarkan ID |
| POST | /anime | Menambahkan anime baru |
| PUT | /anime/{id} | Mengupdate anime |
| DELETE | /anime/{id} | Menghapus anime |
| GET | /anime/search/genre?genre={genre} | Mencari anime berdasarkan genre |
| GET | /anime/search/judul?judul={judul} | Mencari anime berdasarkan judul |

## Contoh Request dan Response

### Create Anime

**Request:**
```
POST /anime
Content-Type: application/json

{
    "judul": "Naruto",
    "genre": "Action, Adventure"
}
```

**Response (201 Created):**
```json
{
    "success": true,
    "message": "Anime berhasil ditambahkan",
    "data": {
        "id": 1,
        "judul": "Naruto",
        "genre": "Action, Adventure"
    }
}
```

### Get All Anime

**Request:**
```
GET /anime
```

**Response (200 OK):**
```json
{
    "success": true,
    "message": "Data anime berhasil diambil",
    "total": 2,
    "data": [
        {
            "id": 1,
            "judul": "Naruto",
            "genre": "Action, Adventure"
        },
        {
            "id": 2,
            "judul": "One Piece",
            "genre": "Action, Comedy"
        }
    ]
}
```

### Get Anime by ID

**Request:**
```
GET /anime/1
```

**Response (200 OK):**
```json
{
    "success": true,
    "message": "Anime ditemukan",
    "data": {
        "id": 1,
        "judul": "Naruto",
        "genre": "Action, Adventure"
    }
}
```

### Update Anime

**Request:**
```
PUT /anime/1
Content-Type: application/json

{
    "judul": "Naruto Shippuden",
    "genre": "Action, Adventure, Drama"
}
```

**Response (200 OK):**
```json
{
    "success": true,
    "message": "Anime berhasil diupdate",
    "data": {
        "id": 1,
        "judul": "Naruto Shippuden",
        "genre": "Action, Adventure, Drama"
    }
}
```

### Delete Anime

**Request:**
```
DELETE /anime/1
```

**Response (200 OK):**
```json
{
    "success": true,
    "message": "Anime dengan ID 1 berhasil dihapus"
}
```

## Error Handling

### Validasi Error (400 Bad Request)

```json
{
    "timestamp": "2026-01-01T23:00:00",
    "status": 400,
    "error": "Validation Error",
    "message": "Input tidak valid. Silakan periksa kembali.",
    "path": "/anime",
    "validationErrors": {
        "judul": "Judul tidak boleh kosong",
        "genre": "Genre tidak boleh kosong"
    }
}
```

### Data Tidak Ditemukan (404 Not Found)

```json
{
    "timestamp": "2026-01-01T23:00:00",
    "status": 404,
    "error": "Not Found",
    "message": "Anime tidak ditemukan dengan ID: 999",
    "path": "/anime/999"
}
```

## Validasi Input

| Field | Aturan |
|-------|--------|
| judul | Wajib diisi, 1-255 karakter |
| genre | Wajib diisi, 1-255 karakter |

## Database Schema

```sql
CREATE TABLE anime (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    judul VARCHAR(255) NOT NULL,
    genre VARCHAR(255) NOT NULL
);
```


