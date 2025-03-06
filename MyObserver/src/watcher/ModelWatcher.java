package watcher;

import java.util.ArrayList;
import java.util.List;

public class ModelWatcher {

    List<ModelChangeListener> listeners = new ArrayList<>();

    public void addListener(ModelChangeListener cl) {
        listeners.add(cl);
    }

    public void notifyEvent(ModelChangeEvent evt) {
        listeners.forEach(cl -> cl.handle(evt));
    }
}
