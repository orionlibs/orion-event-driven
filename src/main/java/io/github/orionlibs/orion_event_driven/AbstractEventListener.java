package io.github.orionlibs.orion_event_driven;

public interface AbstractEventListener
{
    void processEvent(AbstractEvent event);
}