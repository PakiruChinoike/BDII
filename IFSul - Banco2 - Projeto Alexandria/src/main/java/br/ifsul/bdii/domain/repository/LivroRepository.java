package br.ifsul.bdii.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.ifsul.bdii.domain.entity.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

}