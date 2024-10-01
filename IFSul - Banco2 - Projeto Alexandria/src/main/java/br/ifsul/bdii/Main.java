package br.ifsul.bdii;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Profile;

import br.ifsul.bdii.gui.UIInicio;
import br.ifsul.bdii.service.UsuarioService;

@Profile("default")
@SpringBootApplication
public class Main /*implements CommandLineRunner*/{

	@Autowired
	UsuarioService service;

	public static void main(String[] args) {

		SpringApplicationBuilder sab = new SpringApplicationBuilder(Main.class);
		sab.headless(false);
		sab.run(args);
	}

	// @Override
	// public void run(String... args) throws Exception {
	// 	UIInicio uiInicio = new UIInicio(service);
	// 	uiInicio.setVisible(true);
	// }

}
