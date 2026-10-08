public class IdleState extends MachineState {

    public IdleState() {
        System.out.println("Vending machine is in IdleState now");
    }

    public void proceedToPaymentState(VendingMachine vendingMachine) {
        vendingMachine.setMachineState(new PaymentState());
    }

}
