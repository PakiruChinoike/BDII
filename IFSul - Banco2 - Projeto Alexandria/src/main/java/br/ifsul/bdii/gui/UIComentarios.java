package br.ifsul.bdii.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


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
        btnComenta.setBounds(850, 30, 150, 30);
        contentPane.add(btnComenta);

    }

    
}
