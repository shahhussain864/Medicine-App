package com.example.medicineapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.medicineapp.ui.screens.DetailScreen
import com.example.medicineapp.ui.screens.homescreen.HomeScreen
import com.example.medicineapp.ui.screens.login.LogInScreen
import com.example.medicineapp.ui.theme.MedicineAppTheme
import com.example.medicineapp.ui.util.model.AssociatedDrug
import com.sendcredit.ui.navigation.DetailScreenRoute
import com.sendcredit.ui.navigation.LogInScreenRoute
import com.sendcredit.ui.navigation.MainScreenRoute

@Composable
fun SendCreditApp() {
    MedicineAppTheme {
        val navController = rememberNavController()
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry.value?.destination?.route


        Surface(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxSize()
        ) {

            NavHost(
                modifier = Modifier.fillMaxSize(),
                navController = navController,
                startDestination = LogInScreenRoute
            ) {

                composable<LogInScreenRoute> {
                    LogInScreen(navigateToHome = {
                        navController.navigate(MainScreenRoute)
                    })
                }

                composable<DetailScreenRoute> {
                    val params:DetailScreenRoute=it.toRoute()
                    DetailScreen(AssociatedDrug(name = params.name , dose = params.dose , strength = params.strength))
                }

                composable<MainScreenRoute> {
                    HomeScreen(navigateToDetailPager = {
                        navController.navigate(DetailScreenRoute(name = it.name?:"", dose = it.dose?:"" , strength = it.strength?:""))
                    })
                }




            }
        }
    }



}
