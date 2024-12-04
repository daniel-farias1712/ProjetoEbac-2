package model;

import java.util.List;

public class NotaFiscal {
    private String numero; // Número da nota fiscal
    private Cliente cliente; // Cliente associado à nota fiscal
    private List<ItemNotaFiscal> itens; // Lista de itens na nota fiscal
    private double valorTotal; // Valor total dos itens


    public NotaFiscal(String numero, Cliente cliente, List<ItemNotaFiscal> itens) {
        this.numero = numero;
        this.cliente = cliente;
        this.itens = itens;
        this.valorTotal = calcularValorTotal();

    }

    // Calcula o valor total dos itens
    private double calcularValorTotal() {
        return itens.stream().mapToDouble(ItemNotaFiscal::getValorTotal).sum();
    }



    // Getters e Setters
    public String getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemNotaFiscal> getItens() {
        return itens;
    }

    public double getValorTotal() {
        return valorTotal;
    }



    @Override
    public String toString() {
        return "NotaFiscal [Número=" + numero + ", Cliente=" + cliente.getNome() +
                ", Valor Total=" + valorTotal + "]";
    }
}
