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

inline fun <K, V> Map<K, V>.mergeReduce(other: Map<K, V>, reduce: (V, V) -> V = { a, _ -> a }): Map<K, V> {
    return mergeReduceTo(LinkedHashMap(this.size + other.size), other, reduce)
}

inline fun <K, V, M : MutableMap<K, V>> Map<K, V>.mergeReduceTo(destination: M, other: Map<K, V>, reduce: (V, V) -> V = { a, _ -> a }): M {
    destination.putAll(this)
    for ((key, value) in other) {
        destination[key] = destination[key]?.let { reduce(it, value) } ?: value
    }
    return destination
}