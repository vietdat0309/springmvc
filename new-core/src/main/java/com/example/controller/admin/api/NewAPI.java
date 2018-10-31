package com.example.controller.admin.api;

import com.example.dto.NewDTO;
import com.example.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/admin/new")
public class NewAPI {

    @Autowired
    private INewService newService;

    /*old syntax*/
    /*@RequestMapping(value = "/api/admin/new", method = RequestMethod.POST)
    public ResponseEntity<NewDTO> createNew(@RequestBody NewDTO newDTO){
        return ResponseEntity.ok(newService.save(newDTO));
    }*/

    /*new syntax*/
    @PostMapping
    public ResponseEntity<NewDTO> createNew(@RequestBody NewDTO newDTO){
        return ResponseEntity.ok(newService.save(newDTO));
    }

    @PutMapping
    public ResponseEntity<NewDTO> updateNew(@RequestBody NewDTO newDTO){
        return ResponseEntity.ok(newService.update(newDTO));
    }

}
