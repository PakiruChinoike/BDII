package br.ifsul.bdii.service.impl;

import br.ifsul.bdii.service.FuncionarioService;

import java.util.List;

import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import br.ifsul.bdii.exception.ServiceRuleException;
import br.ifsul.bdii.domain.repository.FuncionarioRepository;
import br.ifsul.bdii.domain.entity.Funcionario;

@Service
@RequiredArgsConstructor
public class FuncionarioServiceImpl implements FuncionarioService{
    
    private final FuncionarioRepository repository;

    @Override
    public Funcionario findById(Long id) {
        return repository.findById(
            id
        ).orElseThrow(() -> new ServiceRuleException("Id de funcionário não encontrado."));
    }

    @Override
    public List<Funcionario> findByNameLike(String name) {
        return repository.findByNameLike(name);
    }

    @Override
    public List<Funcionario> findByPhone(String telefone) {
        return repository.findByPhone(telefone);
    }

    @Override
    public List<Funcionario> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public List<Funcionario> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Funcionario save(Funcionario Funcionario) {
        return repository.save(Funcionario);
    }

    @Override
    @Transactional
    public void update(Funcionario funcionario, Long id) {
        
        repository.findById(id)
            .map(f -> {
                funcionario.setId(id);
                repository.save(funcionario);
                return f;
            }).orElseThrow(
                () -> new ServiceRuleException("Id de funcionário não encontrado."));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.findById(id)
            .map(f -> {
                repository.delete(f);
                return f;
            }).orElseThrow(
                () -> new ServiceRuleException("Id de funcionário não encontrado."));
    }

}
