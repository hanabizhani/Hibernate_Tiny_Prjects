package com.service;

import com.model.Actor;
import com.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorService {

    @Autowired
    ActorRepository actorRepository;

    public String findEmailById(long actorId){
        String result = actorRepository.getActorEmailById(actorId);
        return result;
    }

}
