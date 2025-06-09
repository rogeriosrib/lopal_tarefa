package br.dev.rogerribeiro.tarefas.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
			ff.getBufferWriterFuncionarios().write(funcionario.toString());
			ff.getBufferWriterFuncionarios().flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public List<Funcionario> listar() {

		List<Funcionario> funcionarios = new ArrayList<Funcionario>();

		try {
			FileFactory ff = new FileFactory();
			BufferedReader br = ff.getBufferedReaderFuncionarios();

			String linha = "";

			br.readLine();

			while (linha != null) {
				// Extraíndo uma linha do arquivo
				linha = br.readLine();
				System.out.println(linha);

				// Criando vetor que guarda cada informação antes da ","
				if (linha != null){
					String funcionarioStr[] = linha.split(",");

					// Criando um objeto funcionario
					Funcionario funcionario = new Funcionario();
					funcionario.setMatricula(funcionarioStr[0]);
					funcionario.setNome(funcionarioStr[1]);
					funcionario.setCargo(funcionarioStr[2]);
					funcionario.setSalario(Double.parseDouble(funcionarioStr[3]));

					funcionarios.add(funcionario);
				}
				

			}

			return funcionarios;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
