package com.example.diegoyaezbooks.model.db

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.*

@Entity(tableName = "book")
data class BooksEntity (val author: String, val country: String, @PrimaryKey val id: Int, val imageLink: String,
                        val language: String,
                        val title: String )
@Entity(tableName = "book_detail")
data class DetailBooksEntity(val author: String, val country: String, val delivery: Boolean, @PrimaryKey val id: Int,
                             val imageLink: String, val language: String, val lastPrice: Int, val link: String,
                             val pages: Int, val price: Int, val title: String, val year: Int)

@Dao
interface  BookDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(books:List<BooksEntity>)
    @Query("SELECT * FROM book")
    fun getBooks():LiveData<List<BooksEntity>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetail(book:DetailBooksEntity)
    @Query("SELECT * FROM book_detail WHERE id=:code")
    fun getBook(code:Int):LiveData<DetailBooksEntity>
}
@Database(entities =[BooksEntity::class,DetailBooksEntity::class],version=1 )
abstract class BookDatabase : RoomDatabase() {
    abstract fun bookDao():BookDao
}
class BookApplication(): Application(){
    companion object{
        var bookDatabaseRoom : BookDatabase?=null
    }
    override fun onCreate() {
        super.onCreate()
        bookDatabaseRoom = Room.databaseBuilder(this,BookDatabase::class.java,"book_database").build()
    }
}
