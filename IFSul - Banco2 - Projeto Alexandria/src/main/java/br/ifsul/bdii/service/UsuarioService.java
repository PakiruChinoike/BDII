package br.ifsul.bdii.service;

import java.util.List;
import br.ifsul.bdii.domain.entity.Usuario;

public interface UsuarioService{

    Usuario findById(Long id);
    List<Usuario> findAll();
    Usuario save (Usuario usuario);
    void update (Usuario usuario, Long id);
    void delete (Long id);

}