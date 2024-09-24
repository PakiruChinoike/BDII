package br.ifsul.bdii.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
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

public class Teste extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JLabel txtStatus;
	private JButton btnListar;
	private JList<Usuario> listPessoas;
	private DefaultListModel<Usuario> model = new DefaultListModel<>();
	
	public Teste() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 334, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(10, 22, 89, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sobrenome:");
		lblNewLabel_1.setBounds(10, 59, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		txtNome = new JTextField();
		txtNome.setBounds(97, 19, 165, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtSobrenome = new JTextField();
		txtSobrenome.setBounds(97, 56, 165, 20);
		contentPane.add(txtSobrenome);
		txtSobrenome.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarPessoa();
			}
		});
		
		btnSalvar.setBounds(97, 84, 89, 23);
		contentPane.add(btnSalvar);
		
		txtStatus = new JLabel("");
		txtStatus.setBounds(107, 118, 210, 14);
		contentPane.add(txtStatus);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarPessoas();
			}
		});
		btnListar.setBounds(10, 165, 89, 23);
		contentPane.add(btnListar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 199, 278, 237);
		contentPane.add(scrollPane);
		
		listPessoas = new JList<>();
		scrollPane.setViewportView(listPessoas);
		
		listPessoas.setModel(model);
	}
	
	private void salvarPessoa()
	{
        UsuarioService service = new UsuarioServiceImpl(null);

		Usuario p = new Usuario();
		p.setNome( txtNome.getText() );
		
		service.save(p);
		
		txtStatus.setText("Pessoa cadastrada!");
	}
		
	private void listarPessoas() {
        UsuarioService service = new UsuarioServiceImpl(null);

		List<Usuario> pessoas = service.findAll();
		model.clear();
		model.addAll(pessoas);
	}
}
