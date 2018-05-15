package br.com.wedo.clienteX.projetoY.geradorDataList;

/**
 * Classe responsavel por instanciar os metodos da XMLCreator e gerar o datasets
 */
public class ExportaDatasetXMLCreator {

	public static void main(String[] args) {

		XMLCreator xml = new XMLCreator();
		
		//instancia dos métodos
		xml.createXMLPartialSchema("Dataset-Event-Type.xml", "RD_R_EVENT_TYPE", "select * from RD_R_EVENT_TYPE");
		xml.createXMLPartialSchema("Dataset-Event-Type2.xml", "RD_R_EVENT_TYPE", "select * from RD_R_EVENT_TYPE");
		xml.createXMLPartialSchema("Dataset-Event-Type2.xml", "RD_R_EVENT_TYPE", "select * from RD_R_EVENT_TYPE");
		// xml.createXMLSchema(XMLName);
	}

}
