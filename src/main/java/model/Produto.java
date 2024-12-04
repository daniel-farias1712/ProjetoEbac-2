package model;

public class Produto {

    private String descricao;
    private double preco;
    private String codigo;

    public Produto(String descricao, double preco, String codigo) {
        this.descricao = descricao;
        this.preco = preco;
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
