package br.ifsul.bdii.service;

import java.time.Year;
import java.util.List;
import br.ifsul.bdii.domain.entity.Livro;

public interface LivroService{

    Livro findById(Long id);
    List<Livro> findByNameLike(String name);
    List<Livro> findByDescLike(String descrip);
    List<Livro> findByYearSince(Year dateSince);
    List<Livro> findAll();
    Livro save (Livro livro);
    void update (Livro livro, Long id);
    void delete (Long id);

}