package com.example.roomdata

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContractDAO {

    @Insert
    suspend fun insertContact(contact: Contract)

    @Update
    suspend fun updateContact(contact: Contract)

    @Delete
    suspend fun deleteContact(contact: Contract)


    @Query("SELECT * FROM contact")
    fun getContact(): LiveData<List<Contract>>

}