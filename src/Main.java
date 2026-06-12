import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello");

        Item item1 = new Item(1,ItemType.LIMKA,10);
        Item item2 = new Item(2,ItemType.COKE,10);

        Coin coin1 = new Coin(1);
        Coin coin2 = new Coin(2);
        Coin coin5 = new Coin(5);
        Coin coin10 = new Coin(10);

        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.addCoin(coin1);
        vendingMachine.addCoin(coin2);


        vendingMachine.addItem(item1);
        vendingMachine.addItem(item2);

        vendingMachine.setMachineState(new IdleState(vendingMachine));

        // client
        vendingMachine.proceedWithPayment();
        vendingMachine.insertCoin(coin5);
        vendingMachine.insertCoin(coin2);
        vendingMachine.insertCoin(coin2);
        vendingMachine.insertCoin(coin2);

        vendingMachine.proceedToProductSelection();

        List<Coin> coins1 = vendingMachine.selectProduct(1);
        System.out.print("Returned change : ");
        for (Coin coin : coins1) System.out.print(coin.getValue() + " ");
        System.out.println();

        Item item11 = vendingMachine.dispatch(1);
        System.out.print("Dispatched item id: ");
        System.out.println(item11.getId());



        vendingMachine.proceedWithPayment();
        vendingMachine.insertCoin(coin5);
        vendingMachine.insertCoin(coin2);
        vendingMachine.insertCoin(coin2);
        vendingMachine.insertCoin(coin1);

        vendingMachine.proceedToProductSelection();

        List<Coin> coins2 = vendingMachine.selectProduct(2);
        System.out.print("Returned change : ");
        for (Coin coin : coins2) System.out.print(coin.getValue() + " ");
        System.out.println();

        Item item12 = vendingMachine.dispatch(2);
        System.out.print("Dispatched item id: ");
        System.out.println(item12.getId());




    }
}