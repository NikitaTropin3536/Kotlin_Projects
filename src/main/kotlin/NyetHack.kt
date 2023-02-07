fun main() {
    narrate("A hero enters the town of Kronstadt. What is their name?")
    {
            message ->
        // Выводит сообщение желтым цветом
        "\u001b[33; 1m$message\u001b[0m"
    } // этот код может не работать (все зависит от цвеовых настроек вашего интерпретатора)
    val heroName = readLine() ?: ""

    changeNarrationMood()
    narrate("$heroName heads to the town square")
}

