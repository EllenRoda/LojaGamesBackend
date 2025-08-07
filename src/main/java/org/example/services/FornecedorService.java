package org.example.services;

import org.example.dto.FornecedorDTO;
import org.example.entities.Contato;
import org.example.entities.Endereco;
import org.example.entities.Fornecedor;
import org.example.repositories.EnderecoRepository;
import org.example.repositories.FornecedorRepository;
import org.example.services.exeptions.ResourceNotFoundException;
import org.example.services.exeptions.ValueBigForAtributeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository repository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Fornecedor> findAll(){
        return repository.findAll();
    }

    public Fornecedor findById(Long id){
        Optional<Fornecedor> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Fornecedor insert(Fornecedor obj){
        try {
            obj.setForId(null);
            obj = repository.save(obj);
            enderecoRepository.saveAll(obj.getEnderecos());
            return obj;
        } catch (DataIntegrityViolationException e){
            throw new ValueBigForAtributeException(e.getMessage());
        }
    }
    public Fornecedor update(Long id, FornecedorDTO objDto){
        try {
            Fornecedor entity = findById(id);

            // Atualiza os dados do Fornecedor
            entity.setForNomeFantasia(objDto.getForNomeFantasia());
            entity.setForRazaoSocial(objDto.getForRazaoSocial());
            entity.setForTelefone(objDto.getForTelefone());
            entity.setForCpf(objDto.getForCpf());
            entity.setForStatus(objDto.getForStatus());
            entity.setForResponsavel(objDto.getForResponsavel());

            // Atualiza o Endereço do Fornecedor
            Endereco endereco = entity.getEnderecos().get(0);

            //Assumindo que há apensa um Endereço por Fornecedor
            endereco.setEndRua(objDto.getEndRua());
            endereco.setEndNumero(objDto.getEndNumero());
            endereco.setEndCidade(objDto.getEndCidade());
            endereco.setEndBairro(objDto.getEndBairro());
            endereco.setEndCep(objDto.getEndCep());
            endereco.setEndEstado(objDto.getEndEstado());

            // Atualiza o Contato do Fornecedor
            Contato contato = entity.getContatos().get(0);

            //Assumindo que há apensa um Contato por Fornecedor
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

    public void deleteFornecedor(Long id){
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public Fornecedor fromDTO(FornecedorDTO objDto){
        Fornecedor forne = new Fornecedor(null, objDto.getForNomeFantasia(), objDto.getForRazaoSocial(), objDto.getForTelefone(), objDto.getForCpf(), objDto.getForStatus(), objDto.getForDataCadastro(), objDto.getForResponsavel());
        Endereco ender = new Endereco(null, forne, objDto.getEndRua(), objDto.getEndNumero(), objDto.getEndCidade(), objDto.getEndBairro(), objDto.getEndCep(), objDto.getEndEstado());
        Contato contat = new Contato(null, forne, objDto.getConCelular(), objDto.getConTelefoneComercial(), objDto.getConEmail());

        forne.getEnderecos().add(ender);
        forne.getContatos().add(contat);

        return forne;
    }

    public FornecedorDTO toNewDTO(Fornecedor obj){
        FornecedorDTO dto = new FornecedorDTO();

        // Mapeie os atributos comuns entre Fornecedor e FornecedorNewDTO
        dto.setForId(obj.getForId());
        dto.setForNomeFantasia(obj.getForNomeFantasia());
        dto.setForRazaoSocial(obj.getForRazaoSocial());
        dto.setForTelefone(obj.getForTelefone());
        dto.setForCpf(obj.getForCpf());
        dto.setForStatus(obj.getForStatus());
        dto.setForDataCadastro(obj.getForDataCadastro());
        dto.setForResponsavel(obj.getForResponsavel());

        // Atributos específicos de Fornecedor
        Endereco endereco = obj.getEnderecos().get(0);
        dto.setEndRua(endereco.getEndRua());
        dto.setEndNumero(endereco.getEndNumero());
        dto.setEndCidade(endereco.getEndCidade());
        dto.setEndBairro(endereco.getEndBairro());
        dto.setEndCep(endereco.getEndCep());
        dto.setEndEstado(endereco.getEndEstado());

        // Atributos específicos de Fornecedor
        Contato contato = obj.getContatos().get(0);
        dto.setConCelular(contato.getConCelular());
        dto.setConTelefoneComercial(contato.getConTelefoneComercial());
        dto.setConEmail(contato.getConEmail());

        return dto;
    }
}
