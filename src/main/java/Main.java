public class Main {

	public static void main(String[] args) {
		// Instanciando o Banco
		Banco meuBanco = new Banco("Digital Bank DIO");

		// Criando clientes
		Cliente ClienteTeste = new Cliente();
		ClienteTeste.setNome("Teste");
		meuBanco.adicionarCliente(ClienteTeste);

		Cliente camila = new Cliente();
		camila.setNome("Camila");
		meuBanco.adicionarCliente(camila);
		
		// Criando contas para Teste
		Conta ccTeste = new ContaCorrente(ClienteTeste);
		Conta poupancaTeste = new ContaPoupanca(ClienteTeste);
		meuBanco.adicionarConta(ccTeste);
		meuBanco.adicionarConta(poupancaTeste);

		// Operações com tratamento de exceções
		try {
			ccTeste.depositar(100);
			System.out.println("Depósito de 100 na CC do Teste realizado.");
		} catch (IllegalArgumentException e) {
			System.out.println("Erro ao depositar: " + e.getMessage());
		}

		try {
			ccTeste.transferir(50, poupancaTeste);
			System.out.println("Transferência de 50 da CC para Poupança do Teste realizada.");
		} catch (IllegalArgumentException e) {
			System.out.println("Erro ao transferir: " + e.getMessage());
		}

		// Tentando sacar mais do que o saldo
		try {
			ccTeste.sacar(100); // Saldo da CC Teste deveria ser 50 após depósito e transferência
			System.out.println("Saque de 100 da CC do Teste realizado.");
		} catch (IllegalArgumentException e) {
			System.out.println("Erro ao sacar: " + e.getMessage());
		}

		// Tentando depositar valor negativo
		try {
			poupancaTeste.depositar(-10);
			System.out.println("Depósito de -10 na Poupança do Teste realizado.");
		} catch (IllegalArgumentException e) {
			System.out.println("Erro ao depositar: " + e.getMessage());
		}

		System.out.println("\n--- Extratos ---");
		ccTeste.imprimirExtrato();
		poupancaTeste.imprimirExtrato();

		System.out.println("\n--- Informações do Banco ---");
		System.out.println("Nome do Banco: " + meuBanco.getNome());
		System.out.println("Total de Contas no Banco: " + meuBanco.getContas().size());
		System.out.println("Total de Clientes no Banco: " + meuBanco.getClientes().size());
		
		// Exemplo de busca de conta/cliente (se necessário)
		Conta contaBuscada = meuBanco.buscarContaPorNumero(ccTeste.getNumero());
		if (contaBuscada != null) {
			System.out.println("Conta encontrada pelo número: " + contaBuscada.getNumero() + " (Titular: " + contaBuscada.getCliente().getNome() + ")");
		}

		Cliente clienteBuscado = meuBanco.buscarClientePorNome("Teste");
		if (clienteBuscado != null) {
			System.out.println("Cliente encontrado pelo nome: " + clienteBuscado.getNome());
		}
	}

}