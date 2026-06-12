import java.util.List;

public interface MachineState {

    public void proceedWithPayment();
    public void insertCoin(Coin coin);
    public List<Coin> getfullRefund();
    public void proceedToProductSelection();
    public List<Coin> selectProduct(int itemId);
    public Item dispatch(int itemId);


}
