package byfayzullayev.jaluzi.service.clients;

import byfayzullayev.jaluzi.entity.clients.ClientEntity;
import byfayzullayev.jaluzi.model.receive.clients.ClientReceiveModel;
import byfayzullayev.jaluzi.model.response.ApiResponse;
import byfayzullayev.jaluzi.repository.ClientRepository;
import byfayzullayev.jaluzi.service.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements BaseService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public ApiResponse addClient(ClientReceiveModel clientReceiveModel) {

        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setName(clientReceiveModel.getName());
        clientEntity.setPhoneNumber(clientReceiveModel.getPhoneNumber());
        clientEntity.setVariant(clientReceiveModel.getVariant());
        clientRepository.save(clientEntity);

        return SUCCESS_V2;
    }

    public ApiResponse getClientList() {
        SUCCESS.setData(clientRepository.findAll());
        return SUCCESS;
    }
}