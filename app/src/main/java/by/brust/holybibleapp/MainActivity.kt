package by.brust.holybibleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import by.brust.holybibleapp.core.BibleApp
import by.brust.holybibleapp.presentation.BibleAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    val viewModel = (application as BibleApp).mainViewModel

        val recyclerView = findViewById<RecyclerView>(R.id.recycler)
        val adapter = BibleAdapter()
        recyclerView.adapter = adapter

        viewModel.observe(this, Observer {
            adapter.update(it)
        })

        viewModel.fetchBooks()
    }
}