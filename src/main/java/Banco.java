import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Banco {

	private String nome;
	private List<Conta> contas;
	private List<Cliente> clientes; // Adicionando lista de clientes

	public Banco(String nome) {
		this.nome = nome;
		this.contas = new ArrayList<>();
		this.clientes = new ArrayList<>(); // Inicializa a lista de clientes
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		// Retorna uma cópia imutável para proteger o encapsulamento
		return Collections.unmodifiableList(contas);
	}
	
	// Removido o setContas para manter o encapsulamento

	public void adicionarConta(Conta conta) {
		if (conta != null && !contas.contains(conta)) {
			this.contas.add(conta);
		}
	}

	public void removerConta(Conta conta) {
		this.contas.remove(conta);
	}

	public List<Cliente> getClientes() {
		// Retorna uma cópia imutável para proteger o encapsulamento
		return Collections.unmodifiableList(clientes);
	}

	public void adicionarCliente(Cliente cliente) {
		if (cliente != null && !clientes.contains(cliente)) {
			this.clientes.add(cliente);
		}
	}

	public void removerCliente(Cliente cliente) {
		this.clientes.remove(cliente);
	}

	public Conta buscarContaPorNumero(int numero) {
		for (Conta conta : contas) {
			if (conta.getNumero() == numero) {
				return conta;
			}
		}
		return null; // Retorna null se a conta não for encontrada
	}
	
	public Cliente buscarClientePorNome(String nome) {
		for (Cliente cliente : clientes) {
			if (cliente.getNome().equalsIgnoreCase(nome)) {
				return cliente;
			}
		}
		return null; // Retorna null se o cliente não for encontrado
	}
}