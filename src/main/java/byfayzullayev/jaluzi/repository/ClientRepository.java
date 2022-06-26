package byfayzullayev.jaluzi.repository;

import byfayzullayev.jaluzi.entity.clients.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
}
