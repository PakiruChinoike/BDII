package br.ifsul.bdii.gui;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;

import br.ifsul.bdii.domain.entity.Usuario;
import br.ifsul.bdii.service.UsuarioService;
import br.ifsul.bdii.service.impl.UsuarioServiceImpl;

public class UIInicio extends JFrame {

  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private JLabel biblioAlexandria;
  private JButton btnLogin;
  private JButton btnCadastro;

  private UsuarioService service;

  public UIInicio(UsuarioService service) {

    this.service = service;

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 500, 500);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    setContentPane(contentPane);
    contentPane.setLayout(null);

    biblioAlexandria = new JLabel("BIBLIO ALEXANDRIA");
    biblioAlexandria.setBounds(185, 120, 150, 50);
    contentPane.add(biblioAlexandria);

    btnCadastro = new JButton("Cadastro");
    btnCadastro.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        UICadastroUsuario uiCad = new UICadastroUsuario();
        uiCad.setVisible(true);
      }
    });

    btnCadastro.setBounds(200, 185, 100, 30);
    contentPane.add(btnCadastro);

    btnLogin = new JButton("Login");
    btnLogin.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        UILogin uiLog = new UILogin();
        uiLog.setVisible(true);
      }
    });

    btnLogin.setBounds(200, 225, 100, 30);
    contentPane.add(btnLogin);
  }

}
    