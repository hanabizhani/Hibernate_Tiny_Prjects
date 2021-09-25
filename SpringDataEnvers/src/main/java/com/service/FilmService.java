package com.service;

import com.audit.dto.InputRequest;
import com.model.Film;
import com.repository.IFilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class FilmService {

    @Autowired
    IFilmRepository iFilmRepository;

    public Film findFilmByName(String title){
        Film  result = iFilmRepository.getFilmByName(title);
        return result;
    }

    public boolean deleteFilmByName(String title){
        try {
            iFilmRepository.delFilmByName(title);
            return true;
        }catch (Exception ex){
            System.out.println(ex);
            return false;
        }

    }

    public String saveFilm(InputRequest<Film> request){
        String currentUser = request.getLoggedInUser();
        request.setTimeZone(Calendar.getInstance().getTimeZone().getDisplayName());
        Film filmEntity = request.getEntity();
        filmEntity.setCreatedBy(currentUser);
        iFilmRepository.save(filmEntity);
        return "Film saved successfully...";
    }
}
