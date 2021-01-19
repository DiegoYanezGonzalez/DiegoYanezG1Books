package com.example.diegoyaezbooks

import com.example.diegoyaezbooks.model.mapperBookApiToData
import com.example.diegoyaezbooks.model.pojos.Books
import org.junit.Test

import org.junit.Assert.*


class MapperTest {
    @Test
    fun mapperBookApiToData_happyCase(){
        //Given
        val boook = Books("","",2,"","","")
        //When
        val response = mapperBookApiToData(boook)
        //Then
        assert(response.author == boook.author)
        assert(response.country == boook.country)
        assert(response.id == boook.id)
        assert(response.language == boook.language)
        assert(response.imageLink == boook.imageLink)
        assert(response.title == boook.title)

    }


}