package com.controller;

import com.audit.dto.InputRequest;
import com.model.Actor;
import com.model.Film;
import com.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping(value = "/actorEmailById/{actorId}")
    public ResponseEntity<String> getEmailById(@PathVariable(name = "actorId") long actorId) {
        String email = actorService.findEmailById(actorId);
        return new ResponseEntity<String> (email, HttpStatus.OK);
    }

    @PostMapping("/addActor")
    public ResponseEntity<String> saveActor(@RequestBody InputRequest<Actor> request){
        String result = actorService.saveActor(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
