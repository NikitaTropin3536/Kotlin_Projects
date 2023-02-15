import javax.security.auth.kerberos.KerberosCredMessage

/** Основноый файл нашей игры*/

var heroName: String = " "
private fun makeYellow(message: String) = "\u001b[33;1m$message\u001b[0m"

fun main() {
//    narrate("A hero enters the town of Kronstadt. What is their name?",
//    ::makeYellow)
//    val heroName = readLine() ?: ""
//
//    require(heroName != null && heroName.isNotEmpty()) {
//        "The hero must have a name"
//    }
    heroName = promptHeroName()
    //changeNarrationMood()
    narrate("$heroName, ${createTitle(heroName)}, heads to the town square")
    visitTavern()
}

private fun createTitle(name : String) : String {

    val nameReversed: (String) -> String = {// имя игрока наоборот
        // Переворачиваем строку
        it.lowercase().reversed()
    }

    val countLetter: (String) -> Int = {
        var lengthLetter = 0
        for (i in 0..it.length - 1) {
            if(it[i].isLetter()) lengthLetter++
        }
        lengthLetter// количество букв в слове
    }
    return when {
        name.all { it.isUpperCase() } -> "Outstanding" // все буквы в слове записаны в верхнем регистре
        /*Выдающийся  - все буквы
        в имени игрока записаны в верхнем регистре*/

        name.all { it.isDigit() } -> "The Identifiable" // каждый символ строки - цифра

        countLetter(name) > 10 -> "Voluminous" // Пространный

        name.lowercase() == nameReversed(name) -> "Palindrome Carrier" // если имя игрока является палиндромом

        name.none { it.isLetter() } -> "The Witness Protection Member" // каждый символ строки - не буква

        name.count { it.lowercase() in "aeiou"} > 4 -> "The Master of Vowel"

        else -> "The Renowned Hero"
    }
}

private fun promptHeroName(): String {
    narrate("A hero enters the town of Kronstadt. What is their name?", ::makeYellow)

    /*val input = readLine()
    require(input != null && input.isNotEmpty()) {
       "The hero must have a name."
   }
   return input*/

    println("Madrigal")
    return "Madrigal"
}

