package br.ifsul.bdii;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ifsul.bdii.gui.UIInicio;
import br.ifsul.bdii.service.impl.UsuarioServiceImpl;
import jakarta.annotation.PostConstruct;
import lombok.val;

@Component
public class Starter {

    @Autowired
    private UsuarioServiceImpl repo;
    
    @PostConstruct
    public void run()
    {
        UIInicio inicio = new UIInicio(repo);
        inicio.setVisible(true);
    }

}
