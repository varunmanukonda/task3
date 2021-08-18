package com.example.task3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task3.MyListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var list: List<MyListData>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list = ArrayList<MyListData>()


        val fab: View = findViewById(R.id.floatingActionButton)
        var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {

                var data = result.data
                // There are no request codes
                val name = data?.getStringExtra("name").toString()
                val email = data?.getStringExtra("email").toString()
                val gender = data?.getStringExtra("gender").toString()
                val time= data?.getStringExtra("time").toString()
                (list as ArrayList<MyListData>).add(MyListData(R.drawable.image,email,name,gender, time))


                val recyclerView = findViewById<View>(R.id.RecycleView) as RecyclerView
                val adapter = MyListAdapter(list)
                recyclerView.setHasFixedSize(true)
                recyclerView.layoutManager = LinearLayoutManager(this)
                recyclerView.adapter = adapter

                val insertIndex = 2
                adapter.notifyItemInserted(insertIndex);



            }
        }

        fab.setOnClickListener { view ->
            val intent= Intent(this,RegistrationForm::class.java)

            resultLauncher.launch(intent)



        }




    }
    }

