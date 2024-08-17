package io.github.orionlibs.orion_event_driven;

public interface AbstractEventListener
{
    public void processEvent(AbstractEvent event);
}