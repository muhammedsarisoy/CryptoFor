package com.example.cryptofor.ui.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    HomeContent()
}



@Composable
fun HomeContent(){
    Text(
        text = "Home",
        modifier = Modifier,
        maxLines = 1,
        fontSize = 35.sp
    )
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){

}
