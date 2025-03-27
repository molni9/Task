package college.tusck.App.Observer;

import org.springframework.stereotype.Component;

@Component
public class ConcreteObserverA implements Observer {
    @Override
    public void update(String message) {
        System.out.println("ConcreteObserverA получил: " + message);
    }
}

