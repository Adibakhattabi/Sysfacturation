package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.entity.Client;
import com.example.demo.repository.ClientRepository;

import java.util.List;

@Service

public class ClientService {
	
	private final ClientRepository clientRepository;

	
	//Injection de dépendances 
	
	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
		
	}
	
	//1.AFFICHER TOUS LES CLIENTS
	
	public List<Client>getAllClients(){
		return clientRepository.findAll();
	}
	
	 // 2. Rechercher un client par ID
    public Client getClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("Client introuvable"));
    }
    //3.AJOUTE UN CLIENT 
    public Client ajouterClient(Client client) {
    	return clientRepository.save(client);
    }
    //4.MODIFIER UN CLIENT
    public Client modifierClient(Long id, Client nouveauClient) {
    	Client client = getClientById(id);
    	client.setNom(nouveauClient.getNom());
        client.setPrenom(nouveauClient.getPrenom());
        client.setEmail(nouveauClient.getEmail());
        client.setAdresse(nouveauClient.getAdresse());
        client.setTelephone(nouveauClient.getTelephone());
        client.setVille(nouveauClient.getVille());

        return clientRepository.save(client);
    }
    
    //5.SUPPRIMER UN CLIENT
    public void supprimerClient(Long id) {
    	Client client = getClientById(id);
    	clientRepository.delete(client);
    }
  }

	