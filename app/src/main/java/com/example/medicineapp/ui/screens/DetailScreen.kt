package com.example.medicineapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.medicineapp.ui.screens.homescreen.getGreeting
import com.example.medicineapp.ui.util.model.AssociatedDrug


@Composable
fun DetailScreen(associatedDrug: AssociatedDrug) {
    Column(modifier = Modifier.fillMaxSize()
        .padding(vertical = 20.dp, horizontal = 20.dp)
    ){
        Text(
            text = "Item Detail",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        MakeUi(associatedDrug = associatedDrug)
    }
}

@Composable
fun MakeUi(associatedDrug: AssociatedDrug) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
    ) {
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