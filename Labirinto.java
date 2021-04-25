import java.util.Random;
public class Labirinto{
    
    private static final int Vazio = '0';
    private static final int Parede = '1';
    private static final double Probabilidade = 0.7;
    private static final char Inicio = 'I';
    private static final char Final = 'F';

    public Labirinto(){
        this.ImprimirLab();
    }
    //Imprimindo o Lab
    public static void ImprimirLab() {
        
        char Lab[][] = new char [20][20];
        Lab [1][0] = Inicio;
        Lab [19][19] = Final;
        
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
    }
    //main
    public static void main(String[] args) {
        int Lab[][] = new int[20][20];
        ImprimirLab();
    }

}
