package regrasDeNegocio;

import java.util.ArrayList;

public class main {

	public static void main(String[] args) {

		Goleiro alisson = new Goleiro(1, "Alisson", 10, 5, 10, 4, 3, 10);
		Goleiro santos = new Goleiro(2, "Santos", 10, 10, 10, 8, 10, 9);

		Chute chute = new Chute(1, 10, 1, 2, 2);
		Chute chute2 = new Chute(2, 7, 1, 3, 6);
		Chute chute3 = new Chute(3, 8, 2, 4, 15);
		Chute chute4 = new Chute(4, 4, 4, 6, 11);
		Cobranca cobranca = new Cobranca(alisson, chute);
		System.out.println("Resultado: " + cobranca.ResultadoDoChute());
		Cobranca cobranca2 = new Cobranca(alisson, chute2);
		System.out.println("Resultado: " + cobranca2.ResultadoDoChute());
		Cobranca cobranca3 = new Cobranca(alisson, chute3);
		System.out.println("Resultado: " + cobranca3.ResultadoDoChute());
		Cobranca cobranca4 = new Cobranca(alisson, chute4);
		System.out.println("Resultado: " + cobranca4.ResultadoDoChute());
		Cobranca cobranca5 = new Cobranca(santos, chute);
		System.out.println("Resultado: " + cobranca5.ResultadoDoChute());
		Cobranca cobranca6 = new Cobranca(santos, chute2);
		System.out.println("Resultado: " + cobranca6.ResultadoDoChute());
		Cobranca cobranca7 = new Cobranca(santos, chute3);
		System.out.println("Resultado: " + cobranca7.ResultadoDoChute());
		Cobranca cobranca8 = new Cobranca(santos, chute4);
		System.out.println("Resultado: " + cobranca8.ResultadoDoChute());

		Selecao brazil = new Selecao("Brasil");
		brazil.adicionarGoleiros(alisson);
		brazil.adicionarGoleiros(santos);
		System.out.println("\n\n");

		// 1*
		System.out.println("Média de chutes pegos pelos goleiros do " + brazil.getNomeDaSelecao() + ": "
				+ brazil.mediaDeChutesPegos());
		System.out.println("Média de chutes para fora nos goleiros do " + brazil.getNomeDaSelecao() + ": "
				+ brazil.mediaDeChutesParaFora());
		System.out.println("Média de chutes na trave nos goleiros do " + brazil.getNomeDaSelecao() + ": "
				+ brazil.mediaDeChutesNaTrave());

		// 3*
		System.out.println("Média de gols tomados pelos goleiros do " + brazil.getNomeDaSelecao() + ": "
				+ brazil.mediaDeGolsTomados());

		// 2*
		System.out.println("Goleiro Indicado do " + brazil.getNomeDaSelecao() + ": " + brazil.goleiroIndicado());

		// 8*
		System.out.println(brazil);

		System.out.println("Tamanho da área de atuação: " + alisson.getAAG());
		System.out.println("Quadrante: " + cobranca.getChute().getQuadrante());
		System.out
				.println("Posição do chute X - Y: " + chute.getPosicaoDoChuteX() + " - " + chute.getPosicaoDoChuteY());
		System.out.println("Posição inicial área atuação X - Y: " + cobranca.getPosicaoDaAreaDeAtuacaoX() + " - "
				+ cobranca.getPosicaoDaAreaDeAtuacaoY());
		System.out.println("Resultado: " + cobranca.ResultadoDoChute());
		System.out.println("\n\n");

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 17; j++) {
				System.out.print(cobranca.getGol()[i][j].getTipo() + " " + i + "-" + j + " ");
			}
			System.out.print("\n");
		}
	}
}
