package com.repository;

import com.model.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;


@Repository
public interface IFilmRepository extends JpaRepository<Film, Long> {

    /*@Procedure
    int getFilmsAfterReleaseDate(int releaseDate);*/
    //(value = "film.getCountFilmsAfterReleaseDate", procedureName = "getCountFilmsAfterReleaseDate")
    @Procedure
    Integer getCountFilmsAfterReleaseDate(int pInParam);

    /*@Query(nativeQuery = true,value = "call getFilmsAfterReleaseDate(:releaseDate)")
    int getFilmsAfterReleaseDate(@Param("releaseDate") int releaseDate);*/


    @Query("SELECT fl FROM film fl WHERE fl.title=:title")
    Film getFilmByName(@Param("title") String title);

    @Transactional
    @Modifying
    @Query("DELETE FROM film where title=:title")
    void delFilmByName(@Param("title") String title);

    @Query("SELECT fl FROM film fl")
    Page<Film> getAllFilms(Pageable paging);

}

