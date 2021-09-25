package com.repository;

import com.model.Actor;
import com.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IFilmRepository extends JpaRepository<Film, Long> {

    @Query("SELECT fl FROM film fl WHERE fl.title=:title")
    Film getFilmByName(@Param("title") String title);

    @Transactional
    @Modifying
    @Query("DELETE FROM film where title=:title")
    void delFilmByName(@Param("title") String title);


}

