import java.util.ArrayList;
import java.util.List;

public class HasMoneyState implements MachineState{
    private VendingMachine vendingMachine;

    public HasMoneyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
        System.out.println("Vending machine is in hasMoney state now");
    }

    @Override
    public void proceedWithPayment() {
        throw new RuntimeException("Requested operation is not allowed at this state");
    }

    @Override
    public void insertCoin(Coin coin) {
      vendingMachine.getInsertions().add(coin);

    }

    @Override
    public List<Coin> getfullRefund() {
        List<Coin> insertions = new ArrayList<>(vendingMachine.getInsertions());
        vendingMachine.getInsertions().clear();
        vendingMachine.setMachineState(new IdleState(vendingMachine));
        return insertions;

    }

    @Override
    public void proceedToProductSelection() {
        vendingMachine.setMachineState(new SelectState(vendingMachine));

    }

    @Override
    public List<Coin> selectProduct(int itemId) {
        throw new RuntimeException("Requested operation is not allowed at this state");
    }

    @Override
    public Item dispatch(int itemId) {
        throw new RuntimeException("Requested operation is not allowed at this state");
    }
}
