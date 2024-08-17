package io.github.orionlibs.orion_event_driven;

import io.github.orionlibs.orion_calendar.CalendarService;
import io.github.orionlibs.orion_calendar.datetime.DateTime;

public abstract class AbstractEvent
{
    private AbstractEventContext eventContext;
    private DateTime timestamp;
    private boolean notifySubscribersAsynchronously;


    public AbstractEvent(AbstractEventContext eventContext)
    {
        this.eventContext = eventContext;
        this.timestamp = CalendarService.getCurrentDatetime();
    }


    public AbstractEvent(AbstractEventContext eventContext, DateTime timestamp)
    {
        this.eventContext = eventContext;
        this.timestamp = timestamp;
    }


    public AbstractEvent(AbstractEventContext eventContext, DateTime timestamp, boolean notifySubscribersAsynchronously)
    {
        this.eventContext = eventContext;
        this.notifySubscribersAsynchronously = notifySubscribersAsynchronously;
        this.timestamp = timestamp;
    }


    public AbstractEventContext getEventContext()
    {
        return this.eventContext;
    }


    public DateTime getTimestamp()
    {
        return this.timestamp;
    }


    public boolean isNotifySubscribersAsynchronously()
    {
        return this.notifySubscribersAsynchronously;
    }
}