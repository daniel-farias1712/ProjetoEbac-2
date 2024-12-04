package Testmodel;
import static org.junit.jupiter.api.Assertions.assertEquals;

import model.Cliente;
import org.junit.jupiter.api.Test;

public class ClienteTest {

    @Test
    public void testarClienteCriado() {
        //Criando os dados que serão usados

        String nome = "Daniel";
        Long cpf = 1019203848L;
        String cidade = "Paris";
        String endereco = "Rua augusta";
        String estado = "Paraiba";
        int numero = 462;
        long telefone = 81999644355L;

        //Instaciando o CLiente
        Cliente cliente = new Cliente(nome, cpf, cidade, endereco, estado, numero, telefone);

        // Verificando se os valores estão corretos
        assertEquals(nome, cliente.getNome());
        assertEquals(cpf, cliente.getCpf());
        assertEquals(cidade, cliente.getCidade());
        assertEquals(endereco, cliente.getEndereco());
        assertEquals(estado, cliente.getEstado());
        assertEquals(numero, cliente.getNumero());
        assertEquals(telefone, cliente.getTelefone());
    }
}
