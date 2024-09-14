package br.ifsul.bdii.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.ifsul.bdii.domain.entity.Loja;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Long>{

}