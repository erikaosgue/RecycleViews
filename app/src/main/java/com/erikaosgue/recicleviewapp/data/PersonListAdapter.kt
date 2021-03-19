package com.erikaosgue.recicleviewapp.data

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.erikaosgue.recicleviewapp.R
import com.erikaosgue.recicleviewapp.model.Person

class PersonListAdapter(private val list: ArrayList<Person>,
private val context: Context): RecyclerView.Adapter<PersonListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View, context: Context): RecyclerView.ViewHolder(itemView) {
        fun bindItem(person: Person){
            val name: TextView = itemView.findViewById<TextView>(R.id.name)
            val age: TextView = itemView.findViewById<TextView>(R.id.age)

            name.text = person.name
            age.text = person.age.toString()

            itemView.setOnClickListener{
                Toast.makeText(context, name.text, Toast.LENGTH_LONG).show()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // create a view from our xml
        val view = LayoutInflater.from(context).inflate(R.layout.list_row, parent, false)
        return ViewHolder(view, context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

}