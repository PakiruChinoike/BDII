package br.ifsul.bdii.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.ifsul.bdii.domain.entity.Avaliacao;

@Repository
public interface AvaliacaoRepository extends JpaRepository
<Avaliacao, Long>{

}