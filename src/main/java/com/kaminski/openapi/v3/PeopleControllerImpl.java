package com.kaminski.openapi.v3;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.swagger.api.PeopleApi;
import org.swagger.model.PeopleRequest;
import org.swagger.model.PeopleResponse;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PeopleControllerImpl implements PeopleApi {

    private List<PeopleResponse> peopleResponses = new ArrayList<>();

    @Override
    public ResponseEntity<List<PeopleResponse>> getPeople() {
        return ResponseEntity.ok(peopleResponses);
    }

    @Override
    public ResponseEntity<PeopleResponse> postPeople(PeopleRequest peopleRequest) {
        return ResponseEntity.ok(createPeople(peopleRequest));
    }

    private PeopleResponse createPeople(PeopleRequest peopleRequest){
        var people = new PeopleResponse();
        people.setName(peopleRequest.getName());
        people.setAge(peopleRequest.getAge());
        peopleResponses.add(people);
        return people;
    }

}