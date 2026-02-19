package com.toc.app.domain

import java.time.LocalDate

data class DailyEntry(
    val date: LocalDate,
    val anxietyLevel: Int,
    val trigger: String,
    val compulsionMinutes: Int,
    val notes: String,
)

data class ExposureTask(
    val id: Int,
    val title: String,
    val level: Int,
    val targetMinutes: Int,
)

data class SafetyContact(
    val name: String,
    val phone: String,
)
