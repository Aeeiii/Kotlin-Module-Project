open class Screen {
    open fun goToNextScreen() {}
    open fun showScreen() {}

    inline fun <reified T> selectOption (list: MutableList<T>, screen: Screen) : Boolean {  // функция, считывающая команду из меню списка архивов/заметок
        when (readln()) {
            "0" -> {
                addNew(list)
            }
            "1"-> {
                if (list.size > 0) {
                    screen.goToNextScreen()
                } else println("Пока ничего не создано")
            }
            "2" -> return false
            else -> println("Ввод некорректен, повторите ввод")
        }
        return true
    }
    inline fun <reified T> printListNames (list: MutableList<T>, name: String) {  //функция, выводящая список всех архивов\заметок
        for ((i, l) in list.withIndex()) {
            println("$name $i: ${l.toString()}")
        }
    }
    inline fun <reified T> addNew(list: MutableList<T>) {  //функция, добавляющая новый архив/заметку
        println("Введите название")
        val name: String = takeText()

        when (T::class.qualifiedName) {
            "Archive" -> {
                list.add(Archive(name) as T)
            }
            "Note" -> {
                println("Ведите текст заметки")
                val text: String = takeText()
                list.add(Note(name, text) as T)
            }
        }
    }
    fun takeText(): String {  //функция считывающая название архива/заметки и текст заметки
        while (true) {
            val input = readln()
            if (input == "") println("Ничего не введено, пожалуйства введите текст")
            else return input
        }
    }
}

