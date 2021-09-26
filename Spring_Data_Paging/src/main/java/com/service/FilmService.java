package com.service;

import com.audit.dto.InputRequest;
import com.model.Film;
import com.repository.IFilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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

    public List<Film> getAllFilms(Integer pageNo, Integer pageSize, String sortBy){
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Film> pagedResult = iFilmRepository.getAllFilms(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Film>();
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
