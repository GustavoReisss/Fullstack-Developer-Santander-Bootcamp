public class testeCarro {
    
    public static void main(String[] args) {
        Carro carrim = new Carro(3);

        System.out.println(carrim.removePassageiro());
        System.out.println(carrim);
        System.out.println(carrim.adicionaPassageiro());
        System.out.println(carrim);
        System.out.println(carrim.adicionaPassageiro());
        System.out.println(carrim);
        System.out.println(carrim.adicionaPassageiro());
        System.out.println(carrim);
        System.out.println(carrim.adicionaPassageiro());
        System.out.println("------------------");
        System.out.println(carrim.removePassageiro());
        System.out.println(carrim);
        System.out.println(carrim.removePassageiro());
        System.out.println(carrim);
        System.out.println(carrim.removePassageiro());
        System.out.println(carrim);
        System.out.println(carrim.removePassageiro());
    }
}
