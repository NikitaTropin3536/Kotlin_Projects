import java.nio.file.WatchEvent.Modifier
import kotlin.random.Random
import kotlin.random.nextInt

/** рассказчик и его настроение*/
var narrationModifier: (String) -> String = {it}

fun narrate(
    message: String,
    modifier: (String) -> String = {narrationModifier(it)}
) {
    println(modifier(message))
}

/** меняем настроение рассказчика*/
fun changeNarrationMood() {
    val mood: String
    val modifier: (String) -> String
        when(Random.nextInt(1..5)) {
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
            4 -> {
                var narrationsGiven = 0
                mood = "like sending an itemized bill"
                modifier = { message ->
                    narrationsGiven++
                    "$message.\n(I have narrated $narrationsGiven things)"
                }
            }
            5 -> { // ленивое настроение
                mood = "lazy"
                modifier = { message ->
                    message.substring(0, message.length / 2) + "..."
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

/** Вопросы
 * 1. если есть when, то мы можем сделать несколько реализаций лямбда - функций?
 * 2. Почитать ро inline
 *
 */