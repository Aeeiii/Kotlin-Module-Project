class Note(private val name: String, private val text: String){

    override fun toString(): String {
        return "Заметка ${this.name}"
    }

    fun takeText(): String {
        return "Текст заметки ${this.name}: ${this.text}"
    }
}