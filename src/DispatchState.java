import java.util.List;
import java.util.Map;

public class DispatchState implements MachineState {
    VendingMachine vendingMachine;

    public DispatchState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
        System.out.println("Vending machine is in DispatchState now");
    }

    @Override
    public void proceedWithPayment() {
        throw new RuntimeException("Requested operation is not allowed at this state");

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
        Item item = findItemById(itemId);
        Map<Item, Integer> itemCount = vendingMachine.getItemCount();
        int value = itemCount.get(item);
        itemCount.put(item, value - 1);
        vendingMachine.setMachineState(new IdleState(vendingMachine));
        return item;

    }

    private Item findItemById(int itemId) {
        Map<Item, Integer> itemCount = vendingMachine.getItemCount();
        for (Map.Entry<Item, Integer> val : itemCount.entrySet()) {
            if (val.getKey().getId() == itemId) return val.getKey();
        }
        return null;
    }

}
