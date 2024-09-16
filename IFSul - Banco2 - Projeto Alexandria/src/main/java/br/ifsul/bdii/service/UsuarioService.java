package br.ifsul.bdii.service;

import java.util.List;

import br.ifsul.bdii.domain.entity.Avaliacao;
import br.ifsul.bdii.domain.entity.Emprestimo;
import br.ifsul.bdii.domain.entity.Usuario;

public interface UsuarioService{

    Usuario findById(Long id);
    Usuario findByCPF(String cpf);
    List<Usuario> findByEmailLike(String email);
    List<Usuario> findByNameLike(String name);
    List<Usuario> findIfAlert();
    List<Usuario> findAll();
    Emprestimo findCurrentEmprestimo(Long id);
    List<Avaliacao> findAvaliacoes(Long id);
    Usuario save (Usuario usuario);
    void update (Usuario usuario, Long id);
    void delete (Long id);

}