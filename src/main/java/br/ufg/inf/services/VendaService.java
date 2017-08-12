package br.ufg.inf.services;

import br.ufg.inf.models.Venda;
import br.ufg.inf.repositories.VendaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public Venda salvar(Venda venda) {
        return vendaRepository.save(venda);
    }

    public ResponseEntity getVenda(int codigo) {
        if (vendaRepository.exists(codigo))
            return ResponseEntity.ok(vendaRepository.findOne(codigo));

        return ResponseEntity.notFound().build();

    }

    public List<Venda> getVendas() {
        List<Venda> vendas = new ArrayList<>();
        Iterator<Venda> iterator = vendaRepository.findAll().iterator();
        while (iterator.hasNext())
            vendas.add(iterator.next());
        return vendas;
    }

    public ResponseEntity destroyVenda(int codigo) {
        if (vendaRepository.exists(codigo)) {
            vendaRepository.delete(codigo);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity updateVenda(int codigo, Venda novaVenda) {
        if (vendaRepository.exists(codigo)) {
            Venda venda = vendaRepository.findOne(codigo);
            BeanUtils.copyProperties(novaVenda, venda, "codigo");

            return ResponseEntity.ok(vendaRepository.save(venda));
        }

        return ResponseEntity.notFound().build();
    }
}
