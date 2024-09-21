package br.ifsul.bdii;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import br.ifsul.bdii.gui.UICadastroPessoa;
import br.ifsul.bdii.gui.UILogin;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {

		SpringApplicationBuilder sab = new SpringApplicationBuilder(Main.class);
		sab.headless(false);
		sab.run(args);

		UICadastroPessoa uicp = new UICadastroPessoa();
		UILogin uilo = new UILogin();
		
		uicp.setVisible(true);
		uilo.setVisible(true);
	}

}
