package college.tusck.App.Observer;

import org.springframework.stereotype.Component;

@Component
public class ConcreteObserverB implements Observer {
    @Override
    public void update(String message) {
        System.out.println("ConcreteObserverB получил: " + message);
    }
}
