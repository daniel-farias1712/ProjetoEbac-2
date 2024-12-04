package dao;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class ClienteDao {

    private static ClienteDao instance;
    private List<Cliente> clientes = new ArrayList<>();


    private ClienteDao() {}


    public static synchronized ClienteDao getInstance() {
        if (instance == null) {
            instance = new ClienteDao();
        }
        return instance;
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }


    public Cliente buscarClientePorNome(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nome)) {
                return cliente;
            }
        }
        return null;
    }


    public Cliente DeletarClientePorNome(String nome) {
        Iterator<Cliente> iterator = clientes.iterator();  // Cria o Iterator para a lista de clientes
        while (iterator.hasNext()) {  // Verifica se há mais elementos na lista
            Cliente cliente = iterator.next();  // Pega o próximo cliente da lista
            if (cliente.getNome().equals(nome)) {  // Se o nome do cliente for igual ao nome fornecido
                iterator.remove();  // Remove o cliente de maneira segura
                return cliente;  // Retorna o cliente removido
            }
        }
        return null;  // Retorna null caso o cliente não seja encontrado
    }
}
