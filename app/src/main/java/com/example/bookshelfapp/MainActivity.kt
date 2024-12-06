class MainActivity : AppCompatActivity() {

    private lateinit var booksViewModel: BooksViewModel
    private lateinit var booksAdapter: BooksAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        booksAdapter = BooksAdapter(emptyList())
        recyclerView.adapter = booksAdapter

        booksViewModel = ViewModelProvider(this).get(BooksViewModel::class.java)

        booksViewModel.books.observe(this, Observer { books ->
            booksAdapter = BooksAdapter(books)
            recyclerView.adapter = booksAdapter
        })

        booksViewModel.fetchBooks()
    }
}
