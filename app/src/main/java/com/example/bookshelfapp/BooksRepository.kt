class BooksRepository {
    private val api = RetrofitInstance.api

    suspend fun getBooks(): List<Book> {
        val response = api.getBooks()
        return response.items
    }
}
