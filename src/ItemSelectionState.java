import java.util.*;

public class ItemSelectionState extends MachineState {

    public ItemSelectionState() {
        System.out.println("Vending machine is in ItemSelectionState now");
    }

    public List<Coin> getFullRefund(VendingMachine vendingMachine) {
        List<Coin> insertions = new ArrayList<>(vendingMachine.getInsertions());
        vendingMachine.getInsertions().clear();
        vendingMachine.setMachineState(new IdleState());
        return insertions;
    }

    public List<Coin> selectItem(VendingMachine vendingMachine, Item item) {

        int totalPaidAmount = 0;
        for (Coin coin : vendingMachine.getInsertions()) totalPaidAmount += coin.getValue();
        if (totalPaidAmount < item.getCost() || vendingMachine.getItemCount().getOrDefault(item, 0) == 0) {
            return getFullRefund(vendingMachine);
        }

        int extra = totalPaidAmount - item.getCost();
        List<Coin> refundList = getChange(vendingMachine, extra);

        if (refundList != null) {
            vendingMachine.setDesiredItem(item);
            vendingMachine.setMachineState(new ItemDispatchState());
            return refundList;
        } else return getFullRefund(vendingMachine);
    }

    private List<Coin> getChange(VendingMachine vendingMachine, int extra) {

        Map<Coin, Integer> coinCount = vendingMachine.getCoinCount();
        List<Coin> insertions = vendingMachine.getInsertions();


        Map<Coin, Integer> totalMoneyMap = new TreeMap<>((a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<Coin, Integer> val : coinCount.entrySet()) {
            totalMoneyMap.put(val.getKey(), val.getValue());
        }

        for (Coin coin : insertions) {
            int count = totalMoneyMap.getOrDefault(coin, 0);
            totalMoneyMap.put(coin, count + 1);
        }


        List<Coin> refundList = new ArrayList<>();
        for (Map.Entry<Coin, Integer> val : totalMoneyMap.entrySet()) {
            Coin key = val.getKey();
            int value = val.getValue();
            int count = Math.min(value, extra / key.getValue());

            val.setValue(value - count);
            extra -= count * key.getValue();
            for (int i = 1; i <= count; i++) refundList.add(key);
        }


        if (extra == 0) {
            vendingMachine.getInsertions().clear();
            vendingMachine.setCoinCount(totalMoneyMap);
            return refundList;
        } else {
            return null;
        }
    }
}