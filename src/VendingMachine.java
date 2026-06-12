import java.util.*;

public class VendingMachine {
    private Map<Item,Integer> itemCount = new HashMap<>();
    private Map<Coin,Integer> coinCount = new TreeMap<>((a,b) -> b.getValue()-a.getValue());
    private List<Coin> insertions = new ArrayList<>();
    private MachineState machineState;

    public VendingMachine() {
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

    public MachineState getMachineState() {
        return machineState;
    }

    public void setMachineState(MachineState machineState) {
        this.machineState = machineState;
    }

    public void proceedWithPayment(){
        machineState.proceedWithPayment();
    }
    public void insertCoin(Coin coin){
        machineState.insertCoin(coin);
    }
    public List<Coin> getfullRefund(){
        return machineState.getfullRefund();
    }
    public void proceedToProductSelection(){
        machineState.proceedToProductSelection();
    }
    public List<Coin> selectProduct(int itemId){
        return machineState.selectProduct(itemId);
    }
    public Item dispatch(int itemId){
        return machineState.dispatch(itemId);
    }

    public void addCoin(Coin coin){
        int value = coinCount.getOrDefault(coin,0);
        coinCount.put(coin,value + 1);
    }

    public void addItem(Item item){
        int value = itemCount.getOrDefault(item,0);
        itemCount.put(item,value + 1);
    }
}
