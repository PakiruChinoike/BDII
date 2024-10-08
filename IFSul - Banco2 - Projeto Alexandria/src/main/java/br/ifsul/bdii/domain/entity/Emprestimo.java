package br.ifsul.bdii.domain.entity;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table (name = "Emprestimo")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "emprestimo_id")
    private long id;

    @Column (name = "data_emprestimo")
    private Date dataEmprestimo;

    @Column (name = "data_devolucao")
    private Date dataDevolucao;

    @OneToOne
    private Usuario usuario;

    @OneToOne
    private Livro livro;
}
