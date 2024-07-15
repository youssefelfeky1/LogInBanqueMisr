package com.elfeky.loginbanquemisr.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.elfeky.loginbanquemisr.Service

@Composable
fun ServiceSection(
    modifier: Modifier = Modifier,
    serviceList: List<Service>
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,

    ) {
        serviceList.forEach { service ->
            ServiceItem(
                modifier = Modifier.width(88.dp),
                service = service
            )
        }
    }
}