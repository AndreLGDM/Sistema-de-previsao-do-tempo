import java.util.Scanner;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;

public class trabalho1 {
	public static void main(String[] args) throws IOException, InterruptedException {

		Scanner leia = new Scanner(System.in);
		Random random = new Random();

		int Linha = 0;
		int Coluna = 0;
		String calendarioEstado[][] = new String[5][7];
		double calendarioTemp[][] = new double[5][7];
		int calendarioDia[][] = new int[5][7];
		String calendarioDiaString = "";
		String calendarioTempString = "";
		// int i e j são contadores
		int i, j;
		int primeiroDia = 0, espaco = 0, cont = 1, estado, semana = 0, contadorDias = 0;
		int max = 40;
		int min = 20;
		float media = 0;
		float somaTemp = 0;
		Double maior = Double.MIN_VALUE;
		Double maiorEnsolarado = Double.MIN_VALUE;
		int contNub = 0, contChu = 0, contSol = 0;
		float comparaSemanaMaisAlta = 0, semanaMaisAlta = 0;
		String fazer = " ";

		System.out.println("\033[1;33m" + " ===============================================\n"
				+ "|Bem vindo(a) ao sistema de Previsão do Tempo da|\n"
				+ "| 	Turma de Algoritmos e Programação.    	|\n"
				+ " ===============================================" + " \033[0m");

		System.out.println("\033[0;94m" + " by: Lauro Gomes dos Santos Neto." + "\033[0m ");
		System.out.println("\033[0;94m" + " by: Jose Guilherme Gonzalez Monteiro." + "\033[0m ");
		System.out.println("\033[0;94m" + " by: André Luiz Gomes de Medeiros." + "\033[0m ");
		Thread.sleep(5000);
		if (System.getProperty("os.name").contains("Windows"))
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

		// ================================================================
		// BLOCO 1) TESTE DE ENTRADA DO PRIMEIRO DIA
		do {

			do {
				try {
					System.out.println();
					System.out.println("1 - Domingo");
					System.out.println("2 - Segunda-Feira"); // aqui ele faz o teste para verificar se a
					System.out.println("3 - Terça-Feira"); // entrada do primeiro dia esta correta
					System.out.println("4 - Quarta-Feira");
					System.out.println("5 - Quinta-Feira");
					System.out.println("6 - Sexta-Feira");
					System.out.println("7 - Sábado");
					System.out.println();
					System.out.print("\033[0;32m" + "Digite o dia da semana que inicia o mês:" + " \033[0m");
					primeiroDia = leia.nextInt();
				} catch (InputMismatchException e) {
					System.out.println();
					System.out.print("\033[1;31m" + "O valor informado não é um número!" + " \033[0m\n");
				}
				leia.nextLine();
				if (primeiroDia < 1 || primeiroDia > 7) {
					System.out.print("\033[1;33m" + "Valor Invalido!" + " Digite novamente" + " \033[0m");
					Thread.sleep(2000);
					if (System.getProperty("os.name").contains("Windows"))
						new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				}
			} while (primeiroDia < 0);

		} while (primeiroDia < 1 || primeiroDia > 7);

		if (System.getProperty("os.name").contains("Windows"))
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		// ================================================================
		// BLOCO 2) CARREGANDO INFORMAÇÕES DO CALENDÁRIO NA MATRIZ
		// A PARTIR DO PRIMEIRO DIA DIGITADO PELO USUÁRIO

		for (i = 0; i < 5; i++) {
			for (j = 0; j < 7; j++) {
				if (espaco < primeiroDia - 1 || (cont > 31 && cont < 35)) {

					// calendarioDia[i][j]=0;
					// calendarioDiaString = " ";
					calendarioEstado[i][j] = "--";
					espaco++;

				} else {

					calendarioTemp[i][j] = random.nextDouble(Math.round(max - min)) + min;
					calendarioDia[i][j] = cont;
					estado = random.nextInt(4 - 1) + 1;
					contadorDias++;

					switch (estado) {
						case 1:
							calendarioEstado[i][j] = "nub";
							break;
						case 2:
							calendarioEstado[i][j] = "sol";
							break;
						case 3:
							calendarioEstado[i][j] = "chu";
							break;
					}

					cont++;
				}

			}
		}

		// ===================================================================
		// BLOCO 3) PRINT DO CALENDÁRIO E
		// TESTE DE ESTÉTICA DO CALENDÁRIO
		// PÕEM UM PEQUENO ESPAÇO NOS NÚMEROS MENORES QUE 10

		do {

			System.out.println(
					"\033[1;31m" + "===============================================================\n" + "\033[0m"
							+ "{  DOM  }{  SEG  }{  TER  }{  QUA  }{  QUI  }{  SEX  }{  SAB  }");
			for (i = 0; i < 5; i++) {
				for (j = 0; j < 7; j++) {
					if (calendarioDia[i][j] < 10) {
						calendarioDiaString = Integer.toString(calendarioDia[i][j]);
						if (calendarioDia[i][j] == 0) {
							calendarioDiaString = " ";
						}
						System.out.printf("{   %s   }", calendarioDiaString); // <== AQUI
					} else {
						calendarioDiaString = Integer.toString(calendarioDia[i][j]);
						System.out.printf("{  %s   }", calendarioDiaString); // <== E AQUI
					}
				}
				System.out.println(" ");
			}

			// ================================================================
			// BLOCO 4) PRINT MENU E IMPLEMENTAÇÃO DE SUAS FUNCIONALIDADES
			// DE ACORDO COM O VALOR DIGITADO PELO USUÁRIO

			System.out.println(
					"\033[1;31m" + "===============================================================\n" + " \033[0m");
			System.out.println("1 - Exibir o calendário informando as temperaturas");
			System.out.println("2 - Exibir o calendário informando a previsão do tempo");
			System.out.println("3 - Consultar a quantidade de dias ensolarados, nublados e chuvosos");
			System.out.println("4 - Consultar a maior temperatura do mês");
			System.out.println("5 - Consultar a semana mais quente do mês");
			System.out.println("6 - Consultar a temperatura média do mês");
			System.out.println("7 - Consultar o dia ensolarado mais quente do mês");
			System.out.println("0 - sair");
			System.out.println();
			System.out.print("\033[0;32m" + "O que deseja fazer ? " + " \033[0m");
			fazer = leia.nextLine();

			switch (fazer) {

				case "1":
					if (System.getProperty("os.name").contains("Windows"))
						new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
					System.out.println(
							"\033[1;31m" + "===============================================================\n"
									+ "\033[0m"
									+ "{   DOM    }{   SEG    }{   TER    }{   QUA    }{   QUI    }{   SEX    }{   SAB    }");
					for (i = 0; i < 5; i++) {
						for (j = 0; j < 7; j++) {
							if (calendarioDia[i][j] < 10) {
								calendarioTempString = Double.toString(calendarioTemp[i][j]);
								if (calendarioTemp[i][j] == 0.0) {
									calendarioTempString = "      ";
								}
								System.out.printf("{   %.4s   }", calendarioTempString);
							} else {
								calendarioTempString = Double.toString(calendarioTemp[i][j]);
								System.out.printf("{   %.1f   }", calendarioTemp[i][j]);
							}
						}
						System.out.println();
					}
					break;
				case "2":
					if (System.getProperty("os.name").contains("Windows"))
						new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
					System.out.println(
							"\033[1;31m" + "===============================================================\n"
									+ "\033[0m"
									+ "{  DOM  }{  SEG  }{  TER  }{  QUA  }{  QUI  }{  SEX  }{  SAB  }");
					for (i = 0; i < 5; i++) {
						for (j = 0; j < 7; j++) {
							if (calendarioTemp[i][j] < 10) {
								System.out.printf("{  %s   }", calendarioEstado[i][j]);
							} else {
								System.out.printf("{  %s  }", calendarioEstado[i][j]);

							}
						}
						System.out.println();
					}
					break;
				case "3":
					if (System.getProperty("os.name").contains("Windows"))
						new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
					for (i = 0; i < 5; i++) {
						for (j = 0; j < 7; j++) {
							switch (calendarioEstado[i][j]) {
								case "nub":
									contNub++;
									break;
								case "chu":
									contChu++;
									break;
								case "sol":
									contSol++;
									break;
							}
						}
					}
					System.out.printf(
							"\n\033[1;96m" + "%d dias Ensolarados\n%d dias Nublados\n%d dias Chuvosos\n" + " \033[0m",
							contSol, contNub, contChu);
					break;
				case "4":
					if (System.getProperty("os.name").contains("Windows"))
						new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
					for (i = 0; i < 5; i++) {
						for (j = 0; j < 7; j++) {
							if (calendarioTemp[i][j] > maior) {
								maior = (calendarioTemp[i][j]);
								Linha = i;
								Coluna = j;
							}
						}
					}
					System.out.print("A maior temperatura está no dia: " + calendarioDia[Linha][Coluna]);
					System.out.printf("\n\033[1;91m" + "A maior temperatura é: %.1f°C\n" + " \033[0m", maior);
					break;
				case "5":
					if (System.getProperty("os.name").contains("Windows"))
						new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
					for (i = 0; i < 5; i++) {
						for (j = 0; j < 7; j++) {
							comparaSemanaMaisAlta += calendarioTemp[i][j];
						}
						if (comparaSemanaMaisAlta > semanaMaisAlta) {
							semanaMaisAlta = comparaSemanaMaisAlta;
							semana = i;
						}
						comparaSemanaMaisAlta = 0;
					}
					semanaMaisAlta = semanaMaisAlta / 7;
					System.out.printf("\n\033[1;95m" + "A %d° semana é mais quente: %.1f°C\n" + " \033[0m", semana + 1,
							semanaMaisAlta);
					break;
				case "6":
					if (System.getProperty("os.name").contains("Windows"))
						new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
					for (i = 0; i < 5; i++) {
						for (j = 0; j < 7; j++) {
							somaTemp += calendarioTemp[i][j];

						}

					}
					media = somaTemp / contadorDias;
					somaTemp = 0;
					System.out.printf("\n\033[1;92m" + "A média da temperatura no mês foi: %.1f°C\n" + " \033[0m",
							media);
					break;
				case "7":
					if (System.getProperty("os.name").contains("Windows"))
						new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
					for (i = 0; i < 5; i++) {
						for (j = 0; j < 7; j++) {
							if (calendarioEstado[i][j].equals("sol")) {
								if (calendarioTemp[i][j] > maiorEnsolarado) {
									maiorEnsolarado = calendarioTemp[i][j];
									Linha = i;
									Coluna = j;
								}
							}
						}
					}
					System.out.print("O dia ensolarado mais quente é o dia: " + calendarioDia[Linha][Coluna]);
					System.out.printf("\n\033[1;93m" + "O dia ensolarado mais quente é: %.1f°C\n" + " \033[0m",
							maiorEnsolarado);
					break;
				case "0":
					if (System.getProperty("os.name").contains("Windows"))
						new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
					System.out.println("\n\033[1;97m" + "Visualização de informações do mês encerrada!" + "\n\033[0m");
					break;
				default:
					do {
						if (System.getProperty("os.name").contains("Windows"))
							new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
						System.out.println("\n\033[1;31m" + "Opção Inexistente!" + " \033[0m");
						System.out.println("");
						System.out.println("\033[0;94m" + "(1) Tentar novamente" + " \033[0m\n");
						System.out.println("\033[0;33m" + "(0) Fim" + " \033[0m");
						System.out.println("");
						System.out.print("\033[0;32m" + "Digite uma das opções existentes: " + " \033[0m");
						fazer = leia.nextLine();
						System.out.println();
					} while (!fazer.equals("1") && !fazer.equals("0"));
			}

		} while (!fazer.equals("0"));

		System.out.println("\033[1;96m" + "==================================================================\n"
				+ "|   Obrigado(a) por ter utilizado o sistema de Previsão do Tempo |\n"
				+ "|        	da  Turma de Algoritmos e Programação.           |\n"
				+ "==================================================================" + "\033[0m\n");
		Thread.sleep(7000);
		if (System.getProperty("os.name").contains("Windows"))
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	}
}
