package br.ifsul.bdii.service;

import java.sql.Date;
import java.util.List;
import br.ifsul.bdii.domain.entity.Livro;

public interface LivroService{

    Livro findById(Long id);
    List<Livro> findByNameLike(String name);
    List<Livro> findByDesc(String descrip);
    List<Livro> findByDateSince(Date dateSince);
    List<Livro> findAll();
    Livro save (Livro livro);
    void update (Livro livro, Long id);
    void delete (Long id);

}