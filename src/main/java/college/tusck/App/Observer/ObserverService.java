package college.tusck.App.Observer;

import org.springframework.stereotype.Service;

@Service
public class ObserverService {
    private final Subject subject;
    private final ConcreteObserverA observerA;
    private final ConcreteObserverB observerB;

    public ObserverService(ConcreteObserverA observerA, ConcreteObserverB observerB) {
        this.observerA = observerA;
        this.observerB = observerB;
        this.subject = new Subject();

        subject.addObserver(observerA);
        subject.addObserver(observerB);
    }

    public void changeState(String newState) {
        subject.setState(newState);
    }
}
