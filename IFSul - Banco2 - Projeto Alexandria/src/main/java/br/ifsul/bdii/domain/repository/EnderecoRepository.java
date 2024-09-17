package br.ifsul.bdii.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import br.ifsul.bdii.domain.entity.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository
<Endereco, Long>{

    @Query(" select e from Endereco e where e.cep=:ceps")
    List<Endereco> findByCep(@Param("ceps")String ceps);

    @Query( "select e from Endereco e where e.estado=:state")
    List<Endereco> findByState(@Param("state")String state);

    @Query( "select e from Endereco e where e.cidade=:city")
    List<Endereco> findByCity(@Param("city")String city);
}