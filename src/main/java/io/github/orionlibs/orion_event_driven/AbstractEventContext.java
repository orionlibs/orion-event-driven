package io.github.orionlibs.orion_event_driven;

import java.util.Map;
import java.util.UUID;

public abstract class AbstractEventContext
{
    private String eventID;
    private String eventName;
    private AbstractEventContext parentContext;
    private Map<String, Object> parameterToObjectMapper;


    public AbstractEventContext()
    {
        this.eventID = UUID.randomUUID().toString().replace("-", "") + UUID.randomUUID().toString().replace("-", "");
    }


    public AbstractEventContext(AbstractEventContext parentContext)
    {
        this();
        this.parentContext = parentContext;
    }


    public AbstractEventContext(Map<String, Object> parameterToObjectMapper)
    {
        this();
        this.parameterToObjectMapper = parameterToObjectMapper;
    }


    public AbstractEventContext(AbstractEventContext parentContext, Map<String, Object> parameterToObjectMapper)
    {
        this(parentContext);
        this.parameterToObjectMapper = parameterToObjectMapper;
    }


    public AbstractEventContext(AbstractEventContext parentContext, String eventName)
    {
        this(parentContext);
        this.eventName = eventName;
    }


    public AbstractEventContext(AbstractEventContext parentContext, String eventName, Map<String, Object> parameterToObjectMapper)
    {
        this(parentContext, eventName);
        this.parameterToObjectMapper = parameterToObjectMapper;
    }


    public AbstractEventContext(String eventName)
    {
        this();
        this.eventName = eventName;
    }


    public String getEventID()
    {
        return this.eventID;
    }


    public String getEventName()
    {
        return this.eventName;
    }


    public void setEventName(String eventName)
    {
        this.eventName = eventName;
    }


    public AbstractEventContext getParentContext()
    {
        return this.parentContext;
    }


    public void setParentContext(AbstractEventContext parentContext)
    {
        this.parentContext = parentContext;
    }


    public Map<String, Object> getParameterToObjectMapper()
    {
        return this.parameterToObjectMapper;
    }


    public void setParameterToObjectMapper(Map<String, Object> parameterToObjectMapper)
    {
        this.parameterToObjectMapper = parameterToObjectMapper;
    }
}