class DefaultMutableMap<K, V>(
    private val map: MutableMap<K, V> = mutableMapOf(),
    private val defaultValue: () -> V
): MutableMap<K, V> by map {
    override fun get(key: K): V {
        return map.computeIfAbsent(key) { defaultValue() }
    }
}