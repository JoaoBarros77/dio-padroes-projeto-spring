package dio.padroes_projeto_spring.service.impl;

import dio.padroes_projeto_spring.model.Endereco;
import dio.padroes_projeto_spring.model.Estudante;
import dio.padroes_projeto_spring.repository.EnderecoRepository;
import dio.padroes_projeto_spring.repository.EstudanteRepository;
import dio.padroes_projeto_spring.service.EstudanteService;
import dio.padroes_projeto_spring.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstudanteServiceImpl implements EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Estudante> buscarTodos(){
        return estudanteRepository.findAll();
    }

    @Override
    public Optional<Estudante> buscarPorId(int id){
        Optional<Estudante> estudante = estudanteRepository.findById(id);
        return estudante;
    }
    @Override
    public void inserirEstudante(Estudante estudante){
        salvarEstudanteComCep(estudante);
    }

    @Override
    public void atualizarEstudante(int id, Estudante estudante){
        Optional<Estudante> estudanteBd = estudanteRepository.findById(id);
        if(estudanteBd.isPresent()){
            salvarEstudanteComCep(estudante);
        }
    }
    @Override
    public void removerEstudante(int id){
        estudanteRepository.deleteById(id);
    }

    private void salvarEstudanteComCep(Estudante estudante) {
        String cep = estudante.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        estudante.setEndereco(endereco);
        estudanteRepository.save(estudante);
    }
}
