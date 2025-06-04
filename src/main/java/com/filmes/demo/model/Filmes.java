package com.filmes.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Filmes")
public class Filmes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "te_titulo")
    private String titulo;

    @Column(name = "nb_tempo")
    private int tempo;

    @Column(name = "te_descricao")
    private String descricao;

    @Column(name = "dt_data")
    private Integer dataCriacao;

    public Filmes() {
    }

    public Filmes(Long id, String titulo, int tempo, String descricao, int dataCriacao) {
        this.id = id;
        this.titulo = titulo;
        this.tempo = tempo;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Integer dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public String toString() {
        return "Filmes{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", tempo=" + tempo +
                ", descricao='" + descricao + '\'' +
                ", dataCriacao=" + dataCriacao +
                '}';
    }
}
