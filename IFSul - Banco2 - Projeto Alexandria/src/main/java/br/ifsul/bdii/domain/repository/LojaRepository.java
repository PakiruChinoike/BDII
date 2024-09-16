package br.ifsul.bdii.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.ifsul.bdii.domain.entity.Loja;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Long>{

    @Query(" select l from Loja where l.name like %:name%")
    List<Loja> findByNameLike(@Param("name")String name);

    @Query(" select l from Loja l join Endereco e where e.city like %:city%")
    List<Loja> findByCity(@Param("city")String city);

}