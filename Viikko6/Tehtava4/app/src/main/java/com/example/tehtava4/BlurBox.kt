package com.example.tehtava4

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun BlurBox() {
    Box {
        ElevatedCard(
            elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
            modifier = Modifier
                .blur(
                    radius = 40.dp,
                    edgeTreatment = BlurredEdgeTreatment(RoundedCornerShape(20.dp))
                )
        ) {
            Box(
                modifier = Modifier
                    .paint(
                        painter = painterResource(id = R.drawable.color_background),
                        contentScale = ContentScale.Crop
                    )
            )
        }
    }
}