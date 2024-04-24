class ArchiveListScreen(private var archiveList: MutableList<Archive>): Screen() {

    override fun showScreen() {
        while (true) {
            println("Список архивов:")
            printListNames(archiveList, "Архив")
            println("0. Создать архив\n1. Открыть уже созданый архив\n2. Выход")
            if (!selectOption(archiveList, this)) break
        }
    }
    override fun goToNextScreen() {
        println("Введите номер архива, который хотите открыть")
        val selectNumberScreen = SelectNumberScreen()
        val number = selectNumberScreen.selectNumber(archiveList)

        if (number >= 0 ) {
            val noteListScreen = NoteListScreen(archiveList[number])
            noteListScreen.showScreen()
        }
    }
}