package com.team23.facts23.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import com.team23.fact.presentation.viewmodels.FactDetailVM
import com.team23.facts23.presentation.themes.Facts23Theme
import com.team23.facts23.presentation.views.NavigationView
import com.team23.home.presentation.viewmodels.HomeVM
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var viewModelAssistedFactory: FactDetailVM.Factory

    private val factDetailVM: FactDetailVM by viewModels {
        FactDetailVM.provideFactory(
            viewModelAssistedFactory,
            listOf(46..276 step 23).flatten().map{it.toString() }.random()
        )
    }
    private val homeVM: HomeVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Facts23Theme {
                NavigationView(factDetailVM, homeVM)
            }
        }
    }
}
