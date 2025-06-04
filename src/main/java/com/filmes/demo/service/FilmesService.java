package com.filmes.demo.service;

import com.filmes.demo.DTO.FilmesDTO;
import com.filmes.demo.model.Filmes;
import com.filmes.demo.repository.FilmesRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
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
        if (filmesOptional.isEmpty()) {
            throw new RuntimeException("Time não encontrado com o ID: " + id);
        }
        return new FilmesDTO(filmesOptional.get());
    }

    @Transactional(readOnly = true)
    public List<FilmesDTO> findAll() {
        List<Filmes> filmesList = filmesRepository.findAll();
        return filmesList.stream()
                .map(FilmesDTO::new)
                .toList();  // no Java 16+ toList(), para versões anteriores use collect(Collectors.toList())
    }
    @Transactional
    public FilmesDTO save(FilmesDTO filmesDTO) {
        Filmes filmes = new Filmes();
        BeanUtils.copyProperties(filmesDTO, filmes);
        Filmes saved = filmesRepository.save(filmes);
        return new FilmesDTO(saved);
    }

    @Transactional
    public FilmesDTO updateById(Long id, FilmesDTO filmesDTO) {
        // Buscar o time no banco de dados pelo nome
        Optional<Filmes> optionalFilmes = filmesRepository.findById(id);

        // Verificar se o time foi encontrado
        Filmes existingFilmes = optionalFilmes.orElseThrow(() -> new EntityNotFoundException("Filme não encontrado com o id: " + id));

        // Atualizar os campos do time com os dados do DTO
        BeanUtils.copyProperties(filmesDTO, existingFilmes, "id");  // "id" não será copiado, para não sobrescrever o ID do time existente

        // Salvar o time atualizado no banco de dados
        Filmes updatedFilmes = filmesRepository.save(existingFilmes);

        // Retornar o TimeDTO do time atualizado
        return new FilmesDTO(updatedFilmes);
    }

    @Transactional
    public void deleteById(Long id) {
        filmesRepository.deleteById(id);
    }


}
