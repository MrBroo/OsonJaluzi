package byfayzullayev.jaluzi.controller;

import byfayzullayev.jaluzi.model.receive.clients.ClientReceiveModel;
import byfayzullayev.jaluzi.service.clients.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/yourjaluzi/clients")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @CrossOrigin
    @PostMapping("/add")
    public HttpEntity<?> addClient(@RequestBody ClientReceiveModel clientReceiveModel){
        return ResponseEntity.ok(clientService.addClient(clientReceiveModel));

    }

    @CrossOrigin
    @GetMapping("list")
    public HttpEntity<?> getClientList(){
        return ResponseEntity.ok(clientService.getClientList());
    }
}
