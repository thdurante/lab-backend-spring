package br.ufg.inf.models;

import javax.persistence.*;

@Entity
@Table(name="venda")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    private String produto;
    private Integer quantidade;

    public Venda() {
    }

    public Venda(Integer codigo, String produto, Integer quantidade) {
        this.codigo = codigo;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
