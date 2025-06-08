package com.filmes.demo.service;

import com.filmes.demo.DTO.FilmesDTO;
import com.filmes.demo.model.Filmes;
import com.filmes.demo.repository.FilmesRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FilmesService {

    @Autowired
    private FilmesRepository filmesRepository;

    public FilmesService(FilmesRepository filmesRepository) {
        this.filmesRepository = filmesRepository;
    }

    @Transactional(readOnly = true)
    public FilmesDTO findById(Long id){
        Optional<Filmes> filmesOptional = filmesRepository.findById(id);
        Filmes filme = filmesOptional.orElseThrow(() -> new EntityNotFoundException("Filme não encontrado com o ID: " + id));
        return new FilmesDTO(filme);
    }

    @Transactional(readOnly = true)
    public List<FilmesDTO> findAll() {
        return filmesRepository.findAll()
                .stream()
                .map(FilmesDTO::new)
                .toList();
    }

    @Transactional
    public FilmesDTO save(FilmesDTO filmesDTO) {
        Filmes filmes = new Filmes();
        copiarDadosDTOParaEntidade(filmesDTO, filmes);
        Filmes salvo = filmesRepository.save(filmes);
        return new FilmesDTO(salvo);
    }

    @Transactional
    public FilmesDTO updateById(Long id, FilmesDTO filmesDTO) {
        Filmes existente = filmesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Filme não encontrado com o id: " + id));
        copiarDadosDTOParaEntidade(filmesDTO, existente);
        Filmes atualizado = filmesRepository.save(existente);
        return new FilmesDTO(atualizado);
    }

    @Transactional
    public void deleteById(Long id) {
        if (!filmesRepository.existsById(id)) {
            throw new EntityNotFoundException("Filme não encontrado com o id: " + id);
        }
        filmesRepository.deleteById(id);
    }

    // ✅ Método auxiliar para copiar campos do DTO para a entidade
    private void copiarDadosDTOParaEntidade(FilmesDTO dto, Filmes entidade) {
        entidade.setTitulo(dto.getTitulo());
        entidade.setTempo(dto.getTempo());
        entidade.setDescricao(dto.getDescricao());
        entidade.setDataCriacao(dto.getDataCriacao());
        entidade.setImagemBase64(dto.getImagemBase64()); // Campo base64 da imagem
    }
}
