package elmeniawy.eslam.dailypulse.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import elmeniawy.eslam.dailypulse.SystemInfo

/**
 * SystemInfoScreen
 *
 * Created by Eslam El-Meniawy on 13-Jul-2025 at 3:41 PM.
 */

@Composable
fun SystemInfoScreen(onBackButtonClick: () -> Unit) {
    Column {
        Toolbar(onBackButtonClick)
        ContentView()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Toolbar(onBackButtonClick: () -> Unit) {
    TopAppBar(
        title = { Text(text = "System Info") },
        navigationIcon = {
            IconButton(onClick = onBackButtonClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back Button"
                )
            }
        }
    )
}

@Composable
private fun ContentView() {
    val items = makeItems()

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(items) { row ->
            RowView(title = row.first, subtitle = row.second)
        }
    }
}

private fun makeItems(): List<Pair<String, String?>> {
    val systemInfo = SystemInfo()
    systemInfo.logSystemInfo()

    return listOf(
        Pair(
            "Operating System",
            arrayOf(systemInfo.osName, systemInfo.osVersion).filterNotNull().joinToString(" ")
        ),
        Pair("Device", systemInfo.deviceModel),
        Pair("Density", systemInfo.density?.toString())
    )
}

@Composable
private fun RowView(title: String, subtitle: String?) {
    Column(Modifier.padding(8.dp)) {
        Text(text = title, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
        Text(text = subtitle ?: "", style = MaterialTheme.typography.bodyLarge)
    }

    HorizontalDivider()
}