package com.elfeky.loginbanquemisr.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elfeky.loginbanquemisr.Service

@Composable
fun ServiceItem(
    modifier: Modifier = Modifier,
    service: Service
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = service.iconId),
            contentDescription = service.title,
            modifier = Modifier.size(64.dp)
        )
        Text(
            text = service.title,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color = Color.Black


        )
    }
}