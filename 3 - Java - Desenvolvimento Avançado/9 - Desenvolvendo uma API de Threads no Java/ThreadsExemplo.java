// A classe main é a thread main, ela é executada paralelamente as demais threads criadas,
// no código foram criadas mais 2 threads para serem executadas junto da thread main, ao
// verificarmos o código podemos observar que as threads criadas possuem o método .sleep que 
// para a execução da thread por um tempo determinado. Sendo assim ambas as threads receberam 
// tempos diferentes neste método, a thread1 recebeu 4000ms (4s) no método sleep, e a thread2 
// recebeu 2000ms (2s).
// Ao executarmos o código podemos observar que ambas as threads 1 e 2 quanto a thread main
// estão sendo executadas ao mesmo tempo, pois mesmo a thread1 sendo executada primeira os
// comandos são executadas depois da thread2, já que a thread2 possui um menor número no método
// sleep, além disso a thread main não possui nenhum método que a faça aguardar algum tempo,
// então os prints que estão depois do inicio das threads no método main são imprimidos na tela
// primeiro que os prints que estão dentro das threads. 

public class ThreadsExemplo {
    
    public static void main(String[] args) {
        Thread thread1 = new Thread(new BarraDeCarregamento1());
        Thread thread2 = new Thread(new BarraDeCarregamento2());

        thread1.start();
        thread2.start();

        System.out.println("Nome da thread: " + thread1.getName());
        System.out.println("Nome da thread: " + thread2.getName());

    }
}

class BarraDeCarregamento1 implements Runnable {
    public void run() {

        try {
            Thread.sleep(4000);
            System.out.println("rodei BarraDeCarregamento2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class BarraDeCarregamento2 implements Runnable {
    public void run() {

        try {
            Thread.sleep(2000);
            System.out.println("rodei BarraDeCarregamento3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}