import java.util.*;

public class VendingMachine {
    private MachineState machineState;
    private Map<Item, Integer> itemCount;
    private Map<Coin, Integer> coinCount;
    private List<Coin> insertions;
    private Item desiredItem;

    public VendingMachine(Map<Item, Integer> itemCount, Map<Coin, Integer> coinCount) {
        this.machineState = new IdleState();
        this.itemCount = itemCount;
        this.coinCount = coinCount;
        this.insertions = new ArrayList<>();
        this.desiredItem = null;
    }

    public Map<Item, Integer> getItemCount() {
        return itemCount;
    }

    public void setItemCount(Map<Item, Integer> itemCount) {
        this.itemCount = itemCount;
    }

    public Map<Coin, Integer> getCoinCount() {
        return coinCount;
    }

    public void setCoinCount(Map<Coin, Integer> coinCount) {
        this.coinCount = coinCount;
    }

    public List<Coin> getInsertions() {
        return insertions;
    }

    public void setInsertions(List<Coin> insertions) {
        this.insertions = insertions;
    }

    public Item getDesiredItem() {
        return desiredItem;
    }

    public void setDesiredItem(Item desiredItem) {
        this.desiredItem = desiredItem;
    }

    public MachineState getMachineState() {
        return machineState;
    }

    public void setMachineState(MachineState machineState) {
        this.machineState = machineState;
    }


    public void proceedToPaymentState() {
        machineState.proceedToPaymentState(this);
    }

    public void insertCoin(Coin coin) {
        machineState.insertCoin(this, coin);
    }

    public List<Coin> getFullRefund() {
        return machineState.getFullRefund(this);
    }

    public void proceedToItemSelectionState() {
        machineState.proceedToItemSelectionState(this);
    }

    public List<Coin> selectItem(Item item) {
        return machineState.selectItem(this, item);
    }

    public Item dispatchItem() {
        return machineState.dispatchItem(this);
    }

}
