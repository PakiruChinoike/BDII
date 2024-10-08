package br.ifsul.bdii.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.ifsul.bdii.domain.entity.Avaliacao;
import br.ifsul.bdii.domain.entity.Emprestimo;
import br.ifsul.bdii.domain.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    @Query(" select u from Usuario u where u.nome=:string or u.email=:string")
    Optional<Usuario> findByNameOrEmail(@Param("string")String string);

    @Query(" select u from Usuario u where u.nome like %:name%")
    List<Usuario> findByNameLike(@Param("name")String name);

    @Query(" select u from Usuario u where u.email like %:email%")
    List<Usuario> findByEmailLike(@Param("email")String email);

    @Query(" select u from Usuario u where u.alerta is true")
    List<Usuario> findIfAlert();

    @Query(value=" select e from Emprestimo e join Usuario u on e.usuario=u.usuario_id where u.usuario_id=:id and u.emprestimo is true limit 1", nativeQuery=true)
    Optional<Emprestimo> findCurrentEmprestimo(@Param("id")Long id);

    @Query(" select a from Avaliacao a join Usuario u where u.id=:id")
    List<Avaliacao> findAvaliacoes(@Param("id")Long id);

}