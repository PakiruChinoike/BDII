package br.ifsul.bdii.domain.entity;

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
@Table (name = "Avaliacao")
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "avaliacao_id")
    private long id;

    @Column (name = "nota")
    private double nota;

    @OneToOne
    @Column (name = "Usuario")
    private Usuario usuario;

    @OneToOne
    @Column (name = "Livro")
    private Livro livro;
    

}
