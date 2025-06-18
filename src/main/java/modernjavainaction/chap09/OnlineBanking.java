package modernjavainaction.chap09;

public abstract class OnlineBanking {

    public void processCustomer(int id) {
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy(c);
    }
    abstract void makeCustomerHappy(Customer c);

    // 더미 Customer 클래스
    static class Customer {}

    // 더미 Database 클래스
    static class Database {
        public static Customer getCustomerWithId(int id){
            return new Customer();
        }
    }
}
