package br.com.wedo.clienteX.projetoY.geradorDataList;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;

import br.com.wedo.clienteX.projetoY.generics.DBUnitGenericConfig;

/**
 * Classe que contém os métodos de exportação total ou parcial da dase de dados
 * para um Dataset
 *
 */
public class XMLCreator extends DBUnitGenericConfig {

	private IDatabaseConnection connection;

	/*
	 * Metodo construtor desta classe que executa a criação da conexão com o
	 * banco de dados via jdbc
	 */

	public XMLCreator() {
		try {
			connection = getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Metódo para o export parcial da base ex.: um select especifico ou uma
	 * tabela
	 */
	public void createXMLPartialSchema(String nomeArquivoGerado, String tabela, String query) {

		try {
			QueryDataSet datasetCreation = new QueryDataSet(connection);

			datasetCreation.addTable(tabela, query);
			FlatXmlDataSet.write(datasetCreation, new FileOutputStream(nomeArquivoGerado));

			System.out.println("Criando XML");

		} catch (DataSetException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/*
	 * Metódo para o export do schema completo
	 */
	public void createXMLSchema(String nomeArquivoGerado) {
		try {
			IDataSet fullDataSet = connection.createDataSet();
			FlatXmlDataSet.write(fullDataSet, new FileOutputStream(nomeArquivoGerado));

			System.out.println("Criando XML Completo");
		} catch (DataSetException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
