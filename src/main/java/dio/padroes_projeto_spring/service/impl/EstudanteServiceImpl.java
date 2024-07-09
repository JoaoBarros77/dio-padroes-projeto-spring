package dio.padroes_projeto_spring.service.impl;


import dio.padroes_projeto_spring.model.Disciplina;
import dio.padroes_projeto_spring.model.Endereco;
import dio.padroes_projeto_spring.model.Estudante;


import dio.padroes_projeto_spring.repository.DisciplinaRepository;
import dio.padroes_projeto_spring.repository.EnderecoRepository;
import dio.padroes_projeto_spring.repository.EstudanteRepository;

import dio.padroes_projeto_spring.service.EstudanteService;
import dio.padroes_projeto_spring.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EstudanteServiceImpl implements EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Estudante> buscarTodos(){
        return estudanteRepository.findAll();
    }


    @Override
    public Optional<Estudante> buscarPorId(Long id){
        Optional<Estudante> estudante = estudanteRepository.findById(id);
        return estudante;
    }
    @Override
    public void inserirEstudante(Estudante estudante){
        estudante.setEndereco(salvarCepEstudante(estudante));
        estudante.setGradeCurricular(adicionarGradeCurricular(estudante));
        estudanteRepository.save(estudante);
    }


    @Override
    public void atualizarEnderecoEstudante(Long id, Estudante estudante){
        Optional<Estudante> estudanteBd = estudanteRepository.findById(id);
        if(estudanteBd.isPresent()){
            estudante.setEndereco(salvarCepEstudante(estudante));
            for(Disciplina d : estudante.getGradeCurricular()){
                disciplinaRepository.save(d);

            }
            estudanteRepository.save(estudante);
        }
    }
    @Override
    public void removerEstudante(Long id){
        estudanteRepository.deleteById(id);
    }


    private Endereco salvarCepEstudante(Estudante estudante) {
        String cep = estudante.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        return endereco;
    }

    private List<Disciplina> adicionarGradeCurricular(Estudante estudante) {
        List<String> disciplinas = Arrays.asList("Língua Portuguesa", "Artes", "Língua Inglesa", "Educação Física", "Matemática", "Geografia", "História", "Sociologia", "Filosofia", "Biólogia", "Física", "Química");
        List<Disciplina> gradeCurricular = new ArrayList<>();

        for(String s : disciplinas){
            Disciplina disciplina = new Disciplina(s);
            gradeCurricular.add(disciplina);
            disciplinaRepository.save(disciplina);
        }
        return gradeCurricular;
    }

}
