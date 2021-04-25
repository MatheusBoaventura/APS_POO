import java.util.Random;
public class Labirinto{
    
    private static final int Vazio = '0';
    private static final int Parede = '1';
    private static final double Probabilidade = 0.7;
    private static final char Inicio = 'I';
    private static final char Final = 'F';
    private static final char Rastro = 'X';
    private static int linhainicio;
    private static int colunainicio;
    private static int linhafinal;
    private static int colunafinal;
    
    //gerar numero
    public static int gerarNumero(int minimo, int maximo){
        int valor = (int) Math.round(Math.random()*(maximo - minimo));

        return minimo + valor;
    }
    //Imprimindo o Lab
    public static void ImprimirLab() {
        
        char Lab[][] = new char [20][20];
        
        for (int i = 0; i < Lab.length; i++) {
                System.out.println();
            for (int j = 0; j < Lab.length; j++) {
                if (Math.random() > Probabilidade){  //paredes aleatorias  SHOW!!
                    Lab[i][j] = Parede;
                }else{
                    Lab[i][j] = Vazio;
            }
                System.out.print(Lab[i][j] + " ");
            
            }
        }
        linhainicio = gerarNumero(1, Lab.length/2-1);
        colunainicio = gerarNumero(1, Lab.length/2-1);
        Lab[linhainicio][colunainicio] = Inicio;
        linhafinal = gerarNumero(Lab.length/2, Lab.length-2);
        colunafinal = gerarNumero(Lab.length/2, Lab.length-2);
        Lab[linhafinal][colunafinal] = Final;
    }
    //PROCURAR O CAMINHO
    
    //TESTAR O CAMINHO
    
    
    
    //main
    public static void main(String[] args) {
        ImprimirLab();
        
    }

}
