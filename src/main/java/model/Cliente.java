package model;

public class Cliente {
    private String nome;
    private Long cpf;
    private String cidade;
    private String endereco;
    private String estado;
    private int numero;
    private long telefone;


    public Cliente(String nome, Long cpf, String cidade, String endereco, String estado, int numero, long telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.cidade = cidade;
        this.endereco = endereco;
        this.estado = estado;
        this.numero = numero;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEstado() {
        return estado;
    }

    public int getNumero() {
        return numero;
    }

    public long getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return "Cliente [Nome=" + nome + ", CPF=" + cpf + ", Cidade=" + cidade +
                ", Endereço=" + endereco + ", Estado=" + estado + ", Número=" + numero +
                ", Telefone=" + telefone + "]";

    }
}

