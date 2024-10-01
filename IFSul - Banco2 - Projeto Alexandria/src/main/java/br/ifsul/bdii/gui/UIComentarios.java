package br.ifsul.bdii.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


public class UIComentarios extends JFrame{

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtComenta;
    private JLabel txtComentarios;
    private JButton btnPerfil;
    private JButton btnComenta;
    private JButton btnVerPerfil;

    public UIComentarios(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1200, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewJLabel = new JLabel("Comentar");
        lblNewJLabel.setBounds(210, 30, 150, 30);
        contentPane.add(lblNewJLabel);

        txtComenta = new JTextField();
        txtComenta.setBounds(200, 30, 650, 100);
        contentPane.add(txtComenta);

        btnComenta = new JButton("Enviar");
        btnComenta.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            }
        });
        btnComenta.setBounds(850, 65, 150, 30);
        contentPane.add(btnComenta);

        btnPerfil = new JButton("Perfil");
        btnPerfil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                UIPerfil uiPer = new UIPerfil();
                uiPer.setVisible(true);
            }
        });
        btnPerfil.setBounds(1050, 20, 90, 30);
        contentPane.add(btnPerfil);

        txtComentarios = new JLabel("comentario");
        txtComentarios.setBounds(350, 300, 650, 75);
        txtComentarios.setBorder(new LineBorder(Color.BLACK,1));
        contentPane.add(txtComentarios);

        btnVerPerfil = new JButton("Pessoa");
        btnVerPerfil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){

            }
        });
        btnVerPerfil.setBounds(210, 320, 100, 30);
        contentPane.add(btnVerPerfil);



    }

    
}
