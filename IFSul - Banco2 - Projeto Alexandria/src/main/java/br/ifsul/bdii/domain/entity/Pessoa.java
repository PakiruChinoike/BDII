package br.ifsul.bdii.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = { "id" })
public class Pessoa {

	private Long id;
	private String nome, sobrenome;
	
}
