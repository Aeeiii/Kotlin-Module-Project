class NoteListScreen(private var archive: Archive): Screen()
{
    override fun showScreen() {
        while (true) {
            println("Открыт архив ${archive.name}\nСписок заметок в архиве ${archive.name}:")
            printListNames(archive.noteList, "Заметка")
            println("0. Создать заметку\n1. Открыть существующую заметку\n2. Выход в главное меню")
            if (!selectOption(archive.noteList, this)) break
        }
    }
    override fun goToNextScreen() {
        println("Введите номер заметки, которую хотите открыть")
        val selectNumberScreen = SelectNumberScreen()
        val number = selectNumberScreen.selectNumber(archive.noteList)

        if (number >= 0 ) {
            noteScreen(number)
        }
    }
    private fun noteScreen(noteNumber: Int) {
        println(archive.noteList[noteNumber].toString())
        while (true) {
            println("0. Посмотреть текст заметки\nЛюбой другой ввод. Вернуться в меню архива")
            when (readln()) {
                "0" -> println(archive.noteList[noteNumber].takeText())
                else -> break
            }
        }
    }
}