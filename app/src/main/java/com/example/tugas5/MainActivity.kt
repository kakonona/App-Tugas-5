package com.example.tugas5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.tugas5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[CounterViewModel::class.java]

        viewModel.counter.observe(this) { value ->
            binding.tvResult.text = "Total Klik: $value"
        }

        binding.btnTap.setOnClickListener {
            viewModel.increase()
        }

        binding.btnReset.setOnClickListener {
            viewModel.reset()
        }
    }
}
