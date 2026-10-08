import java.util.List;

public abstract class MachineState {

    public void proceedToPaymentState(VendingMachine vendingMachine) {
        System.out.println("Please select correct operation");
    }

    public void insertCoin(VendingMachine vendingMachine, Coin coin) {
        System.out.println("Please select correct operation");
    }

    public List<Coin> getFullRefund(VendingMachine vendingMachine) {
        System.out.println("Please select correct operation");
        return null;
    }

    public void proceedToItemSelectionState(VendingMachine vendingMachine) {
        System.out.println("Please select correct operation");
    }

    public List<Coin> selectItem(VendingMachine vendingMachine, Item item) {
        System.out.println("Please select correct operation");
        return null;
    }

    public Item dispatchItem(VendingMachine vendingMachine) {
        System.out.println("Please select correct operation");
        return null;
    }


}
