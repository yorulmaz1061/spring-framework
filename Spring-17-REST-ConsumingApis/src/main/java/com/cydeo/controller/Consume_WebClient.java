package com.cydeo.controller;

import com.cydeo.entity.Genre;
import com.cydeo.entity.MovieCinema;
import com.cydeo.repository.GenreRepository;
import com.cydeo.repository.MovieCinemaRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class Consume_WebClient {

    private WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080").build();
    private final MovieCinemaRepository movieCinemaRepository;
    private final GenreRepository genreRepository;

    public Consume_WebClient(MovieCinemaRepository movieCinemaRepository, GenreRepository genreRepository) {
        this.movieCinemaRepository = movieCinemaRepository;
        this.genreRepository = genreRepository;
    }
    @GetMapping("/flux-movie-cinemas")
    public Flux<MovieCinema> readAllcinemaFlux(){
        return Flux.fromIterable(movieCinemaRepository.findAll());
    }
   // if you return id then it will be mono
    @GetMapping("/mono-movie-cinema/{id}")
    public Mono<MovieCinema> readById(@PathVariable("id")Long id){
        return Mono.just(movieCinemaRepository.findById(id).get());
    }
    @GetMapping("/mono-movie-cinema/{id}")
    public ResponseEntity<Mono<MovieCinema>> readByIdI(@PathVariable("id") Long id){
        return ResponseEntity.ok(Mono.just(movieCinemaRepository.findById(id).get()));
    }
    @PostMapping("/create-genre")
    public Mono<Genre> createGenre(@RequestBody Genre genre){
        /*Genre createdGenre = genreRepository.save(genre);
        return Mono.just(createdGenre);*/
        return Mono.just(genreRepository.save(genre));
    }
    @DeleteMapping("/delete/genre/{id}")
    public Mono<Void> deleteGenre(@PathVariable("id") Long id){
        genreRepository.deleteById(id);
        // If you are not returning, you just put empty
       return Mono.empty();
    }
    //------------------------------WEBCLIENT-------------------------------

    @GetMapping("/flux") //This means wtih localhost:8080,  I am gonna consume
    //Why flux, because ı will breing more than one object
    public Flux<MovieCinema> readWithWebClient(){
    return webClient
            .get()
            //which endpoint? or you can write whole uri
            .uri("/flux-movie-cinemas")
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .retrieve()
            .bodyToFlux(MovieCinema.class);
    }
    //I want to receive one movie
    @GetMapping("/mono/{id}")
    public Mono<MovieCinema> readMonoWithWebClient(@PathVariable("id") Long id){
        return webClient
                .get()
                .uri("/mono-movie-cinema/{id}",id)
                .retrieve()
                .bodyToMono(MovieCinema.class);

    }




}
