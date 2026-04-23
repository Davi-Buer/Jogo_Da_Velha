import java.util.Random;
import java.util.Scanner;

class JogoDaVelha
{
    private Jogador jogador1;
    private Jogador jogador2;
    private Tabuleiro tabuleiro;

    public JogoDaVelha(Jogador jogador1, Jogador jogador2, Tabuleiro tabuleiro)
    {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.tabuleiro = tabuleiro;
    }

    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Escolha seu símbolo (X ou O): ");
        char simboloHumano = scanner.next().toUpperCase().charAt(0);

        char simboloMaquina = (simboloHumano == 'X') ? 'O' : 'X';

        Jogador jogador1 = new Jogador(simboloHumano);
        Jogador jogador2 = new Jogador(simboloMaquina);

        Tabuleiro tabuleiro = new Tabuleiro();

        JogoDaVelha jogoDaVelha = new JogoDaVelha(jogador1, jogador2, tabuleiro);
        jogoDaVelha.iniciar();
    }

    private void iniciar()
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int linha, coluna;
        int partida = 1;

        while (!this.tabuleiro.acabouOJogo())
        {
            System.out.println("Partida " + partida);

            // Jogador humano
            System.out.println("Jogador 1 (Humano) joga:");
            do {
                System.out.print("Digite linha (0-2): ");
                linha = scanner.nextInt();
                System.out.print("Digite coluna (0-2): ");
                coluna = scanner.nextInt();
            }
            while (!this.tabuleiro.jogar(this.jogador1.getSimbolo(), linha, coluna));

            if (this.tabuleiro.acabouOJogo())
                break;

            // Jogador máquina
            System.out.println("Jogador 2 (Máquina) joga:");
            do {
                linha = random.nextInt(0,3);
                coluna = random.nextInt(0,3);
            }
            while (!this.tabuleiro.jogar(this.jogador2.getSimbolo(), linha, coluna));

            partida++;
        }

        // Resultado final
        if (this.tabuleiro.haUmVencedor()) {
            if (partida % 2 == 1) {
                System.out.println("O jogador 1 ganhou");
            } else {
                System.out.println("O jogador 2 ganhou");
            }
        } else {
            System.out.println("O jogo terminou empatado.");
        }

        System.out.println("Criado por Davi Benite Buer");
    }
}
