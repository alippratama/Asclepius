package com.dicoding.asclepius.view

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.asclepius.R
import com.dicoding.asclepius.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layoutManager = LinearLayoutManager(this)
        binding.rvArticle.layoutManager = layoutManager

        val imageUriString = intent.getStringExtra("image_uri")

        val result = intent.getStringArrayExtra(EXTRA_RESULT)
        result?.let {
            Log.d("RESULT", "showResult: $it")
            binding.resultTextOne.text = "Prediksi :\n${it[0]}"
            binding.resultTextTwo.text = "Skor kepercayaan : ${it[1]}"
        }

        imageUriString?.let { uri ->
            val imageUri = Uri.parse(uri)
            binding.resultImage.setImageURI(imageUri)
        } ?: run {
            binding.resultImage.setImageResource(R.drawable.ic_place_holder)
        }




//        fetchArticles()
    }
    companion object {
        const val EXTRA_IMAGE_URI = "extra_image_uri"
        const val EXTRA_RESULT = "extra_result"
    }


    private fun showImage(uri: Uri) {
        Log.d("Gambar URI", "Menampilkan Gambar: $uri")
        binding.resultImage.setImageURI(uri)
    }

    private fun showResult(result: Array<String>) {
        Log.d("HASIL", "Menampilkan Hasil: ${result.asList()}")
        binding.resultTextOne.text = "Prediksi :\n${result[0]}"
        binding.resultTextTwo.text = "Skor kepercayaan : ${result[1]}"
    }
//
//    private fun fetchArticles() {
//        displayLoading(true)
//        val client = ApiConfig.getApiService().getArticle()
//        client.enqueue(object : Callback<CancerResponse> {
//            override fun onResponse(
//                call: Call<CancerResponse>,
//                response: Response<CancerResponse>,
//            ) {
//                displayLoading(false)
//                if (response.isSuccessful) {
//                    val responseBody = response.body()
//                    responseBody?.let { setArticle(it.articles) }
//                } else {
//                    Log.e("MainActivity", "Gagal: ${response.message()}")
//                }
//            }
//
//            override fun onFailure(call: Call<CancerResponse>, t: Throwable) {
//                displayLoading(false)
//                Log.e("MainActivity", "Gagal: ${t.message}")
//            }
//        })
//    }
//
//    private fun setArticle(article: List<ArticlesItem?>) {
//        val adapter = ArticleAdapter()
//        adapter.submitList(article)
//        binding.rvArticle.adapter = adapter
//    }

    private fun displayLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }


}


