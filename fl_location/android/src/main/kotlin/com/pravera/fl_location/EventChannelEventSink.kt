class EventChannelEventSink internal constructor(eventSink: EventChannel.EventSink) :
    EventChannel.EventSink {
    private val eventSink: EventChannel.EventSink
    private val handler: Handler

    init {
        this.eventSink = eventSink
        handler = Handler(Looper.getMainLooper())
    }

    @Override
    fun success(o: Object?) {
        handler.post(object : Runnable() {
            @Override
            fun run() {
                eventSink.success(o)
            }
        })
    }

    @Override
    fun error(s: String?, s1: String?, o: Object?) {
        handler.post(object : Runnable() {
            @Override
            fun run() {
                eventSink.error(s, s1, o)
            }
        })
    }
}