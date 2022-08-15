package com.team23.facts23.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.team23.fact.presentation.viewobjects.FactDetailVO
import com.team23.fact.presentation.views.FactDetail
import com.team23.facts23.presentation.themes.Facts23Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Facts23Theme {
                FactDetail(
                    FactDetailVO(
                        id = "#46",
                        title = "The Birthday Paradox",
                        category = "Mathematics",
                        imageUrl = "https://images.unsplash.com/photo-1602631985686-1bb0e6a8696e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80",
                        description = "In a room of just 23 people there's a 50-50 chance of at least two people having the same birthday. \n" +
                                "In mathematics this is called the Birthday Paradox because we expect probabilities to be linear by only considering the scenarios we're involved in. \n\n" +
                                "We assume there are 365 equiprobable birthdays. The probability that each person has a unique birthday is: 364/365*363/365*...*343/365 ~ 0.4927. \n" +
                                "A contrario the probability that at least two persons share the same birthday is ~ 50.73%",
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
}
