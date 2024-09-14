package br.ifsul.bdii.service;

import java.util.List;
import br.ifsul.bdii.domain.entity.Endereco;

public interface EnderecoService{

    Endereco findById(Long id);
    List<Endereco> findByCep(String ceps);
    List<Endereco> findByState(String stade);
    List<Endereco> findByCity(String city);
    List<Endereco> findAll();
    Endereco save (Endereco endereco);
    void update (Endereco endereco, Long id);
    void delete (Long id);

}