package com.cikyra.hometeam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(modifier= Modifier.fillMaxSize()) { innerPadding ->

                Column(verticalArrangement = Arrangement.Center,
                    modifier=Modifier.padding(innerPadding)
                        .fillMaxWidth()) {
                    Row(modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly){
                        Image(
                            modifier = Modifier.size(250.dp),
                            painter = painterResource(id = R.drawable.team_stacked_redblack),
                            contentDescription = "TMA Logo"
                        )

                    }
                    Text("We Believe\nYou Belong",
                        fontSize = 50.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.align(alignment = Alignment.CenterHorizontally))

                    Button(onClick = {},
                        modifier = Modifier.padding(top = 200.dp)
                            .align(alignment = Alignment.CenterHorizontally)
                            .size(width = 330.dp, height = 60.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFD14C4C) //don't know where to put color values to be able to use them globally
                        )) {
                        Text("Let's Go",
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold)
                    }
                }

            }

        }
    }
}