package com.example.diegoyaezbooks


import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.platform.app.InstrumentationRegistry
import com.example.diegoyaezbooks.model.db.BookDao
import com.example.diegoyaezbooks.model.db.BookDatabase
import com.example.diegoyaezbooks.model.db.BooksEntity
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class BooksDataBaseTest {

    @get:Rule
    var instantExecuteRule = InstantTaskExecutorRule()

    //Instancia del Dao Y la Base de datos
    private lateinit var bookDao: BookDao
    private lateinit var dataBase: BookDatabase

    //Función que se ejecuta cada vez antes de cada test y se inicializa la base de datos y el dao

    @Before
    fun setup() {
        //Contexto que instancia la base de datos
        val context = ApplicationProvider.getApplicationContext<Context>()
        dataBase = Room.inMemoryDatabaseBuilder(context, BookDatabase::class.java).build()
        bookDao = dataBase.bookDao()
    }

    @After
    fun tearDown() {
        dataBase.close()
    }

    @Test
    fun insertBooks_empty() = runBlocking {
        //Given
        val bokkList = listOf<BooksEntity>()

        //When
        bookDao.insert(bokkList)

        //Then
        bookDao.getBooks().observeForever {
            assertThat(it).isNotNull()
            assertThat(it).isEmpty()
        }
    }

    @Test
    fun insertBook_1book() = runBlocking {
        //Given
        val bookList = listOf(BooksEntity("","",1,"","",""))

        //  When
        bookDao.insert(bookList)

        //Then
        bookDao.getBooks().observeForever {
            assertThat(it).isNotNull()
            assertThat(it).isNotEmpty()
            assertThat(it).hasSize(1)

        }

    }


    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertThat("com.example.diegoyaezbooks").isEqualTo(appContext.packageName)
    }
}
