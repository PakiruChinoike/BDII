package br.ifsul.bdii.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class UILogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JPasswordField txtSenha;
	private JButton btnEntrar;


	public UILogin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome/email");
		lblNewLabel.setBounds(160, 20, 90, 30);
		contentPane.add(lblNewLabel);

		txtNome = new JTextField();
		txtNome.setBounds(150, 20, 120, 30);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setBounds(160, 60, 90, 30);
		contentPane.add(lblNewLabel_1);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(150, 60, 120, 30);
		contentPane.add(txtSenha);

		btnEntrar  = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				UIPrincipal uiPri = new UIPrincipal();
				uiPri.setVisible(true);
			}
		});

		btnEntrar.setBounds(160, 200, 100, 30);
		contentPane.add(btnEntrar);



	}

}
