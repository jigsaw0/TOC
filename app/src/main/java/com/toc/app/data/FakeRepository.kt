package com.toc.app.data

import com.toc.app.domain.DailyEntry
import com.toc.app.domain.ExposureTask
import com.toc.app.domain.SafetyContact
import java.time.LocalDate

object FakeRepository {
    fun sampleEntries(): List<DailyEntry> = listOf(
        DailyEntry(LocalDate.now().minusDays(2), 8, "Contaminación", 70, "Mucho lavado de manos"),
        DailyEntry(LocalDate.now().minusDays(1), 6, "Duda", 40, "Revisé cerraduras varias veces"),
        DailyEntry(LocalDate.now(), 5, "Orden", 25, "Pude frenar un ritual"),
    )

    fun sampleExposureTasks(): List<ExposureTask> = listOf(
        ExposureTask(1, "Tocar perilla sin limpiar por 2 min", level = 2, targetMinutes = 2),
        ExposureTask(2, "Salir sin revisar la puerta 3 veces", level = 3, targetMinutes = 5),
        ExposureTask(3, "Aceptar incertidumbre en una decisión", level = 4, targetMinutes = 8),
    )

    fun safetyContacts(): List<SafetyContact> = listOf(
        SafetyContact("Persona de apoyo", "+52 55 0000 0000"),
        SafetyContact("Línea de emergencia", "911"),
    )
}
