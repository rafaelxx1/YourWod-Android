package com.example.yourwod

import android.content.Intent
import android.os.Bundle
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
import com.example.yourwod.ui.activity.PrList
import com.example.yourwod.ui.activity.WodList
import com.example.yourwod.ui.theme.Typography

class MainActivity : AppCompatActivity(R.layout.main_yourwod_activity) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configureBtnWodList()
        configureBtnPrList()
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
        val btnWodList = findViewById<Button>(R.id.btn_wod_list)

        btnWodList.setOnClickListener {
            goToWodList()
        }
    }

    private fun configureBtnPrList() {
        val btnPrList = findViewById<Button>(R.id.btn_pr_list)

        btnPrList.setOnClickListener {
            goToPrList()
        }
    }

}