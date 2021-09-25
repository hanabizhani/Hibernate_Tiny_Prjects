package com.service;

import com.audit.dto.InputRequest;
import com.model.Actor;
import com.model.Film;
import com.repository.IActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class ActorService {

    @Autowired
    IActorRepository iActorRepository;

    public String findEmailById(long actorId){
        String result = iActorRepository.getActorEmailById(actorId);
        return result;
    }

    public String saveActor(InputRequest<Actor> request){
        String currentUser = request.getLoggedInUser();
        request.setTimeZone(Calendar.getInstance().getTimeZone().getDisplayName());
        Actor actorEntity = request.getEntity();
        actorEntity.setCreatedBy(currentUser);
        iActorRepository.save(actorEntity);
        return "Actor saved successfully...";
    }

}
