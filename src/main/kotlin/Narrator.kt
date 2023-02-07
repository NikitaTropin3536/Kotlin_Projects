import java.nio.file.WatchEvent.Modifier
import kotlin.random.Random
import kotlin.random.nextInt
// рассказчик

var narrationModifier: (String) -> String = {it}

fun narrate(
    message: String,
    modifier: (String) -> String = {
        narrationModifier(it)
    }
) {
    println(modifier(message))
}
// если есть when - то мы можем сделатьнесколько реализаций лямбда - функции?
fun changeNarrationMood() {
    val mood: String
    val modifier: (String) -> String
        when(Random.nextInt(1..4)) {
            1 -> {
                mood = "loud"
                modifier = {message ->
                    val numExclamationPoints = 3
                    message.uppercase() + "!".repeat(numExclamationPoints)
                }
            }
            2 -> {
                mood = "tired"
                modifier = {message ->
                    message.lowercase().replace("", "...")
                }
            }
            3 -> {
                mood = "unsure"
                modifier = {message ->
                    "$message."
                }
            }
            else -> {
                mood = "professional"
                modifier = {message ->
                    "$message."
                }
            }
        }

    narrationModifier = modifier
    narrate("The narrator begins to feel $mood")
}