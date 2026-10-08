import java.util.ArrayList;
import java.util.List;

public class PaymentState extends MachineState {

    public PaymentState() {
        System.out.println("Vending machine is in PaymentState now");
    }

    public void insertCoin(VendingMachine vendingMachine, Coin coin) {
        vendingMachine.getInsertions().add(coin);
    }

    public List<Coin> getFullRefund(VendingMachine vendingMachine) {
        List<Coin> insertions = new ArrayList<>(vendingMachine.getInsertions());
        vendingMachine.getInsertions().clear();
        vendingMachine.setMachineState(new IdleState());
        return insertions;
    }

    public void proceedToItemSelectionState(VendingMachine vendingMachine) {
        vendingMachine.setMachineState(new ItemSelectionState());
    }

}