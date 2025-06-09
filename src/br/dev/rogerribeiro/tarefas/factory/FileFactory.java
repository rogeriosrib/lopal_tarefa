package br.dev.rogerribeiro.tarefas.factory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileFactory {

	private String arquivoFuncionarios = "C:\\Users\\25132662\\ProjetoTarefas\\funcionarios.csv";
	private String arquivoTarefas = "C:\\Users\\25132662\\ProjetoTarefas\\funcionarios.csv";

	private FileWriter fwFuncionarios;
	private BufferedWriter bwFuncionarios;
	private FileReader frFuncionarios;
	private BufferedReader brFuncionarios;
	private FileWriter fwTarefas;
	private BufferedWriter bwTarefas;
	private FileReader frTarefas;
	private BufferedReader brTarefas;

	public FileFactory() throws IOException {

		// É necessário para escrever no arquivo
		fwFuncionarios = new FileWriter(arquivoFuncionarios, true);
		bwFuncionarios = new BufferedWriter(fwFuncionarios);
		
		fwTarefas = new FileWriter(arquivoTarefas, true);
		bwTarefas = new BufferedWriter(fwTarefas);

		// É necessário para ler arquivo
		frFuncionarios = new FileReader(arquivoFuncionarios);
		brFuncionarios = new BufferedReader(frFuncionarios);
		
		frTarefas = new FileReader(arquivoTarefas);
		brTarefas = new BufferedReader(frTarefas);
	}

	public BufferedWriter getBufferWriterFuncionarios() {
		return bwFuncionarios;
	}
	
	public BufferedWriter getBufferWriterTarefas() {
		return bwTarefas;
	}

	public BufferedReader getBufferedReaderFuncionarios() {
		return brFuncionarios;
	}
	
	public BufferedReader getBufferedReaderTarefas() {
		return brTarefas;
	}

}
