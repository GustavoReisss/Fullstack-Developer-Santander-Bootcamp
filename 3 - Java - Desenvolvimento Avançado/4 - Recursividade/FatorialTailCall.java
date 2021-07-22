public class FatorialTailCall {
    public static void main(String[] args) {
        System.out.println(FatTailCall(5, 1)); // 1 == numero inicial
    }

    public static long FatTailCall(int num, long total){
        if(num == 0){
            return total;
        }
        return FatTailCall(num-1, total * num);
    }
}
