package br.ifsul.bdii.service.impl;

import br.ifsul.bdii.service.EnderecoService;

import java.util.List;

import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import br.ifsul.bdii.exception.ServiceRuleException;
import br.ifsul.bdii.domain.repository.EnderecoRepository;
import br.ifsul.bdii.domain.entity.Endereco;

@Service
@RequiredArgsConstructor
public class EnderecoServiceImpl implements EnderecoService{
    
    private final EnderecoRepository repository;

    @Override
    public Endereco findById(Long id) {
        return repository.findById(
            id
        ).orElseThrow(() -> new ServiceRuleException("Id de endereço não encontrado."));
    }

    @Override
    public List<Endereco> findByCep(String cep) {
        return repository.findByCep(cep);
    }

    @Override
    public List<Endereco> findByState(String state) {
        return repository.findByState(state);
    }

    @Override
    public List<Endereco> findByCity(String city) {
        return repository.findByCity(city);
    }

    @Override
    public List<Endereco> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Endereco save(Endereco endereco) {
        return repository.save(endereco);
    }

    @Override
    @Transactional
    public void update(Endereco endereco, Long id) {
        
        repository.findById(id)
            .map(e -> {
                endereco.setId(id);
                repository.save(endereco);
                return e;
            }).orElseThrow(
                () -> new ServiceRuleException("Id de endereço não encontrado."));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.findById(id)
            .map(e -> {
                repository.delete(e);
                return e;
            }).orElseThrow(
                () -> new ServiceRuleException("Id de endereço não encontrado."));
    }

}
