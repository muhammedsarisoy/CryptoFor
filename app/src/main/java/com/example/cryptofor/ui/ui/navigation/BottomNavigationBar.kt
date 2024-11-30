package com.example.cryptofor.ui.ui.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cryptofor.R
import com.example.cryptofor.ui.data.model.BottomNavigationBarData




val homeScreen = BottomNavigationBarData("Home", R.drawable.ic_home, "HomeScreen",R.drawable.ic_home , R.drawable.ic_home)
val searchScreen = BottomNavigationBarData("Search", R.drawable.ic_search, "SearchScreen",R.drawable.ic_search , R.drawable.ic_search)
val favoriteScreen = BottomNavigationBarData("Favorite", R.drawable.ic_favorite, "FavoriteScreen",R.drawable.ic_favorite, R.drawable.ic_favorite)
val profileScreen = BottomNavigationBarData("Profile", R.drawable.ic_profile, "ProfileScreen",R.drawable.ic_profile , R.drawable.ic_profile)
val settingsScreen = BottomNavigationBarData("Settings", R.drawable.ic_settings, "SettingsScreen",R.drawable.ic_settings , R.drawable.ic_settings)
val items = listOf(homeScreen, searchScreen, favoriteScreen, profileScreen, settingsScreen)




@Composable
fun BottomNavigationBar(
    navController: NavHostController,
    items: List<BottomNavigationBarData>,
    modifier: Modifier = Modifier
){
    var selectedBottomItem by  rememberSaveable { mutableIntStateOf(0) }
    var unSelectedBottomItem by rememberSaveable { mutableIntStateOf(0) }
    NavigationBar(
        modifier = modifier,
        tonalElevation = 8.dp
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedBottomItem == index,
                onClick = {
                    selectedBottomItem = index
                    unSelectedBottomItem = index
                },
                icon = {
                    if (selectedBottomItem == index) {
                        Icon(
                            painter = painterResource(id = item.iconSelected),
                            contentDescription = item.title,
                            tint = androidx.compose.ui.graphics.Color.Green
                        )
                    } else {
                        Icon(
                            painter = painterResource(id = item.iconUnselected),
                            contentDescription = item.title
                        )
                    }
                },
                label = {
                    Text(text = item.title)
                }
            )
        }
    }
}


