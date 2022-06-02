package com.example.roomdb_typeconverters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.room.Room
import com.example.roomdata.Contract
import com.example.roomdata.ContractDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var database : ContractDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = ContractDatabase.getDatabase(this) //	Singleton Pattern


        GlobalScope.launch {
            database.contractDao().insertContact(Contract(0,"HIMU","001", Date()))
        }

        fun getData(view: View){
            database.contractDao().getContact().observe(this, androidx.lifecycle.Observer {
                Log.d("CodingWorking",it.toString())
            })
        }

    }
}