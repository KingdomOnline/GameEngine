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

    public static boolean callEvent(Event event) {
        for (Listener listener : listeners) {
            Method[] methods = listener.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (method.getAnnotation(EventHandler.class) == null)
                    continue;
                if (method.getParameterCount() != 1)
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

        //Run this check after all the listeners have run, this way the code written for when the event is cancelled will run, this lets listeners actually cancel events.
        if (event instanceof Cancellable) if (((Cancellable) event).isCancelled()) return false;

        return true;

    }

}
