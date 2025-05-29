package modernjavainaction.chap08;

import modernjavainaction.chap05.Trader;
import modernjavainaction.chap05.Transaction;

import java.util.*;

import static java.util.Map.entry;

public class WorkingWithCollections {

    public static void main(String[] args) {

        List<Transaction> sizedTransactions = initTradesAndTransactions();
        List<Transaction> transactions = new ArrayList<>(sizedTransactions);

        // 스트림 API의 map을 통해서 리스트의 각 요소를 변경할 수 있지만, 새 문자열 컬렉션을 만든다.
        // 기존 컬렉션을 바꾸고 싶다면 replaceAll 메서드를 사용하면 된다.
        System.out.println("replaceAll 메서드");
        transactions.replaceAll(transaction ->
                new Transaction(transaction.getTrader(), 2025, transaction.getValue()));
        System.out.println(transactions + "\n");

        // 8.2.1 removeIf 메서드
        /**
         * ConcurrentModificationException 예외
         * 내부적으로 for-each 루프는 Iterator 객체를 사용
         * -> 두 개위 개별 객체가 컬렉션을 관리한다.
         * - Iterator 객체, next(), hasNext()를 이용해 소스를 질의
         * - Collection 객체 자체, remove()를 호출해 요소를 삭제
         * --> 반복자의 상태는 컬렉션의 상태와 서로 동기화되지 않는다.
         *
         * for (Transaction transaction : transactions) {
         *             transactions.remove(transaction);
         *             // 반복하면서 별도의 두 객체를 통해 컬렉션을 바꾸고 있는 문제
         *         }
         */

        System.out.println("removeIf 메서드");
        transactions.removeIf(transaction ->
                transaction.getYear() > 2011);
        System.out.println(transactions.size() + "\n");

        Map<String, Integer> ageOfFriends = Map.ofEntries(entry("Raphael", 30),
                entry("Olivia", 25),
                entry("Thibaut", 26));

        System.out.println("for-each로 맵 처리");
        for (Map.Entry<String, Integer> entry : ageOfFriends.entrySet()) {
            String friend = entry.getKey();
            Integer age = entry.getValue();
            System.out.println(friend + "is " + age + " years old");
        }
        System.out.println();

        // Map 인터페이스는 BiConsumer를 인수로 받는 forEach 메서드를 지원
        System.out.println("forEach 메서드");
        ageOfFriends.forEach((friend, age) ->
                System.out.println(friend + "is " + age + " years old"));
        System.out.println();

        System.out.println("Key를 기준으로 Map 정렬");
        ageOfFriends
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(System.out::println);
        System.out.println();

        System.out.println("getOrDefault 메서드");
        System.out.println(ageOfFriends.getOrDefault("Olivia", 0));
        System.out.println(ageOfFriends.getOrDefault("Heo", 0));

        System.out.println("Map 계산 패턴");
        Map<Integer, List<String>> ageMapList = new HashMap<>();
        ageMapList.computeIfAbsent(24, value -> new ArrayList<>())
                .add("Heo");

        ageMapList.remove(24, ageMapList.get(24));
        System.out.println(ageMapList.size());
        System.out.println();

        System.out.println("Map 교체 패턴");
        Map<String, String> favouriteMovies = new HashMap<>();
        favouriteMovies.put("Heo", "Iron man");
        favouriteMovies.put("Kim", "Hulk");
        favouriteMovies.put("Moon", "Thor");
        favouriteMovies.replaceAll((key, value) -> value.toUpperCase());
        System.out.println(favouriteMovies + "\n");
    }

    private static List<Transaction> initTradesAndTransactions() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        return Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }
}
