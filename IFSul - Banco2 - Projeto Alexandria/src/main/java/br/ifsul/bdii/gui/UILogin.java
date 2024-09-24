package br.ifsul.bdii.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import br.ifsul.bdii.domain.entity.Usuario;
import br.ifsul.bdii.service.UsuarioService;
import br.ifsul.bdii.service.impl.UsuarioServiceImpl;

public class UILogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JPasswordField txtSenha;
	private JButton btnEntrar;


	public UILogin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome/email:");
		lblNewLabel.setBounds(10, 20, 90, 30);
		contentPane.add(lblNewLabel);

		txtNome = new JTextField();
		txtNome.setBounds(100, 20, 90, 30);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Senha:");
		lblNewLabel_1.setBounds(10, 60, 90, 30);
		contentPane.add(lblNewLabel_1);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(100, 100, 90, 30);
		contentPane.add(txtSenha);

		btnEntrar  = new JButton();
		btnEntrar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			}
		});

		btnEntrar.setBounds(100, 200, 100, 30);
		contentPane.add(btnEntrar);



	}

}
