package br.dev.rogerribeiro.tarefas.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FrameTarefaList {

	private JLabel labelTitulo;
	private JButton btnCadastro;
	private JTable tabelaTarefas;
	private JScrollPane scrollTarefas;
	private DefaultTableModel modelTarefas;
	private String[] colunas = {"Código", "Nome", "Responsável"};
	
	public FrameTarefaList() {
		criarTela();
	}
	

	private void criarTela() {
		JFrame tela = new JFrame();
		tela.setSize(500, 500);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		tela.setTitle("Lista de Tarefas");
		tela.setResizable(false);
		
		labelTitulo = new JLabel("Cadastro de tarefas");
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 24));
		labelTitulo.setForeground(Color.RED);
		labelTitulo.setBounds(10, 10, 300, 40);
		
		modelTarefas = new DefaultTableModel(colunas, 5) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		tabelaTarefas = new JTable(modelTarefas);
		tabelaTarefas.getTableHeader().setReorderingAllowed(false);
		scrollTarefas = new JScrollPane(tabelaTarefas);
		scrollTarefas.setBounds(10, 60, 460, 300);
		
		btnCadastro = new JButton("Cadastro");
		btnCadastro.setBounds(10, 380, 200, 40);
		
		btnCadastro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameTarefas();
				
			}
		});
		
		
		Container painel = tela.getContentPane();
		painel.add(labelTitulo);
		painel.add(scrollTarefas);
		painel.add(btnCadastro);
	
		tela.setVisible(true);
	}
	
}
