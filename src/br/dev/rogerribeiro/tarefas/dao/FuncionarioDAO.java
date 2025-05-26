package br.dev.rogerribeiro.tarefas.dao;

import java.io.IOException;

import br.dev.rogerribeiro.tarefas.factory.FileFactory;
import br.dev.rogerribeiro.tarefas.model.Funcionario;

public class FuncionarioDAO {

	private Funcionario funcionario;

	public FuncionarioDAO() {
	}

	public FuncionarioDAO(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public void gravar() {
		try {
			FileFactory ff = new FileFactory();
			ff.getBufferWriter().write(funcionario.toString());
			ff.getBufferWriter().flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
