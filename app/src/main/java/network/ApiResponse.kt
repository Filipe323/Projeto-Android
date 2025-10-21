package com.example.aplicaoopiniopt01.network
import com.example.aplicaoopiniopt01.model.Game

data class ApiResponse(
    val applist: AppList
)

data class AppList(
    val apps: List<Game>
)
