package dio.padroes_projeto_spring.controller;

import dio.padroes_projeto_spring.model.Estudante;
import dio.padroes_projeto_spring.service.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("estudantes")
public class EstudanteRestController {

    @Autowired
    private EstudanteService estudanteService;

    @GetMapping
    public ResponseEntity<Iterable<Estudante>> buscarTodos(){return ResponseEntity.ok(estudanteService.buscarTodos());}

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Estudante>> buscarPorId(@PathVariable int id){
        return ResponseEntity.ok(estudanteService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Estudante> inserirEstudante(@RequestBody Estudante estudante){
        estudanteService.inserirEstudante(estudante);
        return ResponseEntity.ok(estudante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudante> atualizarEstudante(@PathVariable int id,@RequestBody Estudante estudante){
        estudanteService.atualizarEstudante(id, estudante);
        return ResponseEntity.ok(estudante);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Estudante> removerEstudante(@PathVariable int id){
        estudanteService.removerEstudante(id);
        return ResponseEntity.ok().build();
    }

}
