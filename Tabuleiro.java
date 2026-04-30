class Tabuleiro {
    private char[][] casas = new char[3][3];

    public Tabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                casas[i][j] = ' ';
            }
        }
    }

    public boolean jogar(char simbolo, int linha, int coluna) {
        if (casas[linha][coluna] == ' ') {
            casas[linha][coluna] = simbolo;
            return true;
        }
        return false;
    }

    public boolean acabouOJogo() {
        return todasAsCasasPreenchidas() || haUmVencedor();
    }

    public boolean todasAsCasasPreenchidas() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (casas[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean haUmVencedor() {
        for (int i = 0; i < 3; i++) {
            if (casas[i][0] != ' ' && casas[i][0] == casas[i][1] && casas[i][1] == casas[i][2]) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (casas[0][i] != ' ' && casas[0][i] == casas[1][i] && casas[1][i] == casas[2][i]) {
                return true;
            }
        }

        if (casas[0][0] != ' ' && casas[0][0] == casas[1][1] && casas[1][1] == casas[2][2]) {
            return true;
        }

        if (casas[0][2] != ' ' && casas[0][2] == casas[1][1] && casas[1][1] == casas[2][0]) {
            return true;
        }

        return false;
    }

    public void mostrar() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(casas[i][j] + " ");
            }
            System.out.println();
        }
    }
}