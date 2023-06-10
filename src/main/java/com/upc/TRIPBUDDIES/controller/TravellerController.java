package com.upc.TRIPBUDDIES.controller;

import com.upc.TRIPBUDDIES.entities.Traveller;
import com.upc.TRIPBUDDIES.service.ITravellerService;
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
@RequestMapping("/api/v1/traveller")
@CrossOrigin(origins = "*")
@Api(tags = "Traveller", value = "Web Service RESTFul of travellers")
public class TravellerController {
    private final ITravellerService travellerService;

    public TravellerController(ITravellerService travellerService) {
        this.travellerService = travellerService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "List all travellers", notes = "Method to list all Traveller")
    @ApiResponses({
            @ApiResponse(code = 200, message = "All travellers founds"),
            @ApiResponse(code = 404, message = "Travellers Not Found"),
            @ApiResponse(code = 501, message = "Internal Server Error")
    })
    public ResponseEntity<List<Traveller>> findAllTraveller(){
        try {
            List<Traveller> travellers = travellerService.getAll();
            if(travellers.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(travellers, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Search Traveller by Id", notes = "Method for find a Traveller by id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Traveller found by Id"),
            @ApiResponse(code = 404, message = "Traveller Not Found"),
            @ApiResponse(code = 501, message = "Internal Server Error")
    })
    public ResponseEntity<Traveller> findTravellerById(@PathVariable("id") Long id){
        try {
            Optional<Traveller> developer = travellerService.getById(id);
            return developer.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create Traveller", notes = "Method for create a Traveller")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Traveller created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 501, message = "Internal Server Error")
    })
    public ResponseEntity<Traveller> createTraveller(@Valid @RequestBody Traveller developer){
        try {
            Traveller developerCreate = travellerService.save(developer);
            return new ResponseEntity<>(developerCreate, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update Traveller", notes = "Method for update a Traveller")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Traveller updated"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 501, message = "Internal Server Error")
    })
    public ResponseEntity<Traveller> updateTraveller(@PathVariable("id") Long id, @Valid @RequestBody Traveller developer){
        try {
            if(id.equals(developer.getId())){
                Traveller developerUpdate = travellerService.save(developer);
                return new ResponseEntity<>(developerUpdate, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Delete Traveller", notes = "Method for delete a Traveller")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Traveller deleted"),
            @ApiResponse(code = 404, message = "Traveller Not Found"),
            @ApiResponse(code = 501, message = "Internal Server Error")
    })
    public ResponseEntity<Traveller> deleteDeveloper(@PathVariable("id") Long id){
        try {
            Optional<Traveller> developer = travellerService.getById(id);
            if(developer.isPresent()){
                travellerService.delete(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
