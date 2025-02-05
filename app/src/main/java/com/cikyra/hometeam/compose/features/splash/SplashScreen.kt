package com.cikyra.hometeam.compose.features.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.layout.size
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import com.cikyra.hometeam.R
import androidx.compose.foundation.layout.padding


@Composable
fun SplashScreen(
    onLetsGoClicked: (id: String) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                modifier = Modifier.size(250.dp),
                painter = painterResource(id = R.drawable.team_stacked_redblack),
                contentDescription = "TMA Logo"
            )
        }
        Text("We Believe\nYou Belong",
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        )

        Button(onClick = { 
            onLetsGoClicked("My Cool ID") 
        },
            modifier = Modifier.padding(top = 200.dp)
                .align(alignment = Alignment.CenterHorizontally)
                .size(width = 330.dp, height = 60.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )) {
            Text("Let's Go",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold)
        }
    }

}