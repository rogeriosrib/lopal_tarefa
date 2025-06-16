package br.dev.rogerribeiro.tarefas.ui;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrameTarefas {

	private JLabel labelTitulo;
	private JLabel labelDescricao;
	private JLabel labelDataInicial;
	private JLabel labelPrazo;
	private JLabel labelDataConclusao;
	private JTextField txtTitulo;
	private JTextField txtDescricao;
	private JTextField txtDataInicial;
	private JTextField txtPrazo;
	private JTextField txtDataConclusao;

	public FrameTarefas() {
		criarTela();
	}

	public void criarTela() {

		JDialog tela = new JDialog();
		tela.setTitle("Cadastro de tarefas");
		tela.setSize(400, 450);
		tela.setResizable(false);
		tela.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);

		labelTitulo = new JLabel("Título : ");
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 13));
		labelTitulo.setBounds(20, 20, 200, 20);

		txtTitulo = new JTextField();
		txtTitulo.setBounds(20, 40, 200, 25);

		labelDescricao = new JLabel("Descrição : ");
		labelDescricao.setFont(new Font("Arial", Font.BOLD, 13));
		labelDescricao.setBounds(20, 70, 200, 25);

		txtDescricao = new JTextField();
		txtDescricao.setBounds(20, 90, 200, 25);

		labelDataInicial = new JLabel("Data de Início : ");
		labelDataInicial.setFont(new Font("Arial", Font.BOLD, 13));
		labelDataInicial.setBounds(20, 120, 200, 25);
		
		txtDataInicial = new JTextField();
		txtDataInicial.setFont(new Font("Arial", Font.BOLD, 13));
		txtDataInicial.setBounds(20, 140, 200, 25);

		labelPrazo = new JLabel("Prazo de Entrega : ");
		labelPrazo.setBounds(20, 160, 200, 25);

		labelDataConclusao = new JLabel("Data de conclusão : ");
		labelDataConclusao.setFont(new Font("Arial", Font.BOLD, 13));
		labelDataConclusao.setBounds(20, 220, 200, 25);

		Container painel = tela.getContentPane();
		painel.add(labelTitulo);
		painel.add(txtTitulo);
		painel.add(labelDescricao);
		painel.add(txtDescricao);
		painel.add(labelDataInicial);
		painel.add(txtDataInicial);
		painel.add(labelPrazo);
		painel.add(labelDataConclusao);

		tela.setVisible(true);
	}

}
