package br.ifsul.bdii.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.ifsul.bdii.Starter;
import br.ifsul.bdii.domain.entity.Livro;
import br.ifsul.bdii.domain.entity.Usuario;
import br.ifsul.bdii.service.LivroService;

public class UIPrincipal extends JFrame{

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton btnBuscar;
    private JTextField txtPesquisa;
    private JButton btnPerfil;

    private LivroService livroService;

    public UIPrincipal(Usuario usuario){
        
        this.livroService = Starter._livroService;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1300, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Pesquisa");
        lblNewLabel.setBounds(60, 20, 90, 30);
        contentPane.add(lblNewLabel);

        txtPesquisa = new JTextField();
        txtPesquisa.setBounds(50, 20, 600, 30);
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
                buscarLivros();
            }
         });
         btnBuscar.setBounds(650, 20, 90, 30);
         contentPane.add(btnBuscar);

        for(int y = 100; y<600; y = y+180) {
            for(int x = 100; x<1200; x = x+140) {
                JButton btnLivro = new JButton("Livro");
                btnLivro.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    UILivro uiLiv = new UILivro(usuario, null);
                    uiLiv.setVisible(true);
                }
            });

                btnLivro.setBounds(x, y, 90, 130);
                contentPane.add(btnLivro);
            }
        }
    }

    private Livro buscarLivros() {
        return null;
    }
}
