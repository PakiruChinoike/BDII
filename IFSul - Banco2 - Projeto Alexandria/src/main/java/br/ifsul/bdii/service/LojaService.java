package br.ifsul.bdii.service;

import java.util.List;
import br.ifsul.bdii.domain.entity.Loja;

public interface LojaService{

    Loja findById(Long id);
    List<Loja> findByNameLike(String name);
    List<Loja> findByCity(String city);
    List<Loja> findAll();
    Loja save (Loja loja);
    void update (Loja loja, Long id);
    void delete (Long id);

}
