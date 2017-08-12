package br.ufg.inf.controllers;

import br.ufg.inf.models.Venda;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class VendaController {

    @GetMapping("/venda")
    public String vender() {
        Gson gson = new Gson();
        return gson.toJson(new Venda("Sabonete", 3));
    }
}
