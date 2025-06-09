package br.dev.rogerribeiro.tarefas.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.rogerribeiro.tarefas.factory.FileFactory;
import br.dev.rogerribeiro.tarefas.model.Tarefa;

public class tarefasDAO {

	private Tarefa tarefa;

	public tarefasDAO() {
	}

	public tarefasDAO(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public void gravar() {
		try {
			FileFactory ff = new FileFactory();
			ff.getBufferWriterTarefas().write(tarefa.toString());
			ff.getBufferWriterTarefas().flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public List<Tarefa> listar() {

		List<Tarefa> tarefas = new ArrayList<Tarefa>();

		try {
			FileFactory ff = new FileFactory();
			BufferedReader br = ff.getBufferedReaderTarefas();

			String linha = "";

			br.readLine();

			while (linha != null) {
				// Extraíndo uma linha do arquivo
				linha = br.readLine();
				System.out.println(linha);

				// Criando vetor que guarda cada informação antes da ","
				if (linha != null){
					String TarefaStr[] = linha.split(",");

					// Criando um objeto funcionario
					Tarefa tarefa = new Tarefa();
					tarefa.setResponsavel(TarefaStr[6]);

					tarefas.add(tarefa);
				}
				

			}

			return tarefas;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}