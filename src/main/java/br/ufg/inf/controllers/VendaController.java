package br.ufg.inf.controllers;

import br.ufg.inf.models.Venda;
import br.ufg.inf.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @GetMapping
    public List<Venda> listarVendas() {
        return vendaService.getVendas();
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody Venda venda) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vendaService.salvar(venda));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity getVenda(@PathVariable("codigo") int codigo) {
        return vendaService.getVenda(codigo);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity destroyVenda(@PathVariable("codigo") int codigo) {
        return vendaService.destroyVenda(codigo);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity updateVendaPut(@PathVariable("codigo") int codigo, @RequestBody Venda venda) {
        return vendaService.updateVenda(codigo, venda);
    }

    @PatchMapping("/{codigo}")
    public ResponseEntity updateVendaPatch(@PathVariable("codigo") int codigo, @RequestBody Venda venda) {
        return vendaService.updateVenda(codigo, venda);
    }
}
