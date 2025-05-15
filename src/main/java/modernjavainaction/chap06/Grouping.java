package modernjavainaction.chap06;

import modernjavainaction.chap04.Dish;

import java.util.*;

import static java.util.stream.Collectors.*;
import static modernjavainaction.chap04.Dish.dishTags;
import static modernjavainaction.chap04.Dish.menu;

public class Grouping {

    public static void main(String[] args) {

        System.out.println("그룹화 예시");
        // 그룹화 함수가 반환되는 Key + 각 key에 대응하는 스트림의 모든 항목 리스트를 Value
        Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));
        printGrouping(dishesByType.entrySet());

        System.out.println("grouping 메서드에 람다 표현식 작성");
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(
                groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                }));
        printGrouping(dishesByCaloricLevel.entrySet());

        System.out.println("filter() 메서드 사용");
        Map<Dish.Type, List<Dish>> caloricDishesByType = menu.stream().filter(dish -> dish.getCalories() > 500)
                .collect(groupingBy(Dish::getType));
        printGrouping(caloricDishesByType.entrySet());

        System.out.println("grouping 메서드 안에서 필터링");
        Map<Dish.Type, List<Dish>> caloricDishesByType2 = menu.stream().
                collect(groupingBy(Dish::getType,
                        filtering(dish -> dish.getCalories() > 500, toList())));
        printGrouping(caloricDishesByType2.entrySet());

        System.out.println("grouping 메서드 안에서 mapping");
        Map<Dish.Type, List<String>> dishNamesByType = menu.stream()
                .collect(groupingBy(Dish::getType, mapping(Dish::getName, toList())));
        printGrouping(dishNamesByType.entrySet());

        System.out.println("grouping 메서드 안에서 flatMapping 사용");
        Map<Dish.Type, Set<String>> dishNamesByTpe = menu.stream()
                .collect(groupingBy(Dish::getType,
                        flatMapping(dish -> dishTags.get(dish.getName()).stream(),
                                toSet())));
        System.out.println(dishNamesByTpe + "\n");

        System.out.println("다수준 그룹화");
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = menu.stream().collect(
                groupingBy(Dish::getType, // 첫 번째 수준의 분류 함수
                        groupingBy(dish -> { // 두 번째 수준의 분류 함수
                            if (dish.getCalories() <= 400)
                                return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700)
                                return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;
                        }))
        );
        System.out.println(dishesByTypeCaloricLevel + "\n");

        Map<Dish.Type, Dish> mostCaloricByType = menu.stream()
                .collect(groupingBy(Dish::getType,
                        collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)),
                                Optional::get)));
        System.out.println(mostCaloricByType + "\n");

        Map<Dish.Type, Set<CaloricLevel>> caloricSetByType = menu.stream().collect(
                groupingBy(Dish::getType, mapping(dish -> {
                            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;
                        },
                        toSet()))
        );
        System.out.println(caloricSetByType);
    }

    private static <T, U> void printGrouping(Set<Map.Entry<T, List<U>>> entrySet) {

        for(Map.Entry<T, List<U>> entry : entrySet) {

            T key = entry.getKey();
            System.out.print("{ " + key + " = [ ");
            entry.getValue().forEach(value -> System.out.print(value + ", "));

            if (entry.getValue().isEmpty()) System.out.println("] }");
            else System.out.println("\b\b ] }");
        }
        System.out.println();
    }
}
