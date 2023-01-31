class MethodChannelResult internal constructor(result: MethodChannel.Result) :
    MethodChannel.Result {
    private val result: MethodChannel.Result
    private val handler: Handler

    init {
        this.result = result
        handler = Handler(Looper.getMainLooper())
    }

    @Override
    fun success(result: Object) {
        handler.post(
            object : Runnable() {
                @Override
                fun run() {
                    result.success(result)
                }
            })
    }

    @Override
    fun error(
        errorCode: String?, errorMessage: String?, errorDetails: Object?
    ) {
        handler.post(
            object : Runnable() {
                @Override
                fun run() {
                    result.error(errorCode, errorMessage, errorDetails)
                }
            })
    }

    @Override
    fun notImplemented() {
        handler.post(
            object : Runnable() {
                @Override
                fun run() {
                    result.notImplemented()
                }
            })
    }
}