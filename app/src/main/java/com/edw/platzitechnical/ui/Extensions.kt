package com.edw.platzitechnical.ui

import androidx.compose.runtime.Composable

@Composable
fun List<String>.lineBreak(separator: String = "\n"): String {
    return joinToString(separator = separator)
}