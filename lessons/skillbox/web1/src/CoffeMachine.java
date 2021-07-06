public class CoffeMachine {

    private int[] prices;
    private String[] names;

    public CoffeMachine(int[] drinkPrices, String[] drinkNames) {
        prices = drinkPrices;
        names = drinkNames;
    }
}

//    public void checkPrice (int moneyAmount) {
//        boolean canBuy = false;
//
//        for (int i = 0; i < prices.length; i++) {
//            if (moneyAmount >= prices [i]) {
//                System.out.println("Вы можете купить " + names[i]);
//                canBuy = true;
//            }
//        }

//}
