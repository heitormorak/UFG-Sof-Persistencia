package webtest;

public class Candidato {
	
	private int codigo;
	private String nome;
	private String sexo;
	private String data_nasc;
	private String cargo_pretendido;
	private String texto_curriculo;
	
	public Candidato(int codigo, String nome, String sexo, String date, String cargo_pretendido, String texto_curriculo) {
		this.codigo = codigo;
		this.nome = nome;
		this.sexo = sexo;
		this.data_nasc = date;
		this.cargo_pretendido = cargo_pretendido;
		this.texto_curriculo = texto_curriculo;
		
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getData_nasc() {
		return data_nasc;
	}
	public void setData_nasc(String data_nasc) {
		this.data_nasc = data_nasc;
	}
	public String getCargo_pretendido() {
		return cargo_pretendido;
	}
	public void setCargo_pretendido(String cargo_pretendido) {
		this.cargo_pretendido = cargo_pretendido;
	}
	public String getTexto_curriculo() {
		return texto_curriculo;
	}
	public void setTexto_curriculo(String texto_curriculo) {
		this.texto_curriculo = texto_curriculo;
	}
	

}