package org.example.services;

import org.example.dto.ClienteDTO;
import org.example.entities.Cliente;
import org.example.entities.Contato;
import org.example.entities.Endereco;
import org.example.repositories.ClienteRepository;
import org.example.repositories.EnderecoRepository;
import org.example.services.exeptions.ResourceNotFoundException;
import org.example.services.exeptions.ValueBigForAtributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Cliente> findAll() {
        return repository.findAll();
    }
    public Cliente findById(Long id) {
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
    public Cliente insert(Cliente obj){
        try {
            obj.setCliId(null);
            obj = repository.save(obj);
            enderecoRepository.saveAll(obj.getEnderecos());
            return obj;
        } catch (DataIntegrityViolationException e){
            throw new ValueBigForAtributeException(e.getMessage());
        }
    }

    public Cliente update(Long id, ClienteDTO objDto) {
        try {
            Cliente entity = findById(id);

            // Atualiza os dados do Cliente
            entity.setCliNome(objDto.getCliNome());
            entity.setCliCpf(objDto.getCliCpf());
            entity.setDataNascimento(objDto.getDataNascimento());
            entity.setCliStatus(objDto.getCliStatus());
            entity.setEstadoCivil(objDto.getEndEstado());
            entity.setProfissao(objDto.getProfissao());

            // Atualiza o Endereço do Cliente
            Endereco endereco = entity.getEnderecos().get(0);

            //Assumindo que há apensa um Endereço por Cliente
            endereco.setEndRua(objDto.getEndRua());
            endereco.setEndNumero(objDto.getEndNumero());
            endereco.setEndCidade(objDto.getEndCidade());
            endereco.setEndBairro(objDto.getEndBairro());
            endereco.setEndCep(objDto.getEndCep());
            endereco.setEndEstado(objDto.getEndEstado());
            endereco.setEndPais(objDto.getEndPais());
            endereco.setEndComplemento(objDto.getEndComplemento());
            endereco.setEndTipoResidencia(objDto.getEndTipoResidencia());

            // Atualiza o Contato do Cliente
            Contato contato = entity.getContatos().get(0);

            //Assumindo que há apensa um Contato por Cliente
            contato.setConCelular(objDto.getConCelular());
            contato.setConTelefoneComercial(objDto.getConTelefoneComercial());
            contato.setConEmail(objDto.getConEmail());

            // Salva as Alterações
            repository.save(entity);

            return entity;
        } catch (DataIntegrityViolationException e){
            throw new ValueBigForAtributeException(e.getMessage());
        }
    }

    public void deleteCliente(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public Cliente fromDTO(ClienteDTO objDto) {
        Cliente clien = new Cliente(null, objDto.getCliNome(), objDto.getCliCpf(), objDto.getCliStatus(), objDto.getDataNascimento(), objDto.getEstadoCivil(), objDto.getProfissao());
        Endereco ender = new Endereco(null, clien, objDto.getEndRua(), objDto.getEndNumero(), objDto.getEndCidade(), objDto.getEndBairro(), objDto.getEndCep(), objDto.getEndEstado(), objDto.getEndPais(), objDto.getEndComplemento(), objDto.getEndTipoResidencia());
        Contato contat = new Contato(null, clien, objDto.getConCelular(), objDto.getConTelefoneComercial(), objDto.getConEmail());

        clien.getEnderecos().add(ender);
        clien.getContatos().add(contat);

        return clien;
    }
    public ClienteDTO toNewDTO(Cliente obj) {
        ClienteDTO dto = new ClienteDTO();

        // Mapeie os atributos comuns entre Cliente e ClienteNewDTO
        dto.setCliId(obj.getCliId());
        dto.setCliNome(obj.getCliNome());
        dto.setCliCpf(obj.getCliCpf());
        dto.setCliStatus(obj.getCliStatus());
        dto.setDataNascimento(obj.getDataNascimento());
        dto.setEstadoCivil(obj.getEstadoCivil());
        dto.setProfissao(obj.getProfissao());

        // Atributos específicos de Endereco
        Endereco endereco = obj.getEnderecos().get(0);
        dto.setEndRua(endereco.getEndRua());
        dto.setEndNumero(endereco.getEndNumero());
        dto.setEndCidade(endereco.getEndCidade());
        dto.setEndBairro(endereco.getEndBairro());
        dto.setEndCep(endereco.getEndCep());
        dto.setEndEstado(endereco.getEndEstado());
        dto.setEndPais(endereco.getEndPais());
        dto.setEndComplemento(endereco.getEndComplemento());
        dto.setEndTipoResidencia(endereco.getEndTipoResidencia());

        // Atributos específicos de Contato
        Contato contato = obj.getContatos().get(0);
        dto.setConCelular(contato.getConCelular());
        dto.setConTelefoneComercial(contato.getConTelefoneComercial());
        dto.setConEmail(contato.getConEmail());

        return dto;
    }
}