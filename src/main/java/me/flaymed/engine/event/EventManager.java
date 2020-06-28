package me.flaymed.engine.event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private static List<Listener> listeners = new ArrayList<>();

    public static void registerListener(Listener listener) {
        listeners.add(listener);
    }

    public static void callEvent(Event event) {
        if (event instanceof Cancellable)
            if (((Cancellable) event).isCancelled())
                return;

        for (Listener listener : listeners) {
            Method[] methods = listener.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (method.getAnnotation(EventHandler.class) == null)
                    continue;
                if (method.getParameterCount() > 1)
                    continue;
                else{
                    Parameter[] parameters = method.getParameters();
                    for (Parameter parameter : parameters) {
                        if (parameter.getType() == event.getClass()) {
                            try {
                                method.invoke(listener, event);
                            } catch (InvocationTargetException | IllegalAccessException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }


}
