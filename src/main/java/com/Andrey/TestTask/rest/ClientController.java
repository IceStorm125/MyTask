package com.Andrey.TestTask.rest;

import com.Andrey.TestTask.model.Client;
import com.Andrey.TestTask.model.Discount;
import com.Andrey.TestTask.service.ClientService;
import com.Andrey.TestTask.service.DiscountService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/client",produces = "application/json")
@Api(value = "Client controller",produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {

    private final ClientService clientService;
    private final DiscountService discountService;

    @Autowired
    public ClientController(ClientService clientService, DiscountService discountService) {
        this.clientService = clientService;
        this.discountService = discountService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Client>> getClients(){
        return new ResponseEntity<>(clientService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Client> getClient(@PathVariable("id")Long clientId){
        Client client = clientService.getById(clientId);

        if (client == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(clientService.getById(clientId),HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Client> saveClient(@RequestBody Client client){
        if (client == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        clientService.save(client);
        return new ResponseEntity<>(client,HttpStatus.OK);
    }

    @GetMapping("/discount/{id}")
    public ResponseEntity<Discount> getClientDiscount(@PathVariable("id")Long clientId){
        Discount discount = discountService.getById(clientId);
        if (discount==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(discount,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable("id") Long clientId){
        Client client = clientService.getById(clientId);

        if (client == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        clientService.delete(clientId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Client> updateClient(@RequestBody Client client){
        if (client == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        clientService.save(client);
        return new ResponseEntity<>(client,HttpStatus.OK);
    }
}
