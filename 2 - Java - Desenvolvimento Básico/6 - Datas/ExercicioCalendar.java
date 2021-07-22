// Um cliente tem 10 dias para pagar uma fatura após sua data de vencimento
// sem que os juros sejam cobrados.
//
// Caso essa data caia em um sábado ou domingo, o cliente pode pagar na
// segunda-feira seguinte.
//
// Crie uma estrutura que receba uma data de vencimento e calcule quantos
// dias ele tem para pagar.

import java.util.Calendar;
import java.util.Scanner;

public class ExercicioCalendar {

    public static void main(String[] args) {
        Calendar dataVencimento = Calendar.getInstance();
        Calendar dataLimite;
        Scanner scan = new Scanner(System.in);
        int ano, mes, dia;
        int diaDaSemana;

        System.out.print("Digite o número do ano de vencimento: ");
        ano = scan.nextInt();
        System.out.print("Digite o número do mês de vencimento (1-12): ");
        mes = scan.nextInt() - 1; // janeiro == 0 | dezembro == 11
        System.out.print("Digite o número do dia de vencimento: ");
        dia = scan.nextInt();
        scan.close();
        dataVencimento.set(ano, mes, dia);
        dataLimite = (Calendar) dataVencimento.clone();
        dataLimite.add(Calendar.DATE, 10);
        
        diaDaSemana = dataLimite.get(Calendar.DAY_OF_WEEK);

        if(diaDaSemana == 1){
            dataLimite.add(Calendar.DATE, 1);
        } else if (diaDaSemana == 7){
            dataLimite.add(Calendar.DATE, 2);
        }
        
        System.out.printf("\nSua data de vencimento: %tF\n", dataVencimento);
        System.out.printf("Prazo final para pagar a fatura sem juros: %tF\n", dataLimite);
    }
}