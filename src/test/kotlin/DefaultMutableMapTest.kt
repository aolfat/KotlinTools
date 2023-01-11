import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class DefaultMutableMapTest : StringSpec({
    "Ensure add creates default" {
        val map = DefaultMutableMap<String, String> { "ali is the best" }
        val entry = map["who is the best?"]
        entry shouldBe "ali is the best"
    }

    "Ensure add creates default with a mutable list" {
        val map = DefaultMutableMap<String, MutableList<String>> { mutableListOf() }
        val entry = map["who is the best?"]
        entry shouldBe emptyList()
    }
})