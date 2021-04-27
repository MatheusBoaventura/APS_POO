public class Labirinto {
    
    private static final int Vazio = '0';
    private static final int Parede = '1';
    private static final int tamanho = 20;
    private static char[][] Labirinto;
    private static final double Probabilidade = 0.7;
    private static final char Inicio = 'I';
    private static final char Final = 'F';
    private static int linhainicio;
    private static int colunainicio;
    private static int linhafinal;
    private static int colunafinal;

    //gerar numero 
    public static int gerarNumero(int minimo, int maximo){
        int valor = (int) Math.round(Math.random()*(maximo-minimo));
        return minimo+valor;
    }
    //iniciar labirinto
    public void iniciarLab(){
        
        Labirinto = new char [tamanho][tamanho];
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
    //Devolve linha inicio
    public int linhaInicio(){
        return linhainicio;
    }
    //Devolve coluna inicio
    public int colunainicio(){
        return colunainicio;
    }
    //imprimir labirinto
    public void imprimirLab(){
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
    
}
