package br.ifsul.bdii.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

public class UICadastroUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JPasswordField txtSenha;
	private JButton btnCadastrar;
	
	public UICadastroUsuario() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(57, 20, 90, 30);
		contentPane.add(lblNewLabel);

		txtNome = new JTextField();
		txtNome.setBounds(50, 20, 90, 30);
		contentPane.add(txtNome);

		JLabel lblNewLabel1 = new JLabel("Email");
		lblNewLabel1.setBounds(55, 60, 90, 30);
		contentPane.add(lblNewLabel1);

		txtEmail = new JTextField();
		txtEmail.setBounds(50, 60, 90, 30);
		contentPane.add(txtEmail);

		JLabel lblNewLabel2 = new JLabel("Telefone");
		lblNewLabel2.setBounds(55, 100, 90, 30);
		contentPane.add(lblNewLabel2);

		txtTelefone = new JTextField();
		txtTelefone.setBounds(50, 100, 90, 30);
		contentPane.add(txtTelefone);

		JLabel lblNewLabel3 = new JLabel("Senha");
		lblNewLabel3.setBounds(55, 140, 90, 30);
		contentPane.add(lblNewLabel3);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(50, 140, 90, 30);
		contentPane.add(txtSenha);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UILogin uiLog = new UILogin();
				uiLog.setVisible(true);
			}
		});

		btnCadastrar.setBounds(100, 200, 100, 30);
		contentPane.add(btnCadastrar);

	}
}
