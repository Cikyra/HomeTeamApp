package com.cikyra.hometeam.compose.composables

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.cikyra.hometeam.R

data class HomeTeamHeaderListViewItem(
    val id: String,
    val title: String,
    val subtitle: String,
)

@Composable
fun HomeTeamHeaderListView(
    header: String,
    items: List<HomeTeamHeaderListViewItem>,
    onItemClicked: (id: String) -> Unit,
    onArrowClicked: (() -> Unit)? = null,
    showArrow: Boolean = true
) {
    Column() {
        Row {
            Text(
                text = header,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth().weight(1f)
            )
            if (showArrow) {
                IconButton(
                    content = {
                        Icon(
                            painter = painterResource(R.drawable.arrow_forward),
                            contentDescription = stringResource(R.string.go_to_arrow)
                        )
                    },
                    modifier = Modifier.align(Alignment.CenterVertically),
                    onClick = {
                        onArrowClicked?.invoke()
                    },
                )
            }
        }
        for (i in 0..minOf(items.lastIndex, 3)) {
            Row {
                ListItem(
                    modifier = Modifier.fillMaxWidth().padding(4.dp).clickable {
                        onItemClicked(items[i].id)
                    },
                    headlineContent = { Text(text = items[i].title) },
                    supportingContent = { Text(text = items[i].subtitle) },
                )
            }
            if (i != minOf(items.lastIndex, 3)) {
                HorizontalDivider()
            }
        }
    }
}