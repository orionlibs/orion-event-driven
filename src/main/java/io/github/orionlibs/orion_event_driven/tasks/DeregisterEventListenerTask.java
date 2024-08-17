package io.github.orionlibs.orion_event_driven.tasks;

import io.github.orionlibs.orion_event_driven.AbstractEvent;
import io.github.orionlibs.orion_event_driven.AbstractEventListener;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class DeregisterEventListenerTask
{
    public static void run(Class<? extends AbstractEvent> eventClass, AbstractEventListener eventListener, ConcurrentMap<Class<? extends AbstractEvent>, CopyOnWriteArrayList<AbstractEventListener>> eventClassToEventListenersMapper)
    {
        if(eventClassToEventListenersMapper.get(eventClass) != null)
        {
            eventClassToEventListenersMapper.get(eventClass).remove(eventListener);
        }
    }
}