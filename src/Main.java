import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello");

        VendingMachine vendingMachine = new VendingMachine(new HashMap<>(Map.of(Item.PEPSI, 2)), Map.of(Coin.ONE, 1));


        vendingMachine.proceedToPaymentState();
        vendingMachine.insertCoin(Coin.FIVE);
        vendingMachine.insertCoin(Coin.TWO);
        vendingMachine.insertCoin(Coin.TWO);
        vendingMachine.insertCoin(Coin.TWO);
        vendingMachine.proceedToItemSelectionState();
        System.out.println("Refund list : " + vendingMachine.selectItem(Item.PEPSI));
        System.out.println("Dispatched product : " + vendingMachine.dispatchItem());


        System.out.println("2nd run");
        vendingMachine.proceedToPaymentState();
        vendingMachine.insertCoin(Coin.FIVE);
        vendingMachine.insertCoin(Coin.TWO);
        vendingMachine.insertCoin(Coin.TWO);
        vendingMachine.insertCoin(Coin.TWO);
        vendingMachine.proceedToItemSelectionState();
        System.out.println("Refund list : " + vendingMachine.selectItem(Item.PEPSI));
        System.out.println("Dispatched product : " + vendingMachine.dispatchItem());


    }
}