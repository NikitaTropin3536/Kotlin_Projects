// доска объявлений для героя
/* d данном мини - проекте используются полезные фишки Kotlin
попробуйте написать проект сами пи поторогать все фичи
 */
import java.lang.IllegalArgumentException

const val HERO_NAME = "Madrigal" // имя героя
var playerLevel = 0
fun main() {

    /*Игрок*/
    val heroNameReversed = HERO_NAME.reversed() // перевернутое имя героя
    var totalExperience = 0 // опыт героя
    var NUMBER_OF_COINS = 50 // количество монет у героя

    /* Генерация титула игрока */
    val playerTitle: String = when (val playerLevel: Int = totalExperience / 100 + 1) { // титул героя
        1 -> "Apprentice"
        in 2..8 -> "Level" + playerLevel + "Warrior"
        9 -> "Vanquisher or Nogartse"
        else -> "Distinguished Knight"
    }

    val race = "gnome" // раса героя
    val faction: String = when (race) { // коалиция, к которой относится наш герой
        "dwarf" -> "Keepers of the Mines"
        "gnome" -> "Tinkerers of the Underground "
        "orc", "human" -> "Free People of the Rolling hills"
        else -> "Shadow Cabal of the Unseen Realm" // Неизвестная раса
    }

    println("$HERO_NAME announces his presence to the world.")
    println("What level is $HERO_NAME?")
    playerLevel = readLine()?.toIntOrNull() ?: 0
    println("$HERO_NAME's level is $playerLevel")

    readBountyBoard()

    println("Time passes...")
    println("$HERO_NAME returns from his quest.")

    playerLevel += 1 // повышение уровня
    println(playerLevel)

    readBountyBoard()

    // меню в таверне
    val tavernMenu = mutableListOf(
        "honey", // мед
        "beer", // пиво
        "wine", // вино
    )

    /* былуемся с разными с сахаром */

    // объявляем и инициализируем два беззнаковых числа
//    var play: UInt = 5u
//    var play2 = 5.toUInt()
}

private fun obtainQuest(
    playerLevel: Int,
    playerClass: String = "paladin",
    hasBefriendBarbarians: Boolean = true,
    hasAngredBarbarians: Boolean = false, // значение по умолчанию
    ): String? {
    if (playerLevel < 0) {
        throw InvalidPlayerLevelException()
    }
    return when (playerLevel) {
        1 -> "Meet Mr. Bubbles in the land of soft things."
        in 2..5 -> {
            // Проверить возможность дипломатического решения
            val canTalkToBarbarians = !hasAngredBarbarians &&
                    (hasBefriendBarbarians || playerClass == "barbarian")
            if (canTalkToBarbarians) "Convince the barbarians to call of their invasion."
            else "Save the town from the barbarian invasions."
        }

        6 -> "Locate the enchanted sword."
        7 -> "Recover the long-lost artifact of creation."
        8 -> "Defeat Nogartse, bringer of death and eaters of worlds."
        else -> null
    }
}

// пользовательское исключение
class InvalidPlayerLevelException:
    IllegalArgumentException("invalid player level (must be at least 1).")

private fun readBountyBoard() {
    // 1. какие тут проверки на null?
    val message: String = try {
        val quest: String? = obtainQuest(playerLevel)
            quest?.replace("Nogartse", "xxx")
                ?.let { censoredQuest ->
            """
            |$HERO_NAME approaches the bounty board. It reads:
            |   "$censoredQuest"
            """.trimMargin()
            } ?: "$HERO_NAME approaches the bounty board. but it is blank."
    } catch (e: Exception) {
        "$HERO_NAME can't read what's on the bounty board."
    }
    println(message)
}