package br.com.lojadebrinquedo.controller;

import br.com.lojadebrinquedo.dto.BrinquedoDTO;
import br.com.lojadebrinquedo.service.BrinquedoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/brinquedos")
@RequiredArgsConstructor
public class BrinquedoController {

    @Autowired
    private BrinquedoService brinquedoService;

    @GetMapping("/listar")
    public List<BrinquedoDTO> listarBrinquedos() {
        return brinquedoService.listarTodosBrinquedos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrinquedoDTO> obterBrinquedoPorId(@PathVariable Long id) {
        Optional<BrinquedoDTO> brinquedo = brinquedoService.encontrarBrinquedoPorId(id);
        return brinquedo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<BrinquedoDTO> cadastrarBrinquedo(@Valid @RequestBody BrinquedoDTO brinquedoDTO) {
        BrinquedoDTO novoBrinquedo = brinquedoService.salvarBrinquedo(brinquedoDTO);
        return ResponseEntity.ok(novoBrinquedo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BrinquedoDTO> atualizarBrinquedo(@PathVariable Long id,
                                                           @Valid @RequestBody BrinquedoDTO brinquedoDTO) {
        Optional<BrinquedoDTO> brinquedo = brinquedoService.encontrarBrinquedoPorId(id);
        if (brinquedo.isPresent()) {
            brinquedoDTO.setId(id);
            BrinquedoDTO brinquedoAtualizado = brinquedoService.salvarBrinquedo(brinquedoDTO);
            return ResponseEntity.ok(brinquedoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarBrinquedo(@PathVariable Long id) {
        brinquedoService.deletarBrinquedo(id);
        return ResponseEntity.noContent().build();
    }
}
