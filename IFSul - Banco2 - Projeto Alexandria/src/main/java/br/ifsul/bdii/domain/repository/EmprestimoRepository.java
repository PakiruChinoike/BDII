package br.ifsul.bdii.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.sql.Date;
import java.util.List;
import br.ifsul.bdii.domain.entity.Emprestimo;

@Repository
public interface EmprestimoRepository extends JpaRepository
<Emprestimo, Long>{

    @Query(" select e from emprestimo e where e.data_emprestimo=:dateLoan")
    List<Emprestimo> findByDateLoan(@Param("dateLoan")Date dateLoan);

    @Query(" select e from emprestimo e where e.data_devolucao=:dateReturn")
    List<Emprestimo> findByDateReturn(@Param("dateReturn")Date dateReturn);

    @Query(" select e from emprestimo e where e.data_devolucao<:dateSince order by data_emprestimo asc")
    List<Emprestimo> findByDateSince(@Param("dateSince")Date dateSince);

    @Query(" select e from emprestimo e join e.livro l where l.nome like:nome")
    List<Emprestimo> findByLivroName(@Param("nome") String nome);

}