package com.example.medicineapp.ui.screens.homescreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.medicineapp.ui.util.model.AssociatedDrug
import com.example.medicineapp.ui.util.model.MedicineLIst
import com.example.medicineapp.ui.util.model.Problem
import java.util.Calendar

@Preview
@Composable
fun HomeScreen(navigateToDetailPager: (AssociatedDrug) -> Unit = {}) {
    val homeViewModel: HomeViewModel = hiltViewModel()
    val userData = homeViewModel.userInfo
    val isDataLoaded = homeViewModel.isDataLoaded
    Column(
        Modifier
            .fillMaxSize()
            .padding(vertical = 20.dp, horizontal = 20.dp)
    ) {
        Text(
            text = getGreeting() + " " + userData.value?.name,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        MakeList(isDataLoaded = isDataLoaded.value, data = homeViewModel.medicineData.value) {
            navigateToDetailPager(it)
        }
    }
}

fun getGreeting(): String {
    val calendar = Calendar.getInstance()
    val hour = calendar.get(Calendar.HOUR_OF_DAY)

    return when (hour) {
        in 0..11 -> "Good morning"
        in 12..17 -> "Good afternoon"
        in 18..23 -> "Good evening"
        else -> "Hello" // Default greeting
    }
}

@Composable
fun MakeList(
    isDataLoaded: Boolean,
    data: MedicineLIst?,
    onClickItem: (AssociatedDrug) -> Unit = {}
) {
    if (isDataLoaded) {
        if (data != null && data.problems?.isNotEmpty() == true) {

            LazyColumn(Modifier.fillMaxWidth()) {

                data.problems.get(0).Diabetes?.get(0)?.medications?.get(0)?.medicationsClasses?.get(
                    0
                )?.className?.forEach {
                    it.associatedDrug?.forEach {
                        item{
                            MakeListItem(it, onClickItem = onClickItem)

                        }
                    }
                    it.associatedDrug2?.forEach {
                        item {
                            MakeListItem(it, onClickItem = onClickItem)
                        }

                    }


                }

                data.problems.get(0).Diabetes?.get(0)?.medications?.get(0)?.medicationsClasses?.get(
                    0
                )?.className2?.forEach {
                    it.associatedDrug?.forEach {
                        item{
                            MakeListItem(it, onClickItem = onClickItem)

                        }
                    }
                    it.associatedDrug2?.forEach {
                        item {
                            MakeListItem(it, onClickItem = onClickItem)
                        }

                    }

                }

            }
        } else {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Unable to get data")
            }
        }
    } else {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
}

@Composable
fun MakeListItem(associatedDrug: AssociatedDrug, onClickItem: (AssociatedDrug) -> Unit = {}) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 10.dp)
        .clickable {
            onClickItem(associatedDrug)
        }) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 15.dp)
        ) {
            val (name, dose, strength) = createRefs()
            Text(text = associatedDrug.name ?: "", modifier = Modifier.constrainAs(name) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            }, fontWeight = FontWeight.Medium, fontSize = 18.sp)
            Text(text = associatedDrug.dose ?: "", modifier = Modifier.constrainAs(dose) {
                top.linkTo(name.bottom)
                start.linkTo(parent.start)
            })
            Text(text = associatedDrug.strength ?: "", modifier = Modifier.constrainAs(strength) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            }, fontWeight = FontWeight.Medium)
        }
    }
}
