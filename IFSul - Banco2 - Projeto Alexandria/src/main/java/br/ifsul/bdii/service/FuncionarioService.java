package br.ifsul.bdii.service;

import java.util.List;
import br.ifsul.bdii.domain.entity.Funcionario;

public interface FuncionarioService{

    Funcionario findById(Long id);
    List<Funcionario> findByNameLike(String name);
    List<Funcionario> findByEmail(String gmail);
    List<Funcionario> findByPhone(String phone);
    List<Funcionario> findAll();
    Funcionario save (Funcionario funcionario);
    void update (Funcionario funcionario, Long id);
    void delete (Long id);

}