package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Cliente;
import com.example.demo.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    public ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente) {

        return clienteRepository.save(cliente);
    }
    
    public Cliente atualizar(Long id, Cliente clienteAtualizado) {
        Optional<Cliente> optionalCliente = clienteRepository.findById(id);
        
        if (optionalCliente.isPresent()) {
            Cliente cliente = optionalCliente.get();
            cliente.nome = clienteAtualizado.nome;
            cliente.email = clienteAtualizado.email;
            cliente.telefone = clienteAtualizado.telefone;
            
            return clienteRepository.save(cliente);
        }
		return clienteAtualizado;
    }


    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
}