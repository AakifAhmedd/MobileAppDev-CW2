package com.example.mobileappcw2

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class SearchActivity : AppCompatActivity() {

    private lateinit var recyclerViewSuggestions: RecyclerView
    private lateinit var recyclerViewSearch: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<LanguageData>()
    private lateinit var searchAdapter: LanguageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val suggestionsText = findViewById<TextView>(R.id.suggestions)
        val searchText = findViewById<TextView>(R.id.search)

        recyclerViewSuggestions = findViewById(R.id.recyclerViewSuggestions)
        recyclerViewSearch = findViewById(R.id.recyclerViewSearch)
        searchView = findViewById(R.id.searchView)

        recyclerViewSuggestions.setHasFixedSize(true)
        recyclerViewSearch.setHasFixedSize(true)

        recyclerViewSuggestions.layoutManager = LinearLayoutManager(this)
        recyclerViewSearch.layoutManager = LinearLayoutManager(this)
        addDataToList()
        searchAdapter = LanguageAdapter(mList)
        recyclerViewSearch.adapter = searchAdapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText.isNullOrEmpty()) {
                    recyclerViewSuggestions.visibility = View.VISIBLE
                    suggestionsText.visibility = View.VISIBLE
                    suggestionsText.visibility = View.VISIBLE
                } else {
                    recyclerViewSuggestions.visibility = View.GONE
                    suggestionsText.visibility = View.GONE
                }
                filterList(newText)
                return true
            }
        })
    }

    private fun filterList(query: String?) {

        if (query != null) {
            val filteredList = ArrayList<LanguageData>()
            for (i in mList) {
                if (i.title.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                    recyclerViewSearch.visibility = View.VISIBLE
                }
            }

            if (filteredList.isEmpty()) {
                Toast.makeText(this, "No Data found", Toast.LENGTH_SHORT).show()
                recyclerViewSearch.visibility = View.GONE

            } else {
                searchAdapter.setFilteredList(filteredList)
            }
        }
    }



    private fun addDataToList() {
        mList.add(LanguageData("Spicy Arrabiata Penne", R.drawable.penne_pic))
        mList.add(LanguageData("Brown Stew Chicken", R.drawable.penne_pic))
        mList.add(LanguageData("Chicken and Mushroom Hotpot", R.drawable.penne_pic))
        mList.add(LanguageData("Banana Boat", R.drawable.penne_pic))
    }
}