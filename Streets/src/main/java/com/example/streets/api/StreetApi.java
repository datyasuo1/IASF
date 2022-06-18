package com.example.streets.api;

import com.example.streets.entity.Street;
import com.example.streets.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/streets")
public class StreetApi {
    @Autowired
    StreetService streetService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Street>> getList(){
        return ResponseEntity.ok(streetService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Street street){
        return ResponseEntity.ok(streetService.save(street));
    }

}
