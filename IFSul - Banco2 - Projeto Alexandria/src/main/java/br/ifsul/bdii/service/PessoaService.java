package br.ifsul.bdii.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ifsul.bdii.domain.Pessoa;

public final class PessoaService {

	/**
	 * Método para cadastrar uma pessoa no banco - gera um novo registro
	 * 
	 * @param newPessoa - pessoa a ser inserida no banco
	 * @return retorna a pessoa cadastrada, com o ID preenchido
	 */
	public static Pessoa save(Pessoa entidade) {

		if (entidade == null)
			return null;

		final String insertStatement = "INSERT INTO PESSOA(nome, sobrenome) VALUES(?, ?);";

		try {

			// abre a conexao
			Connection conn = DBConnection.openConnection();

			// o prepared statement deve ser usado quando o comando requer parâmetros
			PreparedStatement ps = conn.prepareStatement(insertStatement);

			// seta os parametros - cuidado com os tipos de dados de cada coluna/atributo
			ps.setString(1, entidade.getNome()); // seta o parametro 1 - primeira interrogacao
			ps.setString(2, entidade.getSobrenome());// seta o parametro 2 - segunda interrogacao

			// OBS.: note que o ID não deve ser informado, uma vez que a pessoa ainda
			// não existe no banco, e no nosso caso, o ID é autoincrementado

			// executa no banco
			boolean executed = ps.execute();

			// se o comando executou corretamente (insert)
			if (executed) {
				// lê o ID que foi gerado e atualiza a pessoa
				Long id = ps.getGeneratedKeys().getLong("id");
				// atualiza o objeto pessoa, para ser retornado para quem chamou
				entidade.setId(id);
			}

			// fecha/libera a conexão
			conn.close();

		} catch (Exception e) {
			System.err.println("Ocorreu um erro ao inserir: " + e.getMessage());
			// e.printStackTrace();
			return null;
		}

		return entidade;
	}

	/**
	 * Lista todos as pessoas da tabela Pessoa
	 * 
	 * @return Lista de pessoas
	 */
	public static List<Pessoa> findAll() {
		List<Pessoa> lista = new ArrayList<>();

		final String query = "SELECT * FROM pessoa;";

		try {
			Connection c = DBConnection.openConnection();

			// statement é um objeto para representar um comando no banco
			Statement st = c.createStatement();

			ResultSet rs = st.executeQuery(query); // executa o comando

			// Esse while percorre linha por linha do resutlado da query
			while (rs.next()) {

				// cada GET deve respeitar o tipo de dado de cada coluna
				Long id = rs.getLong("id");
				String nome = rs.getString("nome");
				String sobrenome = rs.getString("sobrenome");

				// cria o objeto pessoa com os dados lidos da linha em consideracao
				Pessoa p = new Pessoa(id, nome, sobrenome);

				// adiciona lista
				lista.add(p);

				// e vai para o proximo registro
			}

			c.close(); // fecha/libera a conexão
		} catch (SQLException e) {
			System.err.println("Ocorreu um erro: " + e.getMessage());
		}

		return lista;
	}
}
