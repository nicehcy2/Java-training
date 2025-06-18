package modernjavainaction.chap09;

import java.util.ArrayList;
import java.util.List;

/**
 * 옵저버 패턴(Observer Pattern)
 * 옵저버 패턴은 어떤 객체의 상태 변화가 발생했을 때,
 * 그 객체에 의존하는 여러 객체(옵저버)들에게 자동으로 알림이 전달되도록 하는 디자인 패턴
 * 발행-구독 모델(Publish-Subscribe 구조)
 *
 * * Subject(주제/발행자): 상태 변화를 감지하고, 옵저버에게 알림을 전달
 * * Observer(관찰자/구독자): Subject의 상태 변화에 따라 행동하는 객체
 */
public class ObserverMain {

    public static void main(String[] args) {

        Feed f = new Feed();
        f.registerObserver(new NYTimes());
        f.registerObserver(new Guardian());
        f.registerObserver(new LeMonde());

        f.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("queen")) {
                System.out.println("Yet more news from London... " + tweet);
            }
        });

        // notifyObservers()가 실행되면 등록된 옵저버 각각의 notify()가 호출됩니다.
        f.notifyObservers("The queen said her book is Modern Java in Action");
    }

    /**
     * 모든 옵저버는 notify() 메서드를 구현해야 하며, Subject로부터 알림을 받습니다.
     */
    interface Observer {
        void notify(String tweet);
    }

    static class NYTimes implements Observer {
        public void notify(String tweet) {
            if (tweet != null && tweet.contains("money")) {
                System.out.println("Breaking news in NY! " + tweet);
            }
        }
    }

    static class Guardian implements Observer {
        public void notify(String tweet) {
            if (tweet != null && tweet.contains("queen")) {
                System.out.println("Yet more news from London... " + tweet);
            }
        }
    }

    static class LeMonde implements Observer {
        public void notify(String tweet) {
            if (tweet != null && tweet.contains("wine")) {
                System.out.println("Today cheese, wine and news! " + tweet);
            }
        }
    }

    interface Subject {
        void registerObserver(Observer o); // 옵저버를 등록하는 메서드
        void notifyObservers(String tweet); // 등록된 옵저버에게 알림을 보내는 메서드
    }

    /**
     * Feed는 상태 변화(트윗 발생 시)를 옵저버들에게 알립니다. (주제 객체)
     */
    static class Feed implements Subject {
        private final List<Observer> observers = new ArrayList<>();

        public void registerObserver(Observer o ) {
            this.observers.add(o);
        }

        public void notifyObservers(String tweet) {
            observers.forEach(o -> o.notify(tweet));
        }
    }
}
