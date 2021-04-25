import java.util.Random;
public class Labirinto{
    
    private static final int Vazio = '0';
    private static final int Parede = '1';
    private static final int tamanho = 20;
    private static char[][] Labirinto;
    private static final double Probabilidade = 0.7;
    private static final char Inicio = 'I';
    private static final char Final = 'F';
    private static char Rastro = 'X';
    private static char sem_saida = '#';
    private static int linhainicio;
    private static int colunainicio;
    private static int linhafinal;
    private static int colunafinal;

    //procurar caminho
    public static boolean procurarCaminho(int linhaAtual, int colunaAtual){
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
    public static boolean tentarCaminho(int proxLinha, int proxColuna){
        boolean achou = false;
        if (Labirinto[proxLinha][proxColuna] == Final){
            achou = true;
        } else if(Labirinto[proxLinha][proxColuna] == Vazio){
            Labirinto[proxLinha][proxColuna] = Rastro;
            imprimirLab();
            achou = procurarCaminho(proxLinha, proxColuna);
        if(!achou){
            Labirinto[proxLinha][proxColuna] = sem_saida;
            imprimirLab();
            }
        }
        return achou;
    }
    
    //gerar numero 
    public static int gerarNumero(int minimo, int maximo){
        int valor = (int) Math.round(Math.random()*(maximo-minimo));
        return minimo+valor;
    }
    //iniciar labirinto
    public static void iniciarLab(){
        for (int i=0; i < tamanho; i++){

        }
            for(int i=1; i<tamanho-1; i++){
                for (int j = 1; j<tamanho-1; j++){
                    if(Math.random() > Probabilidade){
                        Labirinto[i][j] = Parede;
                    }else{
                        Labirinto[i][j] = Vazio;
                    }
                }
            }
            linhainicio = gerarNumero(1, tamanho/2-1);
            colunainicio = gerarNumero(1, tamanho/2-1);
            Labirinto[linhainicio][colunainicio] = Inicio;
            linhafinal = gerarNumero(tamanho/2 , tamanho-2);
            colunafinal = gerarNumero(tamanho/2, tamanho-2);
            Labirinto[linhafinal][colunafinal] = Final;
    }
    //
    //imprimir labirinto
    public static void imprimirLab(){
        for (int i=0; i<tamanho; i++){
            for (int j=0; j<tamanho; j++){
                System.out.print(Labirinto[i][j] + " ");
            }
            System.out.println();
        }
        try{
            Thread.sleep(300);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    //main
    public static void main(String arg[]){
        Labirinto = new char [tamanho][tamanho];
        iniciarLab();
        imprimirLab();
        System.out.println("\n procurando solucao \n");
        boolean achou = procurarCaminho(linhainicio, colunainicio);
        if(achou){
            System.out.println("achou caminho");
        } else {
            System.out.println("não tem caminho");
        }
        
    }
    
}
