package modernjavainaction.chap08;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Map.entry;

public class CreatingCollections {

    public static void main(String[] args) {

        // 고정 크기의 리스트 생성
        // 요소를 갱신할 수는 있지만, 새 요소를 추가하거나 삭제할 수는 없다.
        System.out.println("Arrays.asList() 팩토리 메서드");
        List<String> friendsList
                = Arrays.asList("Raphael", "Olivia", "Thibaut");
        System.out.println(friendsList + "\n");

        // Arrays.toSet()이라는 메서드가 없으므로 리스트나 Stream API를 이용해서 Set 생성
        // 그러나 불필요한 객체 할당과 변환할 수 없는 집합이다.
        System.out.println("리스트를 인수로 받는 HashSet 생성자");
        Set<String> friendsHashSet1
                = new HashSet<>(Arrays.asList("Raphael", "Olivia", "Thibaut"));
        System.out.println(friendsHashSet1 + "\n");
        System.out.println("스트림 API를 활용한 Set");
        Set<String> friendsHashMap2
                = Stream.of("Raphael", "Olivia", "Thibaut")
                .collect(Collectors.toSet());
        System.out.println(friendsHashMap2 + "\n");

        // 불변 리스트 생성 (set도 불가능)
        System.out.println("List.of 팩토리 메서드");
        List<String> friendsListOf = List.of("Raphael", "Olivia", "Thibaut");
        System.out.println(friendsListOf + "\n");

        System.out.println("Map.of 팩토리 메서드");
        Map<String, Integer> ageOfFriends1
                = Map.of("Raphael", 30, "Olivia", 25, "Thibaut", 26);
        System.out.println(ageOfFriends1 + "\n");

        System.out.println("Map.ofEntries 팩토리 메서드");
        Map<String, Integer> ageOfFriends2 = Map.ofEntries(entry("Raphael", 30),
                entry("Olivia", 25),
                entry("Thibaut", 26));
        System.out.println(ageOfFriends2 + "\n");
    }
}
