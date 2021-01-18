package com.example.diegoyaezbooks.model

import com.example.diegoyaezbooks.model.db.BooksEntity
import com.example.diegoyaezbooks.model.pojos.Books

fun mapperBookApiToData(books: Books) : BooksEntity{
    return BooksEntity(books.author,books.country,books.id,books.language,books.imageLink,books.title)
}

fun mapperBookDataToApi(entity: BooksEntity) : Books{
    return Books(entity.author,entity.country,entity.id,entity.language,entity.title,entity.imageLink)
}