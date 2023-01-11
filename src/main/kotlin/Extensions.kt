import java.util.ArrayList

inline fun <T> Iterable<T>.chunkedBy(predicate: (T) -> Boolean): List<List<T>> {
    val result = ArrayList<List<T>>()
    val partitionedList = ArrayList<T>()
    forEach {
        if (predicate(it)) {
            partitionedList.add(it)
        } else {
            result.add(ArrayList(partitionedList))
            partitionedList.clear()
        }
    }
    return result
}