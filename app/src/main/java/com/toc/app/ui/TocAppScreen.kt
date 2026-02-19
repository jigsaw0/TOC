package com.toc.app.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.toc.app.data.FakeRepository

@Composable
fun TocAppScreen() {
    val entries = FakeRepository.sampleEntries()
    val tasks = FakeRepository.sampleExposureTasks()
    val contacts = FakeRepository.safetyContacts()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("TOC App · MVP") })
        },
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            item {
                SectionCard(
                    title = "Registro diario",
                    subtitle = "Ansiedad media ${entries.map { it.anxietyLevel }.average().toInt()}/10",
                ) {
                    entries.forEach {
                        Text("• ${it.date}: ansiedad ${it.anxietyLevel}/10, ritual ${it.compulsionMinutes} min")
                    }
                }
            }

            item {
                SectionCard(
                    title = "Exposiciones ERP",
                    subtitle = "Plan sugerido por niveles",
                ) {
                    tasks.forEach {
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                            Text(it.title, modifier = Modifier.weight(1f))
                            AssistChip(onClick = {}, label = { Text("Nivel ${it.level}") })
                        }
                    }
                }
            }

            item {
                SectionCard(
                    title = "Plan de seguridad",
                    subtitle = "Acceso rápido a apoyo",
                ) {
                    contacts.forEach {
                        Text("• ${it.name}: ${it.phone}")
                    }
                    Text(
                        text = "Nota: esta app no reemplaza tratamiento profesional.",
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
        }
    }
}

@Composable
private fun SectionCard(
    title: String,
    subtitle: String,
    content: @Composable () -> Unit,
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text(text = title, style = MaterialTheme.typography.titleMedium)
            Text(text = subtitle, style = MaterialTheme.typography.bodyMedium)
            content()
        }
    }
}
