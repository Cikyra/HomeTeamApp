package com.cikyra.hometeam.compose.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.cikyra.hometeam.R

// TODO: Build this component for real. Support multiple children
@Composable
fun MyWeekView() {
    Text(
        text = stringResource(R.string.my_week),
        style = MaterialTheme.typography.headlineMedium,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(bottom = 16.dp)
    )
    Row(
        modifier = Modifier.fillMaxWidth()
            .height(50.dp)
            .padding(top = 2.dp, bottom = 2.dp)
            .background(
                MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(12.dp)
            )
    ) {
        Text(
            text = "Thursday March 6 - 4:30pm",
            modifier = Modifier.align(Alignment.CenterVertically).padding(start = 8.dp),
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
    Row(
        modifier = Modifier.fillMaxWidth()
            .height(50.dp)
            .padding(top = 2.dp, bottom = 2.dp)
            .background(
                MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(12.dp)
            )
    ) {
        Text(
            text = "Friday March 7 - 5:30pm",
            modifier = Modifier.align(Alignment.CenterVertically).padding(start = 8.dp),
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
    Row(
        modifier = Modifier.fillMaxWidth()
            .height(50.dp)
            .padding(top = 2.dp, bottom = 2.dp)
            .background(
                MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(12.dp)
            )
    ) {
        Text(
            text = "Saturday March 8 - 3:30pm",
            modifier = Modifier.align(Alignment.CenterVertically).padding(start = 8.dp),
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}