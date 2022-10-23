package regrasDeNegocio;

import java.util.Random;

public class Chute {

	private int id;
	private int forca;
	private int quadrante;
	private int posicaoDoChuteY;
	private int posicaoDoChuteX;

	public Chute(int id, int forca, int quadrante, int posicaoDoChuteX, int posicaoDoChuteY) {
		super();
		this.id = id;
		setForca(forca);
		setQuadrante(quadrante);
		setPosicaoDoChuteY(posicaoDoChuteY);
		setPosicaoDoChuteX(posicaoDoChuteX);

	}

	public int getForca() {
		return forca;
	}

	public void setForca(int forca) {
		if (forca >= 1 && forca <= 10) {
			this.forca = forca;
		}
	}

	public int getQuadrante() {
		return quadrante;
	}

	public void setQuadrante(int quadrante) {
		if (quadrante >= 1 && quadrante <= 4) {
			this.quadrante = quadrante;
		}
	}

	public int getPosicaoDoChuteY() {
		return posicaoDoChuteY;
	}

	public int getPosicaoDoChuteX() {
		return posicaoDoChuteX;
	}

	public int getId() {
		return id;
	}

	public void setPosicaoDoChuteY(int posicaoDoChuteY) {
		if (posicaoDoChuteY >= 0 && posicaoDoChuteY <= 16) {
			this.posicaoDoChuteY = posicaoDoChuteY;
		}
	}

	public void setPosicaoDoChuteX(int posicaoDoChuteX) {
		if (posicaoDoChuteX >= 0 && posicaoDoChuteX <= 8) {
			this.posicaoDoChuteX = posicaoDoChuteX;
		}
	}


	public void posicaoDoChute() {
		if (quadrante == 1) {
			posicaoDoChuteY = gerarNumeroAleatorioNoIntervalo(0, 7);
			posicaoDoChuteX = gerarNumeroAleatorioNoIntervalo(0, 4);
		} else if (quadrante == 2) {
			posicaoDoChuteY = gerarNumeroAleatorioNoIntervalo(8, 16);
			posicaoDoChuteX = gerarNumeroAleatorioNoIntervalo(0, 4);
		} else if (quadrante == 3) {
			posicaoDoChuteY = gerarNumeroAleatorioNoIntervalo(0, 7);
			posicaoDoChuteX = gerarNumeroAleatorioNoIntervalo(5, 8);
		} else if (quadrante == 4) {
			posicaoDoChuteY = gerarNumeroAleatorioNoIntervalo(8, 16);
			posicaoDoChuteX = gerarNumeroAleatorioNoIntervalo(5, 8);
		}
	}

	public int gerarNumeroAleatorioNoIntervalo(int primeiro, int ultimo) {
		Random rand = new Random();
		int numero;
		numero = primeiro + rand.nextInt((ultimo - primeiro) + 1);
		return numero;
	}

}
