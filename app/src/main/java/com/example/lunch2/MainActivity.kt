package com.example.lunch2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lunch2.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val myRecyclerView by lazy {
        LunchAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = myRecyclerView
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }

        binding.btnGet.setOnClickListener {
            retrofitWork()
        }
    }

    private fun  retrofitWork() {
        val service = RetrofitApi.LunchService

        service.getLunchData(getString(R.string.api_key), "json")
            .enqueue(object : Callback<lunch> {
                override fun onResponse(
                    call: Call<lunch>,
                    response: Response<lunch>
                ) {
                    if (response.isSuccessful) {
                        Log.d("TAG", response.body().toString())
                        val result = response.body()?.mealServiceDietInfo?.get(1)?.row
                        myRecyclerView.submitList(result!!)
                    }
                }

                override fun onFailure(call: Call<lunch>, t:  Throwable) {
                    Log.d("TAG", t.message.toString())
                }
            })
    }
}