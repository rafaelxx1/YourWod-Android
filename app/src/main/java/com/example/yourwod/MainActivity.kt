package com.example.yourwod

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.WindowManager
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.yourwod.databinding.MainYourwodActivityBinding
import com.example.yourwod.ui.activity.PrList
import com.example.yourwod.ui.activity.WodList


class MainActivity : AppCompatActivity() {

    private val binding by lazy { MainYourwodActivityBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configureBtnWodList()
        configureBtnPrList()

        setContentView(binding.root)
    }


    private fun goToWodList() {
        val intent = Intent(this, WodList::class.java)
        startActivity(intent)
    }

    private fun goToPrList() {
        val intent = Intent(this, PrList::class.java)
        startActivity(intent)
    }

    private fun configureBtnWodList() {
        val btnWodList = binding.btnWodList

        btnWodList.setOnClickListener {
            goToWodList()
        }
    }

    private fun configureBtnPrList() {
        val btnPrList = binding.btnPrList

        btnPrList.setOnClickListener {
            goToPrList()
        }
    }

}