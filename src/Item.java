public enum Item {
    PEPSI(10), LIMKA(15), COKE(20);

    private int cost;

    private Item(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
