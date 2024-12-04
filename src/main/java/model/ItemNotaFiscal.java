package model;

public class ItemNotaFiscal {
    private String descricao;
    private int quantidade;
    private double precoUnitario;

    public ItemNotaFiscal(String descricao, int quantidade, double precoUnitario) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public double getValorTotal() {
        return quantidade * precoUnitario;
    }

    // Getters e Setters
    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    @Override
    public String toString() {
        return "ItemNotaFiscal [Descrição=" + descricao + ", Quantidade=" + quantidade +
                ", Preço Unitário=" + precoUnitario + ", Valor Total=" + getValorTotal() + "]";
    }
}
