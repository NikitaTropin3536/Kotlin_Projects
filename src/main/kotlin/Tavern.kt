
import java.io.File
private const val TAVERN_MASTER = "Taernyl"
private const val TAVERN_NAME = "$TAVERN_MASTER's Folly"

private val firstNames = setOf("Alex", "Mordoc", "Sophie", "Tariq")
private val lastNames = setOf("Ironfoot", "Fernswoth", "Baggins", "Downstrider")
private val menuData = File("data/tavern-menu-data.txt").readText().split("\n")

private const val TAVERN_MENU_ATTITUBE = "*** Welcome to Taernyl's Folly ***"
// заголовок меню

private val mmenuItems = List(menuData.size) {index ->
    val(_, name, price) = menuData[index].split(",")
    name
}

private val perfectMenuitems = List(menuData.size) {
    index ->
    val(_, name, price) = menuData[index].split(",")
    name+ ""
}

fun visitTavern() {
    /**Ннаш герой входит в таверну*/
    narrate("$heroName enters $TAVERN_NAME")

    /** выводим все меню*/
    narrate("There are several items for sale:")
    println(mmenuItems.joinToString()) // конкатенация элементов

    /** посетители таверны*.
     * тут мы используем множество, ибо каждый посетитель - уникален
     */
    val patrons:MutableSet<String> = mutableSetOf()
    while (patrons.size < 10) {
        patrons += "${firstNames.random()} ${lastNames.random()}"
    }

    /**
     * Список(patrons)
     * обращение к элементу списка по индексу
     * get(index)
     * [index]
     *
     * получение первого и последнего элемента списка
     * patrons.first()
     * patrons.last()
     *
     * patrons.getOrElse(4) {"Unknown Patron"} - вместо исключения - "Unknown Patron"
     */

    /** а вот и посетители!*/
    narrate("$heroName sees several patrons in the tavern:")
    narrate(patrons.joinToString())

    repeat(3) {
        placeOrder(patrons.random(), mmenuItems.random())
    }
}
private fun placeOrder(patronName: String , menuItemName: String) {
    narrate("$patronName speaks with $TAVERN_MASTER to place an order")
    narrate("$TAVERN_MASTER hands $patronName a $menuItemName")
}

/**
 * Обращение к элементам множества по индексу
 * множество.elementAt2)
 */
