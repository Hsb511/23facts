package com.team23.facts23.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import com.team23.fact.presentation.viewmodels.FactDetailVM
import com.team23.facts23.presentation.themes.Facts23Theme
import com.team23.facts23.presentation.views.NavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    private val factDetailVM: FactDetailVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Facts23Theme {
                NavigationView(factDetailVM)
            }
        }
    }
}
