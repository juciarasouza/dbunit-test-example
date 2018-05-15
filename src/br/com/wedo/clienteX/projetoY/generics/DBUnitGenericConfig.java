package br.com.wedo.clienteX.projetoY.generics;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

import org.dbunit.Assertion;
import org.dbunit.DatabaseTestCase;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.SortedTable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;


public abstract class DBUnitGenericConfig extends DatabaseTestCase {

	/*
	 * Metodo de conexao ao banco:: Definir driver de conexao ao banco, Notacao
	 * da Connection para o Oracle:
	 * jdbc:oracle:thin:@<host>:<porta>:<SID>,<usuario>,<senha>
	 */

	@Override
	protected IDatabaseConnection getConnection() throws Exception {

		Connection jdbcConnection = DriverManager.getConnection("jdbc:oracle:thin:@10.174.226.91:1522:RAD1",
				"SRAID_UC_DAT001", "SRAID_UC_DAT001");

		return new DatabaseConnection(jdbcConnection);
	}

	/*
	 * Metodo de leitura do arquivo xml dos datasets utilizados nos testes
	 */
	@Override
	protected IDataSet getDataSet() throws Exception {
		return new FlatXmlDataSetBuilder().build(new File("dataset-SAMPLE.xml"));
	}

	protected DatabaseOperation getSetUpOperation() throws Exception {
		return DatabaseOperation.NONE;
	}

	protected DatabaseOperation getTearDownOperation() throws Exception {
		return DatabaseOperation.NONE;
	}

	/*
	 * Metodo utilizado nos testes para comparar os valores atuais e esperados
	 */
	protected void compareTable(ITable current, ITable expected) throws DataSetException, DatabaseUnitException {
		Assertion.assertEquals(new SortedTable(expected), new SortedTable(current, expected.getTableMetaData()));
	}
}
