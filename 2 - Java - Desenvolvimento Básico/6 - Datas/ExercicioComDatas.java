// Descubra o timeInMillis do dia que você nasceu
// Converta em um objeto Date
// Verifique se ele é anterior ou posterior a 15 de maio de 2010

import java.util.Date;

public class ExercicioComDatas {

    public static void main(String[] args) {
        Date nascimento = new Date(1020481200000L); // 04/05/2002   
        Date maio15de2010 = new Date(1273892400000L); // 15/05/2010

        System.out.println(nascimento);
        System.out.println(maio15de2010);
        
        System.out.println(nascimento.compareTo(maio15de2010)); // -1 == anterior
    }
}