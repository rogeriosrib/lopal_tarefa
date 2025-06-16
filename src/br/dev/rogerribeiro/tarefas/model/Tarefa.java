package br.dev.rogerribeiro.tarefas.model;

import java.time.LocalDate;
import java.util.List;

public class Tarefa {

	private String titulo;
	private String codigo;
	private String descricao;
	private LocalDate data;
	private int prazo;
	private List<Status> status;
	private String responsavel;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getPrazo() {
		return prazo;
	}

	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}

	public LocalDate conclusao() {
		LocalDate entrega = data;
		return entrega.plusDays(prazo);
	}

	public List<Status> getStatus() {
		return status;
	}

	public void setStatus(List<Status> status) {
		this.status = status;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	@Override
	public String toString() {
		String tarefa = codigo + "," + titulo + "," + descricao + "," + data + "," + prazo + "," + conclusao() + ","
				+ status + "," + responsavel + "\n";
		return tarefa;
	}

}
