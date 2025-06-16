package br.dev.rogerribeiro.tarefas.ui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.dev.rogerribeiro.tarefas.dao.FuncionarioDAO;
import br.dev.rogerribeiro.tarefas.dao.tarefasDAO;
import br.dev.rogerribeiro.tarefas.model.Status;
import br.dev.rogerribeiro.tarefas.model.Tarefa;
import br.dev.rogerribeiro.tarefas.utils.Utils;

public class FrameTarefa {

	private JLabel labelTitulo;
	private JLabel labelDescricao;
	private JLabel labelDataInicial;
	private JLabel labelDataExemplo;
	private JLabel labelPrazo;
	private JLabel labelDataConclusao;
	private JTextField txtTitulo;
	private JTextField txtDescricao;
	private JTextField txtDataInicial;
	private JTextField txtPrazo;
	private JTextField txtDataConclusao;
	private JComboBox<String> jboxResponsavel;
	private JComboBox<Status> jboxStatus;
	private JButton btnSalvar;
	private JButton btnSair;

	public FrameTarefa(JDialog tarefa) {
		criarTela(tarefa);
	}

	public void criarTela(JDialog tarefa) {

		JDialog tela = new JDialog(tarefa, true);
		tela.setTitle("Cadastro de tarefas");
		tela.setSize(400, 450);
		tela.setResizable(false);
		tela.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		tela.setLayout(null);
		tela.setLocationRelativeTo(tarefa);

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

		labelDataExemplo = new JLabel("Ex: 14/09/1969");
		labelDataExemplo.setFont(new Font("Arial", Font.BOLD, 13));
		labelDataExemplo.setBounds(230, 140, 200, 25);

		txtDataInicial = new JTextField();
		txtDataInicial.setFont(new Font("Arial", Font.BOLD, 13));
		txtDataInicial.setBounds(20, 140, 200, 25);

		labelPrazo = new JLabel("Prazo de Entrega : ");
		labelPrazo.setFont(new Font("Arial", Font.BOLD, 13));
		labelPrazo.setBounds(20, 170, 200, 25);

		txtPrazo = new JTextField();
		txtPrazo.setBounds(20, 190, 200, 25);

		labelDataConclusao = new JLabel("Data de conclusão : ");
		labelDataConclusao.setFont(new Font("Arial", Font.BOLD, 13));
		labelDataConclusao.setBounds(20, 220, 200, 25);

		txtDataConclusao = new JTextField();
		txtDataConclusao.setBounds(20, 240, 200, 25);

		jboxResponsavel = new JComboBox<>(new FuncionarioDAO().getNomesFuncionarios());
		jboxResponsavel.setBounds(20, 280, 200, 25);

		jboxStatus = new JComboBox<>(Status.values());
		jboxStatus.setBounds(20, 310, 200, 25);

		btnSalvar = new JButton("Cadastrar");
		btnSalvar.setBounds(20, 360, 200, 25);

		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (txtTitulo.getText().isEmpty() || txtDescricao.getText().isEmpty()
							|| txtDataInicial.getText().isEmpty() || txtPrazo.getText().isEmpty()) {
						JOptionPane.showMessageDialog(tela, "Preencha todos os campos obrigatórios!", "Erro",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					Tarefa t = new Tarefa();
					t.setCodigo(Utils.gerarUUID8());
					t.setTitulo(txtTitulo.getText());
					t.setDescricao(txtDescricao.getText());
					labelDataExemplo.setText(null);
					try {
						t.setData(LocalDate.parse(txtDataInicial.getText().replace("/", ""),
								DateTimeFormatter.ofPattern("ddMMyyyy")));
						t.setPrazo(Integer.parseInt(txtPrazo.getText()));
					} catch (DateTimeParseException ex) {
						JOptionPane.showMessageDialog(tela, "Formato de data inválido, por favor Use dd/mm/yyyy",
								"Erro", JOptionPane.ERROR_MESSAGE);
						return;
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(tela, "Prazo deve ser um número inteiro!", "Erro",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					t.setStatus(List.of((Status) jboxStatus.getSelectedItem()));
					t.setResponsavel((String) jboxResponsavel.getSelectedItem());

					new tarefasDAO(t).gravar();
					limparFormulario();
					JOptionPane.showMessageDialog(tela, "Tarefa salva com sucesso!", "Sucesso!",
							JOptionPane.INFORMATION_MESSAGE);

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(tela, "Erro ao salvar: " + ex.getMessage(), "Erro",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnSair = new JButton("Sair");
		btnSair.setBounds(240, 360, 70, 25);

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
		painel.add(txtTitulo);
		painel.add(labelDescricao);
		painel.add(txtDescricao);
		painel.add(labelDataInicial);
		painel.add(labelDataExemplo);
		painel.add(txtDataInicial);
		painel.add(labelPrazo);
		painel.add(txtPrazo);
		painel.add(labelDataConclusao);
		painel.add(txtDataConclusao);
		painel.add(jboxResponsavel);
		painel.add(jboxStatus);
		painel.add(btnSalvar);
		painel.add(btnSair);

		tela.setVisible(true);

	}

	private void limparFormulario() {
		txtTitulo.setText("");
		txtDescricao.setText("");
		txtDataInicial.setText("");
		txtPrazo.setText("");
		txtDataConclusao.setText("");
		jboxResponsavel.setSelectedIndex(0);
		jboxStatus.setSelectedIndex(0);
		txtTitulo.requestFocus();
	}

}
