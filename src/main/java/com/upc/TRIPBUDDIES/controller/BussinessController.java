package com.upc.TRIPBUDDIES.controller;

import com.upc.TRIPBUDDIES.entities.Bussiness;
import com.upc.TRIPBUDDIES.entities.Bussiness;
import com.upc.TRIPBUDDIES.service.IBussinessService;
import com.upc.TRIPBUDDIES.service.IBussinessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/bussiness")
@CrossOrigin(origins = "*")
@Api(tags = "Bussiness", value = "Web Service RESTFul of Bussiness")
public class BussinessController {
    private final IBussinessService bussinessService;

    public BussinessController(IBussinessService bussinessService) {
        this.bussinessService = bussinessService;
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "List all Bussiness", notes = "Method to list all Bussiness")
    @ApiResponses({
            @ApiResponse(code =  200, message = "All Bussinesss founds"),
            @ApiResponse(code =  404, message = "Bussinesss Not Found"),
            @ApiResponse(code =  501, message = "Internal Server Error")
    })
    public ResponseEntity<List<Bussiness>> findAllBussiness(){
        try {
            List<Bussiness> bussinesses = bussinessService.getAll();
            if(bussinesses.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(bussinesses, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Search Bussiness by Id", notes = "Method for find a Bussiness by id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Bussiness found by Id"),
            @ApiResponse(code = 404, message = "Bussiness Not Found"),
            @ApiResponse(code = 501, message = "Internal Server Error")
    })
    public ResponseEntity<Bussiness> findBussinessById(@PathVariable("id") Long id){
        try {
            Optional<Bussiness> developer = bussinessService.getById(id);
            return developer.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create Bussiness", notes = "Method for create a Bussiness")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Bussiness created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 501, message = "Internal Server Error")
    })
    public ResponseEntity<Bussiness> createBussiness(@Valid @RequestBody Bussiness developer){
        try {
            Bussiness developerCreate = bussinessService.save(developer);
            return new ResponseEntity<>(developerCreate, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update Bussiness", notes = "Method for update a Bussiness")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Bussiness updated"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 501, message = "Internal Server Error")
    })
    public ResponseEntity<Bussiness> updateBussiness(@PathVariable("id") Long id, @Valid @RequestBody Bussiness developer){
        try {
            if(id.equals(developer.getId())){
                Bussiness developerUpdate = bussinessService.save(developer);
                return new ResponseEntity<>(developerUpdate, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Delete Bussiness", notes = "Method for delete a Bussiness")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Bussiness deleted"),
            @ApiResponse(code = 404, message = "Bussiness Not Found"),
            @ApiResponse(code = 501, message = "Internal Server Error")
    })
    public ResponseEntity<Bussiness> deleteDeveloper(@PathVariable("id") Long id){
        try {
            Optional<Bussiness> developer = bussinessService.getById(id);
            if(developer.isPresent()){
                bussinessService.delete(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
