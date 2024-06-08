package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CriarCandidato;
import com.example.demo.model.Candidato;
import com.example.demo.repository.VotacaoRepository;

@RestController
@RequestMapping("/urna")
public class VotacaoController {

    @Autowired
    VotacaoRepository votacaoRepository;
    
    @GetMapping("/votos")
    public ResponseEntity<Object> mostrarVotos(){
        List<Candidato> candidatos = votacaoRepository.findAll();

       return ResponseEntity.status(200).body(candidatos);
       
    }
    @GetMapping("/votos/prefeito")
    public ResponseEntity<Object> votosPrefeito(){
        List<Candidato> prefeitos = votacaoRepository.findByCargo("Prefeito");

        return ResponseEntity.status(200).body(prefeitos);
    }
    @GetMapping("/votos/vereador")
    public ResponseEntity<Object> votosVereador(){
        List<Candidato> vereadores = votacaoRepository.findByCargo("Vereador");

        return ResponseEntity.status(200).body(vereadores);
    }

    @PostMapping("/criar-candidato")
    public ResponseEntity<Object> criarCandidato(@RequestBody CriarCandidato candidato){
        Candidato novoCandidato = new Candidato(candidato.nome(), candidato.cidade(), candidato.cargo(), candidato.numero(), candidato.votos());
        votacaoRepository.save(novoCandidato);
        return ResponseEntity.status(200).body("candidato criado");
    }
    @PostMapping("/votar/{numeroCandidato}")
    public ResponseEntity<Object> votar(@PathVariable Integer numeroCandidato){
        Candidato candidatoVotado = votacaoRepository.findByNumero(numeroCandidato);
        if (candidatoVotado != null) {
            candidatoVotado.setVotos(candidatoVotado.getVotos()+1);
            votacaoRepository.save(candidatoVotado);
            return ResponseEntity.status(200).body("voto salvo para o candidato " + candidatoVotado.getNome());
        }else{
            return ResponseEntity.status(200).body("candidato nao encontrado");
        }
    }
}
