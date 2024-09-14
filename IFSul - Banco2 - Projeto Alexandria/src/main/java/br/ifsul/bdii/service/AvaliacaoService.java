package br.ifsul.bdii.service;

import java.util.List;
import br.ifsul.bdii.domain.entity.Avaliacao;

public interface AvaliacaoService {

    Avaliacao findById(Long id);
    List<Avaliacao> findAll();
    Avaliacao save(Avaliacao avaliacao);
    void update(Avaliacao avaliacao, Long id);
    void delete(Long id);
}
