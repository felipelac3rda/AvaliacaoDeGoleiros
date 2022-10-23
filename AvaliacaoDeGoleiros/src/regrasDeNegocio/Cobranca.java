package regrasDeNegocio;

import java.util.Random;

public class Cobranca {
	
	
	private Selecao selecao;
	private Goleiro goleiro;
	private Chute chute;
	private Celula gol[][] = new Celula[9][17];
	private int posicaoDaAreaDeAtuacaoX;
	private int posicaoDaAreaDeAtuacaoY;
	private String fora = "Fora";
	private String dentro = "Dentro";
	private String trave = "Grave";
	private String gaveta = "Gol na gaveta";
	private String atuacao = "Atuacao";

	public Cobranca(Goleiro goleiro, Chute chute) {
		this.goleiro = goleiro;
		this.chute = chute;
		mapeamentoDaTrave();
		posicaoInicialAreaAtuacao(chute.getQuadrante());
		gerarAreaAtuacao();
	}

	public void mapeamentoDaTrave() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 17; j++) {
				if ((i == 0) || (i < 9 && j == 0) || (i < 9 && j == 16)) {
					gol[i][j] = new Celula();
					gol[i][j].setTipo(fora);
				} else if ((j == 1 && i >= 1) || (i == 1 && j >= 1 && j <= 15) || (j == 15 && i >= 1)) {
					gol[i][j] = new Celula();
					gol[i][j].setTipo(trave);
				} else if ((i == 2 && j == 2) || (i == 2 && j == 14)) {
					gol[i][j] = new Celula();
					gol[i][j].setTipo(gaveta);
				} else {
					gol[i][j] = new Celula();
					gol[i][j].setTipo(dentro);
				}

			}
		}
	}

	public void posicaoInicialAreaAtuacao(int quadrante) {
		if (quadrante == 1) {
			posicaoDaAreaDeAtuacaoY = gerarNumeroAleatorioNoIntervalo(2, 7);
			posicaoDaAreaDeAtuacaoX = gerarNumeroAleatorioNoIntervalo(2, 4);
		} else if (quadrante == 2) {
			posicaoDaAreaDeAtuacaoY = gerarNumeroAleatorioNoIntervalo(8, 14);
			posicaoDaAreaDeAtuacaoX = gerarNumeroAleatorioNoIntervalo(2, 4);
		} else if (quadrante == 3) {
			posicaoDaAreaDeAtuacaoY = gerarNumeroAleatorioNoIntervalo(2, 7);
			posicaoDaAreaDeAtuacaoX = gerarNumeroAleatorioNoIntervalo(5, 8);
		} else if (quadrante == 4) {
			posicaoDaAreaDeAtuacaoY = gerarNumeroAleatorioNoIntervalo(8, 14);
			posicaoDaAreaDeAtuacaoX = gerarNumeroAleatorioNoIntervalo(5, 8);
		}
	}

	public void gerarAreaAtuacao() {
		int cont = 1;
		for (int j = posicaoDaAreaDeAtuacaoY; j < 15; j++) {
			for (int i = posicaoDaAreaDeAtuacaoX; i > 1; i--) {

				if (i == posicaoDaAreaDeAtuacaoX && j == posicaoDaAreaDeAtuacaoY) {
					gol[posicaoDaAreaDeAtuacaoX][posicaoDaAreaDeAtuacaoY].setTipo(atuacao);
				} else if ((i > posicaoDaAreaDeAtuacaoX - 4) && (j < posicaoDaAreaDeAtuacaoY + 4)) {
					if (goleiro.getAAG() > cont) {
						gol[i][j].setTipo(atuacao);
						cont++;
					}
				}
			}
		}
	}

	public String ResultadoDoChute() {
		if (gol[chute.getPosicaoDoChuteX()][chute.getPosicaoDoChuteY()].getTipo().equals(atuacao)) {
			goleiro.defenderGol();
			goleiro.AdicionarCobranca();
			return "Goleiro pegou";
		} else if (gol[chute.getPosicaoDoChuteX()][chute.getPosicaoDoChuteY()].getTipo().equals(dentro)) {
			goleiro.levarGol();
			goleiro.AdicionarCobranca();
			return "Gol";
		} else if (gol[chute.getPosicaoDoChuteX()][chute.getPosicaoDoChuteY()].getTipo().equals(trave)) {
			goleiro.AdicionarCobranca();
			goleiro.chutePegouNaTrave();
			return "Trave";
		} else if (gol[chute.getPosicaoDoChuteX()][chute.getPosicaoDoChuteY()].getTipo().equals(gaveta)) {
			goleiro.levarGol();
			goleiro.AdicionarCobranca();
			return gaveta;
		} else {
			goleiro.AdicionarCobranca();
			goleiro.chuteParaFora();
			return fora;
		}
	}

	public int gerarNumeroAleatorioNoIntervalo(int primeiro, int ultimo) {
		Random rand = new Random();
		int numero;
		numero = primeiro + rand.nextInt((ultimo - primeiro) + 1);
		return numero;
	}

	public Celula[][] getGol() {
		return gol;
	}

	public Goleiro getGoleiro() {
		return goleiro;
	}

	public Chute getChute() {
		return chute;
	}

	public int getPosicaoDaAreaDeAtuacaoX() {
		return posicaoDaAreaDeAtuacaoX;
	}

	public int getPosicaoDaAreaDeAtuacaoY() {
		return posicaoDaAreaDeAtuacaoY;
	}

}
