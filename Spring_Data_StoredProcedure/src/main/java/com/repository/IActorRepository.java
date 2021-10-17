package com.repository;

import com.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActorRepository extends JpaRepository<Actor, Long> {

    @Query("SELECT ac.email FROM actor ac WHERE ac.id=:actorId")
    String getActorEmailById(@Param("actorId") long actorId);
}
