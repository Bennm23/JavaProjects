package watcher;

import java.util.HashSet;
import java.util.Set;

public class ModelWatcher {

    Set<ModelChangeListener> listeners = new HashSet<>();

    public void addListener(ModelChangeListener cl) {
        listeners.add(cl);
    }

    public void notifyEvent(ModelChangeEvent evt) {
        listeners.forEach(cl -> cl.handle(evt));
    }
}
