fun main(args: Array<String>) {
    val archiveList: MutableList<Archive> = mutableListOf()
    val archiveListScreen = ArchiveListScreen(archiveList)
    archiveListScreen.showScreen()
    println("Работа программы завершена.")
}

