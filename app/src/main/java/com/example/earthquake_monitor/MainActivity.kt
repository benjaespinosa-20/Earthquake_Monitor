package com.example.earthquake_monitor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.earthquake_monitor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //rama con arquitectura y consumo de api

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.eqRecycler.layoutManager = LinearLayoutManager(this)

        val eqList = mutableListOf<Earthquake>()
        eqList.add(Earthquake("1", "Mexico", 4.3, 144343253, -122.3343, 28.1242214))
        eqList.add(Earthquake("2", "Mexico", 5.3, 144343253, -122.3343, 28.1242214))
        eqList.add(Earthquake("3", "Mexico", 9.3, 144343253, -122.3343, 28.1242214))
        eqList.add(Earthquake("4", "Mexico", 2.3, 144343253, -122.3343, 28.1242214))
        eqList.add(Earthquake("5", "Mexico", 7.3, 144343253, -122.3343, 28.1242214))

        val adapter = EqAdapter()
        binding.eqRecycler.adapter = adapter
        adapter.submitList(eqList)

        adapter.onItemClickListener = {
            Toast.makeText(this, it.place, Toast.LENGTH_LONG).show()
        }

        if(eqList.isEmpty()) {
            binding.eqEmptyView.visibility = View.VISIBLE
        }
        else {
            binding.eqEmptyView.visibility = View.GONE
        }
    }
}