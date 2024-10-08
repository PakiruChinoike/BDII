package br.ifsul.bdii.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JOptionPane;

import br.ifsul.bdii.Starter;
import br.ifsul.bdii.domain.entity.Emprestimo;
import br.ifsul.bdii.domain.entity.Livro;
import br.ifsul.bdii.domain.entity.Usuario;
import br.ifsul.bdii.service.EmprestimoService;
import br.ifsul.bdii.service.LivroService;


public class UILivro extends JFrame{

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel txtTitulo;
    private JLabel txtAvaliacao;
    private JLabel txtDescricao;
    private JLabel txtCapaLivro;
    private JTextField txtComentario;
    private JButton btnEnviar;
    private JButton btnComentarios;
    private JButton btnPerfil;
    private JButton btnEmprestimo;

    private LivroService livroService;
    private EmprestimoService emprestimoService;

    public UILivro(Usuario usuario, Livro livro){

        livroService = Starter._livroService;
        emprestimoService = Starter._emprestimoService;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1200, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        txtTitulo = new JLabel("Titulo");
        txtTitulo.setBounds(65, 20, 90, 30);
        txtTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(txtTitulo);

        txtAvaliacao = new JLabel("Avaliacao");
        txtAvaliacao.setBounds(65, 450, 90, 30);
        txtAvaliacao.setBorder(new LineBorder(Color.BLACK, 1));
        txtAvaliacao.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(txtAvaliacao);

        txtDescricao =new JLabel("Descrição");
        txtDescricao.setBounds(400, 100, 600, 300);
        txtDescricao.setBorder(new LineBorder(Color.BLACK, 1));
        txtDescricao.setHorizontalAlignment(SwingConstants.LEFT);
        contentPane.add(txtDescricao);

        txtCapaLivro = new JLabel("Capa Livro");
        txtCapaLivro.setBounds(40, 100, 200, 300);
        txtCapaLivro.setBorder(new LineBorder(Color.BLACK, 1));
        contentPane.add(txtCapaLivro);

        JLabel lblNewJLabel = new JLabel("Comentario");
        lblNewJLabel.setBounds(401, 460, 90, 30);
        contentPane.add(lblNewJLabel);

        txtComentario = new JTextField();
        txtComentario.setBounds(400, 460, 500, 30);
        contentPane.add(txtComentario);

        btnEnviar = new JButton("Enviar");
        btnEnviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){

            }
        });
        btnEnviar.setBounds(900, 460, 100, 30);
        contentPane.add(btnEnviar);

        btnComentarios = new JButton("Comentarios");
        btnComentarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                UIComentarios uiCom = new UIComentarios(usuario);
                uiCom.setVisible(true);
            }
        });
        btnComentarios.setBounds(400, 500, 600, 30);
        contentPane.add(btnComentarios);

        btnPerfil = new JButton("Perfil");
        btnPerfil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                UIPerfil uiPer = new UIPerfil(usuario);
                uiPer.setVisible(true);
            }
        });

        btnPerfil.setBounds(650, 20, 90, 30);
        contentPane.add(btnPerfil);

        btnEmprestimo = new JButton("Emprestimo");
        btnEmprestimo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(isEmprestado(livro)) {
                    JOptionPane.showMessageDialog(contentPane, "", "", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(contentPane, "", "", JOptionPane.INFORMATION_MESSAGE);
                    btnEmprestimo.setEnabled(false);
                }
            }
        });
        btnEmprestimo.setBounds(800, 20, 120, 30);
        contentPane.add(btnEmprestimo);
    }

    private Boolean isEmprestado(Livro livro) {
        Emprestimo e = emprestimoService.findByLivroId(livro.getId());

        return e.getEstado();
    }
}