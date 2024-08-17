package io.github.orionlibs.orion_event_driven;

import io.github.orionlibs.orion_event_driven.tasks.DeregisterEventListenerTask;
import io.github.orionlibs.orion_event_driven.tasks.RegisterEventListenerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class EventListenersRegistry
{
    private static ConcurrentMap<Class<? extends AbstractEvent>, CopyOnWriteArrayList<AbstractEventListener>> eventClassToEventListenersMapper;
    static
    {
        eventClassToEventListenersMapper = new ConcurrentHashMap<Class<? extends AbstractEvent>, CopyOnWriteArrayList<AbstractEventListener>>();
    }


    public static void registerEventListener(Class<? extends AbstractEvent> eventClass, AbstractEventListener eventListener)
    {
        RegisterEventListenerTask.run(eventClass, eventListener, eventClassToEventListenersMapper);
    }


    public static void deregisterEventListener(Class<? extends AbstractEvent> eventClass, AbstractEventListener eventListener)
    {
        DeregisterEventListenerTask.run(eventClass, eventListener, eventClassToEventListenersMapper);
    }


    public static CopyOnWriteArrayList<AbstractEventListener> getEventListenersForEvent(Class<? extends AbstractEvent> eventClass)
    {
        return eventClassToEventListenersMapper.get(eventClass);
    }
}