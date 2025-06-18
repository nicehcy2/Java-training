package modernjavainaction.chap09;

public class TraditionalTemplateMethod extends  OnlineBanking {

    @Override
    void makeCustomerHappy(Customer c) {
        System.out.println("Hello, World");
    }

    public static void main(String[] args) {
        OnlineBanking t = new TraditionalTemplateMethod();
        t.processCustomer(1);
    }
}
