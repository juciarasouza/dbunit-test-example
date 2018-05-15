package br.com.wedo.clienteX.projetoY.suitecenariodetesteZ;

import java.io.File;

import org.dbunit.dataset.ITable;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Test;

import br.com.wedo.clienteX.projetoY.generics.DBUnitGenericConfig;
import br.com.wedo.clienteX.projetoY.suitecenariodetesteZ.configuracoes.ConfigCT123TabelaReferencia;

/**
 * Classe onde os metodos responsáveis pelos testes de um caso de teste são
 * construídos Utilizar o ID do caso de teste no nome da classe, por exemplo
 * <CT123> para que seja mantida a rastreabilidade
 *
 */

public class CT123TesteTabelaReferencia extends DBUnitGenericConfig {

	public static final String TABELA_CLIENTE_VIRTUAL = "TABELA_CLIENTE_VIRTUAL";

	/*
	 * A notação @Test deve ser utilizada os métodos, por convecao, devem
	 * iniciar com a palavra <test>
	 */

	@Test
	public void testEventType() throws Exception {

		String query = ConfigCT123TabelaReferencia.SELECT_TABELA_REFERENCIA;
		ITable tabelaAtual = getConnection().createQueryTable(TABELA_CLIENTE_VIRTUAL, query);

		// o ReplacementDataSet é utilizado para substituir valores para que
		// seja possivel a comparação, como o NULL
		ReplacementDataSet expectedDataSet = new ReplacementDataSet(new FlatXmlDataSetBuilder()
				.build(new File(ConfigCT123TabelaReferencia.FILE_DATASET_TABELA_REFERENCIA)));

		// substitui os valores nulos da tabela atual por [NULL]. Esse valor
		// deve ser substituido no dataset manualmente
		expectedDataSet.addReplacementObject("[NULL]", null);

		ITable tabelaEsperada = expectedDataSet.getTable(ConfigCT123TabelaReferencia.TB_EXPECTED_NAME);

		//metodo implementado no DBUnitGenericConfig
		compareTable(tabelaAtual, tabelaEsperada);

	}
}
