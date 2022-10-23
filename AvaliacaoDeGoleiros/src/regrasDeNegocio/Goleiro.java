package regrasDeNegocio;

public class Goleiro {
	private int id;
	private String nome;
	private int velocidade;
	private int flexibilidade;
	private int agilidade;
	private int coordenacao;
	private int forca;
	private int equilibrio;
	private int AAG;
	private int golsTomados = 0;
	private int golsDefendidos = 0;
	private int totalDeCobrancas = 0;
	private int pegouNaTrave = 0;
	private int paraFora = 0;

	public Goleiro(int id, String nome, int velocidade, int flexibilidade, int agilidade, int coordenacao, int forca,
			int equilibrio) {
		super();
		this.id = id;
		this.nome = nome;
		this.velocidade = velocidade;
		this.flexibilidade = flexibilidade;
		this.agilidade = agilidade;
		this.coordenacao = coordenacao;
		this.forca = forca;
		this.equilibrio = equilibrio;
		calcularAreaAtuacaodoGoleiro();
	}

	public void calcularAreaAtuacaodoGoleiro() {
		AAG = (int) (((velocidade * 3) + (flexibilidade * 2) + (agilidade * 3) + (coordenacao * 2) + forca
				+ (equilibrio * 2)) / 8);
	}

	public void levarGol() {
		golsTomados++;
	}

	public void defenderGol() {
		golsDefendidos++;
	}

	public void AdicionarCobranca() {
		totalDeCobrancas++;
	}

	public int getGolsTomados() {
		return golsTomados;
	}

	public int getGolsDefendidos() {
		return golsDefendidos;
	}

	public int getAAG() {
		return AAG;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(int velocidade) {
		if (velocidade >= 1 && velocidade <= 10) {
			this.velocidade = velocidade;
		}
	}

	public int getFlexibilidade() {
		return flexibilidade;
	}

	public void setFlexibilidade(int flexibilidade) {
		if (flexibilidade >= 1 && flexibilidade <= 10) {
			this.flexibilidade = flexibilidade;
		}
	}

	public int getAgilidade() {
		return agilidade;
	}

	public void setAgilidade(int agilidade) {
		if (agilidade >= 1 && agilidade <= 10) {
			this.agilidade = agilidade;
		}
	}

	public int getCoordenacao() {
		return coordenacao;
	}

	public void setCoordenacao(int coordenacao) {
		if (coordenacao >= 1 && coordenacao <= 10) {
			this.coordenacao = coordenacao;
		}
	}

	public int getForca() {
		return forca;
	}

	public void setForca(int forca) {
		if (forca >= 1 && forca <= 10) {
			this.forca = forca;
		}
	}

	public int getEquilibrio() {
		return equilibrio;
	}

	public void setEquilibrio(int equilibrio) {
		if (equilibrio >= 1 && equilibrio <= 10) {
			this.equilibrio = equilibrio;
		}
	}

	public void setAAG(int aAG) {
		AAG = aAG;
	}

	public int getTotalDeCobrancas() {
		return totalDeCobrancas;
	}

	public int getPegouNaTrave() {
		return pegouNaTrave;
	}

	public void chutePegouNaTrave() {
		pegouNaTrave++;
	}

	public int getParaFora() {
		return paraFora;
	}

	public void chuteParaFora() {
		paraFora++;
	}

	public String toString() {
		return "Goleiro [id = " + id + ", nome = " + nome + ", AAG = " + AAG + ", golsTomados = " + golsTomados
				+ ", golsDefendidos = " + golsDefendidos + "]";
	}
	

	
	
}
