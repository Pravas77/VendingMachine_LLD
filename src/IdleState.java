import java.util.List;

public class IdleState implements MachineState {
   private VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
        System.out.println("Vending machine is in idle state now");
    }

    @Override
    public void proceedWithPayment() {
       vendingMachine.setMachineState(new HasMoneyState(vendingMachine));
    }

    @Override
    public void insertCoin(Coin coin) {
        throw new RuntimeException("Requested operation is not allowed at this state");
    }

    @Override
    public List<Coin> getfullRefund() {
        throw new RuntimeException("Requested operation is not allowed at this state");
    }

    @Override
    public void proceedToProductSelection() {
        throw new RuntimeException("Requested operation is not allowed at this state");
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
