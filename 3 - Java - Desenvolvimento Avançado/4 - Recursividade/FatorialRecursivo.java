public class FatorialRecursivo {
    public static void main(String[] args) {
        System.out.println(FatRec(6));
    }

    public static long FatRec(long valor){
        if(valor == 1){
            return 1;
        }
        return valor * FatRec(--valor);
    }
}
