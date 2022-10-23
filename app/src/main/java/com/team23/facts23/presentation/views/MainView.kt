package com.team23.facts23.presentation.views

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.team23.achievements.R
import com.team23.achievements.presentation.viewmodels.AchievementVM
import com.team23.achievements.presentation.viewobjects.AchievementPreviewVO
import com.team23.core.domain.Screen
import com.team23.fact.presentation.viewmodels.FactDetailVM
import com.team23.home.presentation.viewmodels.HomeVM
import kotlinx.coroutines.launch

@Composable
fun MainView(
    factDetailVM: FactDetailVM,
    homeVM: HomeVM,
    achievementVM: AchievementVM,
    navController: NavHostController,
    currentScreen: Screen,
    lastScreen: Screen,
    isMenuExpanded: MutableState<Boolean>,
    content: @Composable (PaddingValues) -> Unit,
) {
    MainView(
        achievementPreview = achievementVM.achievementPreviewToDisplay,
        onSnackbarClicked = { navController.navigate(Screen.Achievement().route) },
        onNavigateHome = {
            factDetailVM.factDetail.value = null
            navController.navigate(Screen.Home().route)
        },
        onNavigateRandom = {
            factDetailVM.loadFactDetail("-1")
            navController.navigate(Screen.Random().route)
        },
        onNavigateSearch = {
            navController.navigate(Screen.Search().route)
        },
        onBackPressed = {
            when (currentScreen) {
                is Screen.Random -> {
                    factDetailVM.factDetail.value = null
                    navController.navigate(lastScreen.route)
                }
                is Screen.Category -> {
                    factDetailVM.factDetail.value = null
                    navController.popBackStack()
                }
                else -> {
                    navController.popBackStack()
                }
            }
        },
        codeCategory = factDetailVM.factDetail.value?.category?.code?.ifBlank { null }
            ?: homeVM.selectedCategory.value?.code,
        nameCategory = factDetailVM.factDetail.value?.category?.name?.ifBlank { null }
            ?: homeVM.selectedCategory.value?.title,
        shortNameCategory = factDetailVM.factDetail.value?.category?.shortName?.ifBlank { null }
            ?: homeVM.selectedCategory.value?.shortTitle,
        factId = factDetailVM.factId,
        onAppIconClicked = { achievementVM.onAppIconClicked() },
        currentScreen = currentScreen,
        isMenuExpanded = isMenuExpanded,
        onNavigate = { screen -> navController.navigate(screen.route) },
        content = content,
    )
}

@Composable
fun MainView(
    achievementPreview: MutableState<AchievementPreviewVO?>,
    onSnackbarClicked: () -> Unit,
    onNavigateHome: () -> Unit,
    onNavigateRandom: () -> Unit,
    onNavigateSearch: () -> Unit,
    onBackPressed: () -> Unit,
    codeCategory: String?,
    nameCategory: String?,
    shortNameCategory: String?,
    factId: String?,
    onAppIconClicked: () -> Unit,
    currentScreen: Screen,
    isMenuExpanded: MutableState<Boolean>,
    onNavigate: (Screen) -> Unit,
    content: @Composable (PaddingValues) -> Unit,
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    Scaffold(
        snackbarHost = {
            achievementPreview.value?.let { achievement ->
                SnackbarHost(
                    hostState = snackbarHostState,
                    snackbar = {
                        Snackbar(
                            achievementPreview = achievement,
                            onSnackbarClicked = { onSnackbarClicked() }
                        )
                    }
                )
                scope.launch {
                    snackbarHostState.showSnackbar(achievement.messageResId.toString())
                    achievementPreview.value = null
                }
            }
        },
        bottomBar = {
            BottomAppBar(
                pageIndex = currentScreen.pageIndex,
                onNavigateHome = { onNavigateHome() },
                onNavigateRandom = { onNavigateRandom() },
                onNavigateSearch = { onNavigateSearch() }
            )
        },
        topBar = {
            TopAppBar(
                screen = currentScreen,
                isMenuExpanded = isMenuExpanded,
                onBackPressed = { onBackPressed() },
                codeCategory = codeCategory,
                nameCategory = nameCategory,
                shortNameCategory = shortNameCategory,
                factId = factId,
                onAppIconClicked = { onAppIconClicked() }
            )
            DropDownMenu(isMenuExpanded = isMenuExpanded, onNavigate = { onNavigate(it) })
        },
        modifier = Modifier.fillMaxSize()
    ) { padding ->
        content(padding)
    }
}


@Composable
@Preview(showSystemUi = true)
fun MainPreview() {
    val achievementPreview: MutableState<AchievementPreviewVO?> = remember {
        mutableStateOf(
            AchievementPreviewVO(
                imageResId = R.drawable.iconophile,
                messageResId = R.string.achievements_iconophile_message
            )
        )
    }
    MainView(
        achievementPreview = achievementPreview,
        onSnackbarClicked = {},
        onNavigateHome = {},
        onNavigateRandom = {},
        onNavigateSearch = {},
        onBackPressed = {},
        codeCategory = "MA",
        nameCategory = "Mathematics",
        shortNameCategory = "Mathematics",
        factId = "23",
        onAppIconClicked = {},
        currentScreen = Screen.Fact(),
        isMenuExpanded = remember { mutableStateOf(false) },
        onNavigate = {},
        content = {},
    )
}