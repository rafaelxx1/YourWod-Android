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
import androidx.core.content.ContextCompat
import com.example.yourwod.databinding.MainYourwodActivityBinding
import com.example.yourwod.ui.activity.PrList
import com.example.yourwod.ui.activity.WodList
import android.Manifest
import android.content.pm.PackageManager
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat


class MainActivity : AppCompatActivity() {

    private val binding by lazy { MainYourwodActivityBinding.inflate(layoutInflater) }
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configureBtnWodList()
        configureBtnPrList()
        verifyPhotoPermission()
        selectProfilePhoto()
        setContentView(binding.root)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permissão concedida, agora você pode abrir a galeria
            } else {
                // Permissão negada, você pode exibir uma mensagem ou tomar outra ação apropriada
            }
        }
    }

    private fun selectProfilePhoto() {
        imageView = binding.imageView
        val btnSelectPhoto = binding.imageView

        val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            uri?.let { imgUri -> imageView.setImageURI(imgUri) }
        }

        btnSelectPhoto.setOnClickListener {
            getContent.launch("image/*")
        }
    }

    private fun verifyPhotoPermission() {
        if (ContextCompat.checkSelfPermission(
                this, Manifest.permission.READ_EXTERNAL_STORAGE
            )
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                PERMISSION_REQUEST_CODE
            )
        }
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

    companion object {
        private const val PERMISSION_REQUEST_CODE = 123
    }

}