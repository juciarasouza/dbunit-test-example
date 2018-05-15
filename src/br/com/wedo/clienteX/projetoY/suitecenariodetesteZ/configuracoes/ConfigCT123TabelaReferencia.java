package br.com.wedo.clienteX.projetoY.suitecenariodetesteZ.configuracoes;

/**
 * Classe em que s�o definidas as configura��es vari�veis de cada teste como o
 * nome da tabela, selects com a clausula WHERE, o caminho dos arquivos de
 * dataset. Todas as informa��es que ser�o utilizadas pelos testes que podem
 * facilitar a manuten��o do c�digo
 */
public class ConfigCT123TabelaReferencia {

	// tabela target
	public static final String TB_EXPECTED_NAME = "RD_R_EVENT_TYPE";
	
	// definicao generica do caminho do diret�rio de dataset
	private static String datasetPath = "T:/DBUnit_modelo/DataSet/CT123TesteTabelaReferencia";
	
	//definicao do select
	public static final String SELECT_TABELA_REFERENCIA = "select EVENT_TYPE_ID,EVENT_DIRECTION,EVENT_TYPE"+TB_EXPECTED_NAME;
	
	//definicao do caminho para o arquivo xml do dataset
	public static final String FILE_DATASET_TABELA_REFERENCIA = datasetPath + "Dataset-TabelaReferencia.xml";

}
