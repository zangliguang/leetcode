package interview.designPattern.single

class SingletonK private constructor() {
//    public var value: SingletonK? = null
    private object mHolder {
        val INSTANCE = SingletonK()
    }
    companion object Factory {
        fun getInstance(): SingletonK {
            return mHolder.INSTANCE
        }
    }
}