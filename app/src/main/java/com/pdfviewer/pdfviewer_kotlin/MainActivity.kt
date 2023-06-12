package com.pdfviewer.pdfviewer_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.get
import com.pdfviewer.pdfviewer_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.floatingActionButton.setOnClickListener {
            launcher.launch("application/pdf")
        }

    }

    private val launcher = registerForActivityResult(
        ActivityResultContracts.GetContent()
    ){
        uri ->

        uri?.let {
            binding.pdfView.fromUri(it).load()
        }
    }
}