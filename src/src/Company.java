package src;

public class Company extends Searchable {
	String cnpj_basico;
	String razao_social;
	String natureza;
	String qualificacao_responsavel;
	String capital_social;
	String porte;
	String ente;
	
	public void fill(String[] attrs) {
		this.cnpj_basico = attrs[0].replace("\"", "");
		this.razao_social = attrs[1].replace("\"", "");
		this.natureza = attrs[2].replace("\"", "");
		this.qualificacao_responsavel = attrs[3].replace("\"", "");
		this.capital_social = attrs[4].replace("\"", "");
		this.porte = attrs[5].replace("\"", "");
		this.ente = attrs[6].replace("\"", "");		
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Company [cnpj_basico=");
		builder.append(cnpj_basico);
		builder.append(", razao_social=");
		builder.append(razao_social);
		builder.append(", natureza=");
		builder.append(natureza);
		builder.append(", qualificacao_responsavel=");
		builder.append(qualificacao_responsavel);
		builder.append(", capital_social=");
		builder.append(capital_social);
		builder.append(", porte=");
		builder.append(porte);
		builder.append(", ente=");
		builder.append(ente);
		builder.append("]");
		return builder.toString();
	}
	
	
}
