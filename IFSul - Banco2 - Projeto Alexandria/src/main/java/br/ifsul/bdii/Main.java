package br.ifsul.bdii;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import br.ifsul.bdii.gui.UIInicio;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {

		SpringApplicationBuilder sab = new SpringApplicationBuilder(Main.class);
		sab.headless(false);
		sab.run(args);

		UIInicio uiInicio = new UIInicio();
		
		uiInicio.setVisible(true);
	}

}
