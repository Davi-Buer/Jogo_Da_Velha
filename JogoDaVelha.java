import java.util.Random;
import java.util.Scanner;

class JogoDaVelha {

    private Jogador jogador1;
    private Jogador jogador2;
    private Tabuleiro tabuleiro;

    public JogoDaVelha(Jogador jogador1, Jogador jogador2, Tabuleiro tabuleiro) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.tabuleiro = tabuleiro;
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Escolha seu símbolo (X ou O): ");
        char simboloHumano = sc.next().toUpperCase().charAt(0);

        char simboloMaquina = (simboloHumano == 'X') ? 'O' : 'X';

        Jogador jogador1 = new Jogador(simboloHumano, "Humano");
        Jogador jogador2 = new Jogador(simboloMaquina, "Máquina");

        Tabuleiro tabuleiro = new Tabuleiro();

        JogoDaVelha jogoDaVelha = new JogoDaVelha(jogador1, jogador2, tabuleiro);
        jogoDaVelha.iniciar();
    }

    private void iniciar() {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int linha, coluna;
        boolean vezHumano = true;

        while (!tabuleiro.acabouOJogo()) {

            if (vezHumano) {
                System.out.println("\nVez do " + jogador1.getNome());

                while (true) {
                    System.out.print("Linha (0-2): ");
                    linha = sc.nextInt();

                    System.out.print("Coluna (0-2): ");
                    coluna = sc.nextInt();

                    if (tabuleiro.jogar(jogador1.getSimbolo(), linha, coluna)) {
                        break;
                    } else {
                        System.out.println("Jogada inválida! Tenta de novo.");
                    }
                }

            } else {
                System.out.println("\nVez da " + jogador2.getNome());

                do {
                    linha = random.nextInt(3);
                    coluna = random.nextInt(3);
                } while (!tabuleiro.jogar(jogador2.getSimbolo(), linha, coluna));
            }

            tabuleiro.mostrar();
            vezHumano = !vezHumano;
        }

        if (tabuleiro.haUmVencedor()) {
            if (!vezHumano) {
                System.out.println("O humano ganhou");
            } else {
                System.out.println("A máquina ganhou");
            }
        } else {
            System.out.println("O jogo terminou empatado.");
        }

        System.out.println("Criado por Davi Buer");
    }
}
