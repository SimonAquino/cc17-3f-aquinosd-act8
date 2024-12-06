package com.example.bookshelfapp.Adapter

class BooksAdapter(private val books: List<Book>) : RecyclerView.Adapter<BooksAdapter.BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]
        holder.bind(book)
    }

    override fun getItemCount(): Int = books.size

    class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val bookTitle: TextView = itemView.findViewById(R.id.book_title)
        private val bookImage: ImageView = itemView.findViewById(R.id.book_image)

        fun bind(book: Book) {
            bookTitle.text = book.title
            // Use Coil to load image asynchronously
            bookImage.load(book.imageLinks.thumbnail)
        }
    }
}
