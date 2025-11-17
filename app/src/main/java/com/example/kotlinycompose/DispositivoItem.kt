package com.example.kotlinycompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlinycompose.ui.theme.KotlinyComposeTheme
import com.example.kotlinycompose.ui.theme.Typography
import java.security.KeyStore

@Composable
fun DeviceView(device: Dispositivos){
    Row (verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(end = 8.dp, top = 8.dp)){
        Icon(imageVector = Icons.Default.Phone, contentDescription = null,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp))
        Column {
            Text(text = device.name,
                style = Typography.headlineMedium
            )
            device.data?.let{especificaciones ->

                if(especificaciones.color!=null){
                    Text(text = especificaciones.color,
                        style = Typography.bodyMedium)

                }
                if (especificaciones.capacity!=null){
                    Text(text = especificaciones.capacity,
                        style = Typography.bodyMedium)

                }

            }


            HorizontalDivider()
        }

    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DispositivosItemPreview(){
    KotlinyComposeTheme {
        DeviceView(device = Dispositivos(id = 1, name = "Nexus", Especificaciones(color = "Black", capacity = "64 GB")))
    }
}

