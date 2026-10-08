import java.util.Map;

public class ItemDispatchState extends MachineState {

    public ItemDispatchState() {
        System.out.println("Vending machine is in ItemDispatchState now");
    }

    public Item dispatchItem(VendingMachine vendingMachine) {

        Item desiredItem = vendingMachine.getDesiredItem();
        Map<Item, Integer> itemCount = vendingMachine.getItemCount();

        int value = itemCount.get(desiredItem);
        itemCount.put(desiredItem, value - 1);
        vendingMachine.setDesiredItem(null);

        vendingMachine.setMachineState(new IdleState());
        return desiredItem;

    }
}
