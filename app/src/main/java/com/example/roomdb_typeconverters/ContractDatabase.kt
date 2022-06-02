package com.example.roomdata

import android.content.Context
import androidx.room.*
import com.example.roomdb_typeconverters.Convertors

@Database(entities = [Contract::class], version = 1)

@TypeConverters(Convertors::class) //calling Convertor Class

abstract class ContractDatabase : RoomDatabase (){

    abstract fun contractDao(): ContractDAO

    companion object{
        @Volatile
        private var INSTANCE : ContractDatabase? = null

        fun getDatabase(contex : Context): ContractDatabase{
            if (INSTANCE == null){
                synchronized(this){

                    INSTANCE = Room.databaseBuilder(
                        contex.applicationContext, ContractDatabase::class.java, "contactDB"
                    ).build()
                }

            }
            return INSTANCE!!
        }
    }

}