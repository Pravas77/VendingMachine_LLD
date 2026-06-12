import java.util.*;

public class SelectState implements MachineState {
    private VendingMachine vendingMachine;

    public SelectState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
        System.out.println("Vending machine is in Selectstate now");
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
        List<Coin> insertions = new ArrayList<>(vendingMachine.getInsertions());
        vendingMachine.getInsertions().clear();
        vendingMachine.setMachineState(new IdleState(vendingMachine));
        return insertions;
    }

    @Override
    public void proceedToProductSelection() {
        throw new RuntimeException("Requested operation is not allowed at this state");

    }

    @Override
    public List<Coin> selectProduct(int itemId) {

        Item item = findItemById(itemId);
        int totalPaidAmount = 0;
        for (Coin coin : vendingMachine.getInsertions()) totalPaidAmount += coin.getValue();
        if (totalPaidAmount < item.getPrice() || vendingMachine.getItemCount().getOrDefault(item, 0) == 0)
            return getfullRefund();

        try {
            return getChange(totalPaidAmount - item.getPrice());
        } catch (RuntimeException e) {
            System.out.println("Change is not available");
            return getfullRefund();
        }

    }

    @Override
    public Item dispatch(int itemId) {
        throw new RuntimeException("Requested operation is not allowed at this state");
    }

    private List<Coin> getChange(int extra) {

        Map<Coin, Integer> coinCount = vendingMachine.getCoinCount();
        List<Coin> insertions = vendingMachine.getInsertions();


        Map<Coin, Integer> adjustedCoinCount = new TreeMap<>((a, b) -> b.getValue() - a.getValue());
        List<Coin> adjustedInsertions = new ArrayList<>();

        for (Map.Entry<Coin, Integer> val : coinCount.entrySet()) {
            adjustedCoinCount.put(val.getKey(), val.getValue());
        }

        for (Coin coin : insertions) {
            Integer count = adjustedCoinCount.getOrDefault(coin, 0);
            adjustedCoinCount.put(coin, count + 1);
        }


        for (Map.Entry<Coin, Integer> val : adjustedCoinCount.entrySet()) {
            Coin key = val.getKey();
            int value = val.getValue();
            int count = Math.min(value, extra / key.getValue());
            val.setValue(value - count);
            extra -= count * key.getValue();
            for (int i = 1; i <= count; i++) adjustedInsertions.add(key);
        }


        if (extra == 0) {
            vendingMachine.getInsertions().clear();
            vendingMachine.setCoinCount(adjustedCoinCount);
            vendingMachine.setMachineState(new DispatchState(vendingMachine));
            return adjustedInsertions;
        } else throw new RuntimeException("Change is not available");
    }


    private Item findItemById(int itemId) {
        Map<Item, Integer> itemCount = vendingMachine.getItemCount();
        for (Map.Entry<Item, Integer> val : itemCount.entrySet()) {
            if (val.getKey().getId() == itemId) return val.getKey();
        }
        return null;
    }
}
