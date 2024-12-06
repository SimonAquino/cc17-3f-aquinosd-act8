class BooksViewModel : ViewModel() {

    private val repository = BooksRepository()

    private val _books = MutableLiveData<List<Book>>()
    val books: LiveData<List<Book>> get() = _books

    fun fetchBooks() {
        viewModelScope.launch {
            try {
                val bookList = repository.getBooks()
                _books.postValue(bookList)
            } catch (e: Exception) {
                // Handle error (e.g., network issue)
            }
        }
    }
}
