import watcher.ModelChangeEvent;
import watcher.ModelChangeListener;
import watcher.ModelWatcher;

public class Main {

    static class Model {

        ModelWatcher mw = new ModelWatcher();

    }

    static class Comms implements ModelChangeListener {

        @Override
        public void handle(ModelChangeEvent evt) {

            if (Evt.EVT_PRINT.equals(evt)) {
                System.out.println("Comms PRINTING");
            } else if (Evt.EVT_HELLO.equals(evt)) {
                System.out.println("Comms HELLO");
            }
        }
    }

    enum Evt implements ModelChangeEvent {
        EVT_PRINT,
        EVT_HELLO,
    }

    public static void main(String[] args) {

        var model = new Model();

        var comms = new Comms();

        model.mw.addListener((evt) -> {
            if (evt.equals(Evt.EVT_PRINT)) {
                System.out.println("PRINTING");
            } else if (evt.equals(Evt.EVT_HELLO)) {
                System.out.println("HELLO");
            }
        });

        model.mw.notifyEvent(Evt.EVT_PRINT);

        model.mw.addListener(comms);

        model.mw.notifyEvent(Evt.EVT_HELLO);
    }
}
