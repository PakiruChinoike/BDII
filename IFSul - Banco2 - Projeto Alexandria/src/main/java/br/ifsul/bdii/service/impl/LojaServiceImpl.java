package br.ifsul.bdii.service.impl;

import br.ifsul.bdii.service.LojaService;

import java.util.List;

import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import br.ifsul.bdii.exception.ServiceRuleException;
import br.ifsul.bdii.domain.repository.LojaRepository;
import br.ifsul.bdii.domain.entity.Loja;

@Service
@RequiredArgsConstructor
public class LojaServiceImpl implements LojaService{
    
    private final LojaRepository repository;

    @Override
    public Loja findById(Long id) {
        return repository.findById(
            id
        ).orElseThrow(() -> new ServiceRuleException("Id de loja não encontrado."));
    }

    @Override
    public List<Loja> findByNameLike(String name) {
        return repository.findByNameLike(name);
    }

    @Override
    public List<Loja> findByCity(String city) {
        return repository.findByCity(city);
    }

    @Override
    public List<Loja> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Loja save(Loja loja) {
        return repository.save(loja);
    }

    @Override
    @Transactional
    public void update(Loja loja, Long id) {
        
        repository.findById(id)
            .map(l -> {
                loja.setId(id);
                repository.save(loja);
                return l;
            }).orElseThrow(
                () -> new ServiceRuleException("Id de loja não encontrado."));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.findById(id)
            .map(l -> {
                repository.delete(l);
                return l;
            }).orElseThrow(
                () -> new ServiceRuleException("Id de loja não encontrado."));
    }

}
