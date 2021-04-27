public class Meliante {
    
    private static char[][] Labirinto;
    private static final int Vazio = '0';
    private static final char Final = 'F';
    private static char Rastro = 'X';
    private static char sem_saida = '#';
    //procurar caminho
    public boolean procurarCaminho(int linhaAtual, int colunaAtual){
        int proxLinha, proxColuna;
        boolean achou = false;

        // subir
        proxLinha = linhaAtual - 1;
        proxColuna = colunaAtual;
        achou = tentarCaminho(proxLinha, proxColuna);
        // descer
        if (!achou){
            proxLinha = linhaAtual + 1;
            proxColuna = colunaAtual;
            achou = tentarCaminho(proxLinha, proxColuna);
        }
        // esquerda
        if(!achou){
            proxLinha = linhaAtual;
            proxColuna = colunaAtual - 1;
            achou = tentarCaminho(proxLinha, proxColuna);
        }
        // direita
        if(!achou){
            proxLinha = linhaAtual;
            proxColuna = colunaAtual + 1;
            achou = tentarCaminho(proxLinha, proxColuna);
        }
        return achou;
    }
    //tentar caminho
    public boolean tentarCaminho(int proxLinha, int proxColuna){
        Labirinto labirinto = new Labirinto();
        boolean achou = false;
        if (Labirinto[proxLinha][proxColuna] == Final){
            achou = true;
        } else if(Labirinto[proxLinha][proxColuna] == Vazio){
            Labirinto[proxLinha][proxColuna] = Rastro;
            labirinto.imprimirLab();
            achou = procurarCaminho(proxLinha, proxColuna);
        if(!achou){
            Labirinto[proxLinha][proxColuna] = sem_saida;
            labirinto.imprimirLab();
            }
        }
        return achou;
    }
}
