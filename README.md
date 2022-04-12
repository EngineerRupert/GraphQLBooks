# GraphQLBooks project

# Query
query {</br>
  getAllBooks {</br>
    bookId</br>
    title</br>
    authors {</br>
      authorId</br>
      name</br>
    }</br>
  },</br></br>
  getAuthor(name:"Демидова М. Д.") {</br>
    authorId</br>
    name</br>
    getBooksByAuthor {</br>
      bookId</br>
      title</br>
    }</br>
  }</br>
}</br>
</br>
# Mutation
mutation {</br>
  saveBook(bookInput: {</br>
    title: "New Book",</br>
    author: "Демидов"</br>
  }) {</br>
    bookId</br>
    title</br>
    authors {</br>
      authorId</br>
      name</br>
    }},</br></br>
  saveAuthor(authorInput: {</br>
    name: "New Author Mut",</br>
    book: "New Book Mut"</br>
  }) {</br>
    authorId</br>
    name</br>
    getBooksByAuthor {</br>
      bookId</br>
      title</br>
    }</br>
  }</br>
