package io.github.orionlibs.orion_event_driven;

import io.github.orionlibs.orion_event_driven.tasks.PublishEventTask;
import io.github.orionlibs.orion_task_runner.OrionJobService;

public class EventService
{
    public static void registerEventListener(Class<? extends AbstractEvent> eventClass, AbstractEventListener eventListener)
    {
        EventListenersRegistry.registerEventListener(eventClass, eventListener);
    }


    public static void deregisterEventListener(Class<? extends AbstractEvent> eventClass, AbstractEventListener eventListener)
    {
        EventListenersRegistry.deregisterEventListener(eventClass, eventListener);
    }


    public static void publishEventSynchronously(AbstractEvent event)
    {
        new PublishEventTask(event).run();
    }


    public static void publishEventAsynchronously(AbstractEvent event)
    {
        OrionJobService.runJobWithCurrentThreadName(new PublishEventTask(event));
    }
}