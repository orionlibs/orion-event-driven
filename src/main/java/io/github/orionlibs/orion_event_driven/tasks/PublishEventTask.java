package io.github.orionlibs.orion_event_driven.tasks;

import io.github.orionlibs.orion_event_driven.AbstractEvent;
import io.github.orionlibs.orion_event_driven.EventListenersRegistry;
import io.github.orionlibs.orion_reflection.method.access.ReflectionMethodAccessService;
import io.github.orionlibs.orion_task_runner.OrionJob;

public class PublishEventTask implements OrionJob
{
    private final AbstractEvent event;


    public PublishEventTask(AbstractEvent event)
    {
        this.event = event;
    }


    @Override
    public void run()
    {
        EventListenersRegistry.getEventListenersForEvent(event.getClass())
                        .forEach(eventListener -> ReflectionMethodAccessService.callMethod("processEvent", eventListener, new Class<?>[]
                                        {AbstractEvent.class}, new Object[]
                                        {event}));
    }
}