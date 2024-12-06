interface GoogleBooksApi {
    @GET("volumes")
    suspend fun getBooks(
        @Query("q") query: String = "android",  // Default search query
        @Query("maxResults") maxResults: Int = 20
    ): BooksResponse
}

data class BooksResponse(
    val items: List<Book>
)
