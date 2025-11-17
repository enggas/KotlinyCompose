package com.example.kotlinycompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlinycompose.ui.theme.KotlinyComposeTheme
import com.example.kotlinycompose.ui.theme.Typography

@Composable
fun MainView(modifier: Modifier, devices: List<Dispositivos>){
    Column {
        Text(text = "Comprar", modifier= modifier.fillMaxWidth(),
            style = Typography.displayMedium,
            textAlign = TextAlign.Center
        )

        LazyColumn{
            items(devices.size){ index ->
                DeviceView(devices[index])
            }
        }

    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainPreview() {
    KotlinyComposeTheme {
        MainView(Modifier.padding(top = 24.dp), listOf(
            Dispositivos(id = 1, name = "Nexus", Especificaciones(color = "Black", capacity = "64 GB")),
            Dispositivos(id = 2, name = "Samsung", Especificaciones(color =null, capacity = null))
        ))
    }
}