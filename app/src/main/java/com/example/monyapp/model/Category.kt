package com.example.monyapp.model

data class Category(
    val name: String,
    val icon: String // In a real app, this could be an icon resource ID or name
)

val defaultCategories = listOf(
    Category("Food", "🍔"),
    Category("Transport", "🚗"),
    Category("Shopping", "🛍️"),
    Category("Entertainment", "🎬"),
    Category("Rent", "🏠"),
    Category("Salary", "💰"),
    Category("General", "📦")
)
