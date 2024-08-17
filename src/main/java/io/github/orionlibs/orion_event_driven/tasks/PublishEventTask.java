package io.github.orionlibs.orion_event_driven.tasks;

import io.github.orionlibs.orion_event_driven.AbstractEvent;
import io.github.orionlibs.orion_event_driven.EventListenersRegistry;
import io.github.orionlibs.orion_reflection.method.access.ReflectionMethodAccessService;
import io.github.orionlibs.orion_task_runner.OrionJob;

public class PublishEventTask implements OrionJob
{
    private AbstractEvent event;


    public PublishEventTask(AbstractEvent event)
    {
        this.event = event;
    }


    @Override
    public void run()
    {
        EventListenersRegistry.getEventListenersForEvent((Class<? extends AbstractEvent>)event.getClass())
                        .forEach(eventListener -> ReflectionMethodAccessService.callMethod("processEvent", eventListener, new Class<?>[]
                        {AbstractEvent.class}, new Object[]
                        {(AbstractEvent)event}));
    }
}