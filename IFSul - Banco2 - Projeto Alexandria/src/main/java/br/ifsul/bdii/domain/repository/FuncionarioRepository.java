package br.ifsul.bdii.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import br.ifsul.bdii.domain.entity.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository
<Funcionario, Long>{

    @Query(" select f from funcionario where f.nome like%:name%")
    List<Funcionario> findByNameLike (@Param("name")String name);

    @Query(" select f from funcionario where f.email=:gmail")
    List<Funcionario> findByEmail(@Param("gmail")String gmail);

    @Query(" select f from fruncionairo where f.telefone=:phone")
    List<Funcionario> findByPhone(@Param("phone")String phone)


}