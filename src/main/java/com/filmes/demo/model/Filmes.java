package com.filmes.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Filmes")
public class Filmes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "te_titulo")
    private String titulo;

    @Column(name = "nb_tempo")
    private int tempo;

    @Column(name = "te_descricao")
    private String descricao;

    @Column(name = "dt_data")
    private Integer dataCriacao;

    // Coluna para armazenar imagem codificada em Base64
    @Column(name = "te_imagem_base64", columnDefinition = "TEXT")
    private String imagemBase64;

    public Filmes() {
    }

    public Filmes(Integer id, String titulo, int tempo, String descricao, Integer dataCriacao, String imagemBase64) {
        this.id = id;
        this.titulo = titulo;
        this.tempo = tempo;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.imagemBase64 = imagemBase64;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getImagemBase64() {
        return imagemBase64;
    }

    public void setImagemBase64(String imagemBase64) {
        this.imagemBase64 = imagemBase64;
    }

    @Override
    public String toString() {
        return "Filmes [id=" + id + ", titulo=" + titulo + ", tempo=" + tempo +
                ", descricao=" + descricao + ", dataCriacao=" + dataCriacao +
                ", imagemBase64=" + (imagemBase64 != null ? "[BASE64_STRING_TRUNCADA]" : null) + "]";
    }
}
