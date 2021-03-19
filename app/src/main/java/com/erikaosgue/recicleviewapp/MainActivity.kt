package com.erikaosgue.recicleviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.erikaosgue.recicleviewapp.data.PersonListAdapter
import com.erikaosgue.recicleviewapp.databinding.ActivityMainBinding
import com.erikaosgue.recicleviewapp.model.Person
import io.github.serpro69.kfaker.Faker
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var adapter: PersonListAdapter? = null
    private var personList: ArrayList<Person>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null


    lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        personList = ArrayList<Person>()
        layoutManager = LinearLayoutManager(this)
        adapter = PersonListAdapter(personList!!, this)

        // Set Up the List (RecycleView)
        activityMainBinding.recycleViewId.layoutManager = layoutManager
        activityMainBinding.recycleViewId.adapter = adapter

        //Loading data
        val faker = Faker()

        for(i in 0..10) {
            val person = Person()
            person.name = faker.name.firstName()
            person.age = Random.nextInt(17, 60)
            personList?.add(person)
        }
        adapter?.notifyDataSetChanged()

    }

}