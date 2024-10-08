package br.ifsul.bdii.gui;

import java.util.List;
import java.util.ArrayList;

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
                UIPerfil uiPer = new UIPerfil(usuario);
                uiPer.setVisible(true);
                dispose();
            }
        });

        btnPerfil.setBounds(900, 20, 90, 30);
        contentPane.add(btnPerfil);

        btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                buscarLivros(txtPesquisa.getText());
            }
         });
        btnBuscar.setBounds(650, 20, 90, 30);
        contentPane.add(btnBuscar);

        inicializarLivros(usuario, buscarLivros(null));
    }

    private List<Livro> buscarLivros(String titulo) {
        List<Livro> livros = new ArrayList<Livro>(24);

        if(titulo==null) {
            livros = livroService.findAll(); 
            return livros;
        } else {
            livros = livroService.findByTituloLike(titulo);
            return livros;
        }
    }

    private void inicializarLivros(Usuario usuario, List<Livro> livros) {
            Integer k = -1;

            livros.forEach(Livro -> {
                k++;
                JButton btnLivro = new JButton("Livro");
                btnLivro.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        UILivro uiLivro = new UILivro(usuario, Livro);
                        uiLivro.setVisible(true);
                    } 
                });
                int x = 100+(140*k);
                int y;
                if(k>8 && k<16) {
                    y = 280;
                } else if (k>16) {
                    y = 420;
                } else {
                    y = 100;
                }

                btnLivro.setBounds(x, y, 90, 130);
                contentPane.add(btnLivro);
            });
    }
}
