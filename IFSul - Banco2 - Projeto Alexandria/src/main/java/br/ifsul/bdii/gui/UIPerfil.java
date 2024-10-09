package br.ifsul.bdii.gui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import br.ifsul.bdii.domain.entity.Usuario;

public class UIPerfil extends JFrame{

    private static final long serialVersionUID = 1L;
    private JPanel contentJPanel;
    private JLabel txtFoto;
    private JLabel txtInfo;
    private JLabel txtdescricao;
    private JLabel txtAvaliacao;
    private JLabel txtComentarios;

    public UIPerfil (Usuario usuario){
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1200, 600);
        contentJPanel = new JPanel();
        contentJPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentJPanel);
        contentJPanel.setLayout(null);

        txtFoto = new JLabel(usuario.getNome());
        txtFoto.setBounds(50, 50, 200, 200);
        txtFoto.setBorder(new LineBorder(Color.BLACK,1));
        contentJPanel.add(txtFoto);

        txtInfo = new JLabel("Informações");
        txtInfo.setBounds(50, 300, 300, 200);
        txtInfo.setBorder(new LineBorder(Color.BLACK, 1));
        contentJPanel.add(txtInfo);

        txtdescricao = new JLabel("Descrição");
        txtdescricao.setBounds(500, 50, 600, 200);
        txtdescricao.setBorder(new LineBorder(Color.BLACK, 1));
        contentJPanel.add(txtdescricao);

        txtAvaliacao = new JLabel("Avaliação");
        txtAvaliacao.setBounds(500, 300, 150, 30);
        contentJPanel.add(txtAvaliacao);

        txtComentarios = new JLabel("Comentario");
        txtComentarios.setBounds(500, 400, 600, 100);
        txtComentarios.setBorder(new LineBorder(Color.BLACK, 1));
        contentJPanel.add(txtComentarios);


    }
    
}
