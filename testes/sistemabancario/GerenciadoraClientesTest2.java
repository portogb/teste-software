package sistemabancario;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sistemabancario.Cliente;
import sistemabancario.GerenciadoraClientes;

/**
 * Classe de teste criada para garantir o funcionamento das principais opera��es
 * sobre clientes, realizadas pela classe {@link GerenciadoraClientes}.
 * 
 * @author Clayton Chagas
 * @date 30/09/2022 
 */
public class GerenciadoraClientesTest2 {

	private GerenciadoraClientes gerClientes;

	private int idCliente01 = 1;
	private int idCliente02 = 2;

	@Before
	public void setUp() {
		//************* Montagem do cenário global **********//
		Cliente cliente01 = new Cliente(idCliente01, "Joao da Silva", 47, "joaodasilva@gmail.com", 1, true);
		Cliente cliente02 = new Cliente(idCliente02, "Maria da Silva", 10, "mariadasilva@gmail.com", 1, true);

		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);

		gerClientes = new GerenciadoraClientes(clientesDoBanco);
	}

	@After
	public void tearDown() {
		//************* Desmontagem do cenário global **********//
		gerClientes.limpa();
	}

	/**
	 * Teste b�sico da pesquisa de um cliente a partir do seu ID.
	 * 
	 * @author Clayton Chagas
	 * @date 30/09/2022
	 */
	@Test
	public void testPesquisaCliente() {

		/* ========== Montagem do cen�rio ========== */
		//int idCliente01 = 1;
		//int idCliente02 = 2;
		// criando alguns clientes
		//Cliente cliente01 = new Cliente(idCliente01, "Joao da Silva", 47, "joaodasilva@gmail.com", 1, true);
		//Cliente cliente02 = new Cliente(idCliente02, "Maria da Silva", 10, "mariadasilva@gmail.com", 1, true);

		// inserindo os clientes criados na lista de clientes do banco
		//List<Cliente> clientesDoBanco = new ArrayList<>();
		//clientesDoBanco.add(cliente01);
		//clientesDoBanco.add(cliente02);

		//gerClientes = new GerenciadoraClientes(clientesDoBanco);

		/* ========== Execu��o ========== */
		Cliente cliente = gerClientes.pesquisaCliente(idCliente01);

		/* ========== Verifica��es ========== */
		assertThat(cliente.getId(), is(idCliente01));

	}
	
	@Test
	public void testPesquisaClienteInexistente() {
		
		/* ========== Execu��o ========== */
		Cliente cliente = gerClientes.pesquisaCliente(10);

		/* ========== Verifica��es ========== */
		assertNull(cliente);
	}
	

	/**
	 * Teste b�sico da remo��o de um cliente a partir do seu ID.
	 * 
	 * @author Clayton Chagas
	 * @date 30/09/2022
	 */
	@Test
	public void testRemoveCliente() {

		/* ========== Montagem do cen�rio ========== */
		//		int idCliente01 = 1;
		//		int idCliente02 = 2;
		//		// criando alguns clientes
		//		Cliente cliente01 = new Cliente(idCliente01, "Joao da Silva", 47, "joaodasilva@gmail.com", 1, true);
		//		Cliente cliente02 = new Cliente(idCliente02, "Maria da Silva", 10, "mariadasilva@gmail.com", 1, true);
		//		
		//		// inserindo os clientes criados na lista de clientes do banco
		//		List<Cliente> clientesDoBanco = new ArrayList<>();
		//		clientesDoBanco.add(cliente01);
		//		clientesDoBanco.add(cliente02);
		//		
		//		gerClientes = new GerenciadoraClientes(clientesDoBanco);

		/* ========== Execu��o ========== */
		boolean clienteRemovido = gerClientes.removeCliente(idCliente02);

		/* ========== Verifica��es ========== */
		assertThat(clienteRemovido, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(idCliente02));

	}
	
	@Test
	public void testRemoveClienteInexistente() {

		/* ========== Execu��o ========== */
		boolean clienteRemovido = gerClientes.removeCliente(10);

		/* ========== Verifica��es ========== */
		assertThat(clienteRemovido, is(false));
		assertFalse(clienteRemovido);
		assertThat(gerClientes.getClientesDoBanco().size(), is(2));
	}

}

//Documenta��o e coment�rios