package br.dev.rogerribeiro.tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FrameGerenciador {
	
	private JButton btnFuncionarios;
	private JButton btnTarefas;
	
	public FrameGerenciador(){
		criarTela();
	}

	public void criarTela() {

		JFrame tela = new JFrame();
		tela.setSize(350, 150);
		tela.setTitle("Gerenciador de Tarefas");
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		tela.setVisible(true);
		
		btnFuncionarios = new JButton("Funcionários");
		btnFuncionarios.setBounds(30, 45, 120, 30);
		
		btnTarefas = new JButton("Tarefas");
		btnTarefas.setBounds(190, 45, 120, 30);;
		
		
		Container painel = tela.getContentPane();
		painel.add(btnFuncionarios);
		painel.add(btnTarefas);
		
		btnFuncionarios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameFuncionarioList();
				
				
			}
		});
		
		btnTarefas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameTarefaList();
				
			}
		});
		
		
	}

}
