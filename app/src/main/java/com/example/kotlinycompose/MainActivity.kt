package com.example.kotlinycompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.example.kotlinycompose.ui.theme.KotlinyComposeTheme
import com.google.gson.Gson
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinyComposeTheme {
                var devices by remember{ mutableStateOf(listOf<Dispositivos>()) }

                LaunchedEffect(key1=true) {
                    getDevices { result->
                        devices=result
                    }
                }


                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainView(
                        modifier = Modifier.padding(innerPadding),
                        devices = devices
                    )
                }
            }
        }
    }

    private fun getDevices(onResult: (List<Dispositivos>)-> Unit){
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(DeviceService::class.java)
        lifecycleScope.launch {
            try {
                val devices=service.getAllDevices()
                onResult(devices)
                Log.d("API_SUCCESS","Datos Recibidos Correctamente ")
            }catch (e: Exception){
                onResult(emptyList())
                Log.e("API_ERROR","Error al obtener los datos ${e.message}")
                e.printStackTrace()
            }

        }
    }

}

