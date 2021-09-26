package com.controller;

import com.audit.dto.InputRequest;
import com.model.Film;
import com.service.FilmService;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping(value = "/getFilmByName/{title}")
    public ResponseEntity<Film> getEmailById(@PathVariable(name = "title") String title) {
        Film film = filmService.findFilmByName(title);
        return new ResponseEntity<> (film, HttpStatus.OK);
    }

    @GetMapping(value = "/delFilmByName/{title}")
    public ResponseEntity<Boolean> deleteFilmByName(@PathVariable(name = "title") String title) {
        boolean result = filmService.deleteFilmByName(title);
        return new ResponseEntity<> (result, HttpStatus.OK);
    }

    @PostMapping("/addFilm")
    public ResponseEntity<String> saveFilm(@RequestBody InputRequest<Film> request){
        String result = filmService.saveFilm(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/getAllFilms")
    public ResponseEntity<List<Film>> getAllFilms(@RequestParam(defaultValue = "0") Integer pageNo,
                                                 @RequestParam(defaultValue = "10") Integer pageSize,
                                                 @RequestParam(defaultValue = "title") String sortBy){

        List<Film> list = filmService.getAllFilms(pageNo, pageSize, sortBy);
        return new ResponseEntity<List<Film>>(list, new HttpHeaders(), HttpStatus.OK);
    }


}
