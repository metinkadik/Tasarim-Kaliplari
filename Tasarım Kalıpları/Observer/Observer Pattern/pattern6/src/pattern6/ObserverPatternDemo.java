
package pattern6;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void notify(String message);
}

interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver();
}

class NoticeObservable implements Observable {

    private List<Observer> observerList = new ArrayList<>();
    private final String message = "Notice... !";

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer); // Kullanıcıları duyuruya eklemek için.
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer); // Kullanıcıları duyurudan silmek için.
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observerList) {
            observer.notify(message); // Duyuru ya kayıtlı kullanıcılara mesaj göndermek için.
        }
    }

}

class Villa implements Observer {

    private Observable observable;

    @Override
    public void notify(String message) {
        System.out.println(message + " Villa Satışta.");
    }

    public void removeObserver(){
        observable.removeObserver(this);
    }

}

 class Apartman implements Observer {

    private Observable observable;

    public Apartman() {
    }

    public void setObservable(Observable observable) {
        this.observable = observable;
    }

    @Override
    public void notify(String message) {
        System.out.println(message + " Apartman Satışta.");
    }

    public void removeObserver(){
        observable.removeObserver(this);
    }

}

public class ObserverPatternDemo {

    
    public static void main(String[] args) {
        
        Villa villa = new Villa();
        Apartman apartman = new Apartman();

        NoticeObservable noticeObservable = new NoticeObservable();

        apartman.setObservable(noticeObservable);

        noticeObservable.addObserver(villa);
        noticeObservable.addObserver(apartman);
        noticeObservable.notifyObserver();

        apartman.removeObserver();
        noticeObservable.notifyObserver();
    }
    
}
