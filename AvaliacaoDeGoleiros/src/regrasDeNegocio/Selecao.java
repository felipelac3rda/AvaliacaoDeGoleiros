package regrasDeNegocio;

import java.util.ArrayList;

public class Selecao {
	private ArrayList<Goleiro> selecao = new ArrayList();
	private String nomeDaSelecao;
	private ArrayList<String> listaDeGoleiros = new ArrayList();

	public Selecao(String nomeDaSelecao) {
		this.nomeDaSelecao = nomeDaSelecao;
		selecao = new ArrayList();
	}

	public void adicionarGoleiros(Goleiro goleiro) {
		selecao.add(goleiro);
		listaDeGoleiros.add(goleiro.toString());
	}

	public String getNomeDaSelecao() {
		return nomeDaSelecao;
	}

	public void setNomeDaSelecao(String nomeDaSelecao) {
		this.nomeDaSelecao = nomeDaSelecao;
	}

	public ArrayList<Goleiro> getSelecao() {
		return selecao;
	}
	
	public double mediaDeChutesPegos() {
		double media = 0;
		int totalCobrancas = 0;
		for (Goleiro goleiro : selecao) {
			media += goleiro.getGolsDefendidos();
			totalCobrancas += goleiro.getTotalDeCobrancas();
		}
		return media/totalCobrancas;
	}
	
	public double mediaDeGolsTomados() {
		double media = 0;
		int totalCobrancas = 0;
		for (Goleiro goleiro : selecao) {
			media += goleiro.getGolsTomados();
			totalCobrancas += goleiro.getTotalDeCobrancas();
		}
		return media/totalCobrancas;
	}
	
	public double mediaDeChutesNaTrave() {
		double media = 0;
		int totalCobrancas = 0;
		for (Goleiro goleiro : selecao) {
			media += goleiro.getPegouNaTrave();
			totalCobrancas += goleiro.getTotalDeCobrancas();
		}
		return media/totalCobrancas;
	}
	
	public double mediaDeChutesParaFora() {
		double media = 0;
		int totalCobrancas = 0;
		for (Goleiro goleiro : selecao) {
			media += goleiro.getParaFora();
			totalCobrancas += goleiro.getTotalDeCobrancas();
		}
		return media/totalCobrancas;
	}
	
	
	public String retornaNomeGoleiro(int i) {
		return selecao.get(i).getNome();
	}
	public String goleiroIndicado() {
		String nome = "";
		int aux = selecao.get(0).getAAG();
		int posicao = 0;
		for(int i = 1; i < selecao.size(); i++) {
			if(selecao.get(i).getAAG() > aux) {
				aux = selecao.get(i).getAAG();
				posicao = i;
			}
		}
		return selecao.get(posicao).getNome();
	}

	
	public String toString() {
		String saida = "";
		saida+= getNomeDaSelecao() + " - \n";
		for (String lista : listaDeGoleiros) {
			saida+= " - " +lista + "\n";
		}
		
		return saida;
	}
	
	
}
