package br.ifsul.bdii.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import br.ifsul.bdii.domain.entity.Usuario;

public class UIComentarios extends JFrame{

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel txtComentarios;
    private JButton btnPerfil;
    private JButton btnVerPerfil;

    public UIComentarios(Usuario usuario){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1200, 900);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        btnPerfil = new JButton("Perfil");
        btnPerfil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                UIPerfil uiPer = new UIPerfil(usuario);
                uiPer.setVisible(true);
            }
        });
        btnPerfil.setBounds(1050, 20, 90, 30);
        contentPane.add(btnPerfil);

        for (int y = 120; y<800; y = y+100) {
            txtComentarios = new JLabel("Comentário");
            txtComentarios.setBounds(200, y, 650, 75);
            txtComentarios.setBorder(new LineBorder(Color.BLACK,1));
            contentPane.add(txtComentarios);

            btnVerPerfil = new JButton("Pessoa");
            btnVerPerfil.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){

                }
            });
            btnVerPerfil.setBounds(60, y+20, 100, 30);
            contentPane.add(btnVerPerfil);
            }
    }
}
