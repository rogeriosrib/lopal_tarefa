package br.dev.rogerribeiro.tarefas.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.dev.rogerribeiro.tarefas.dao.tarefasDAO;
import br.dev.rogerribeiro.tarefas.model.Tarefa;

public class FrameTarefaList {

	private JLabel labelTitulo;
	private JButton btnCadastro;
	private JButton btnSair;
	private JTable tabelaTarefas;
	private JScrollPane scrollTarefas;
	private DefaultTableModel modelTarefas;
	private String[] colunas = { "Código", "Nome", "Responsável" };

	public FrameTarefaList(JFrame gerenciador) {
		criarTela(gerenciador);
	}

	private void criarTela(JFrame gerenciador) {
		JDialog tela = new JDialog(gerenciador, true);
		tela.setSize(500, 500);
		tela.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		tela.setLayout(null);
		tela.setLocationRelativeTo(gerenciador);
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

		carregarDados();

		btnCadastro = new JButton("Cadastro");
		btnCadastro.setBounds(10, 380, 200, 40);

		btnCadastro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameTarefa(tela);
				carregarDados();
			}
		});

		btnSair = new JButton("Sair");
		btnSair.setBounds(220, 380, 80, 40);

		btnSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int resposta = JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Confirmação",
						JOptionPane.YES_NO_OPTION);

				if (resposta == 0) {
					tela.dispose();

				}

			}
		});

		Container painel = tela.getContentPane();
		painel.add(labelTitulo);
		painel.add(scrollTarefas);
		painel.add(btnCadastro);
		painel.add(btnSair);

		tela.setVisible(true);
	}

	private void carregarDados() {
		tarefasDAO dao = new tarefasDAO();
		List<Tarefa> tarefas = dao.listar();

		Object[][] dados = new Object[tarefas.size()][3];

		int i = 0;
		for (Tarefa t : tarefas) {
			dados[i][0] = t.getCodigo();
			dados[i][1] = t.getTitulo();
			dados[i][2] = t.getResponsavel();
			i++;
		}

		modelTarefas.setDataVector(dados, colunas);
	}

}
