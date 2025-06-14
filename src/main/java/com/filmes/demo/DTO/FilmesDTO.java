package com.filmes.demo.DTO;

import com.filmes.demo.model.Filmes;

public class FilmesDTO {
    private Integer id;
    private String titulo;
    private int tempo;
    private String descricao;
    private Integer dataCriacao;
    private String imagemBase64;

    // Construtor padrão necessário para o Jackson desserializar
    public FilmesDTO() {
    }

    // Construtor que copia os dados do objeto Filmes
    public FilmesDTO(Filmes filmes) {
        this.id = filmes.getId();
        this.titulo = filmes.getTitulo();
        this.tempo = filmes.getTempo();
        this.descricao = filmes.getDescricao();
        this.dataCriacao = filmes.getDataCriacao();
        this.imagemBase64 = filmes.getImagemBase64();
    }

    // Getters e Setters
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
}
