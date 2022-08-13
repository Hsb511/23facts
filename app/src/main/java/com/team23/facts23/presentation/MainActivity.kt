package com.team23.facts23.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.team23.fact.presentation.viewobjects.FactDetailVO
import com.team23.fact.presentation.views.FactDetail
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FactDetail(
                FactDetailVO(
                    title = "The Birthday Paradox",
                    category = "Mathematics",
                    imageUrl = "https://images.unsplash.com/photo-1602631985686-1bb0e6a8696e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80",
                    description = "The birthday paradox is that, counterintuitively, the probability of a shared birthday exceeds 50% in a group of only 23 people.",
                    sources = listOf(
                        "https://en.wikipedia.org/wiki/Birthday_problem",
                        "https://pudding.cool/2018/04/birthday-paradox/",
                        "https://betterexplained.com/articles/understanding-the-birthday-paradox/"
                    )
                )
            )
        }
    }
}
