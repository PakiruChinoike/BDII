package br.ifsul.bdii.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UIPrincipal extends JFrame{

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton btnBuscar;
    private JTextField txtPesquisa;
    private JButton btnLivro;
    private JButton btnPerfil;

    public UIPrincipal(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Pesquisa:");
        lblNewLabel.setBounds(10, 20, 90, 30);
        contentPane.add(lblNewLabel);

        txtPesquisa = new JTextField();
        txtPesquisa.setBounds(100, 20, 600, 30);
        contentPane.add(txtPesquisa);
        txtPesquisa.setColumns(10);

        btnPerfil = new JButton("Perfil");
        btnPerfil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                UIPerfil uiPer = new UIPerfil();
                uiPer.setVisible(true);
            }
        });

        btnPerfil.setBounds(900, 20, 90, 30);
        contentPane.add(btnPerfil);

        btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            }
         });
         btnBuscar.setBounds(700, 20, 60, 30);
         contentPane.add(btnBuscar);

        btnLivro = new JButton("Livro");
        btnLivro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                UILivro uiLiv = new UILivro();
                uiLiv.setVisible(true);
            }
        });

        btnLivro.setBounds(100, 100, 90, 130);
        contentPane.add(btnLivro);

    }



   
    
}
