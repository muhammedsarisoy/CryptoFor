package com.example.cryptofor.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.cryptofor.ui.ui.theme.MyappTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.cryptofor.R
import com.example.cryptofor.ui.ui.navigation.BottomNavigationBar
import com.example.cryptofor.ui.ui.navigation.NavigationGraph
import com.example.cryptofor.ui.ui.navigation.favoriteScreen
import com.example.cryptofor.ui.ui.navigation.homeScreen
import com.example.cryptofor.ui.ui.navigation.profileScreen
import com.example.cryptofor.ui.ui.navigation.searchScreen
import com.example.cryptofor.ui.ui.navigation.settingsScreen

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {

        val firaSansFamily = FontFamily(
            Font(
                R.font.font_topbar , FontWeight.Bold
            )
        )

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface(color = MaterialTheme.colorScheme.background){
                MyappTheme {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = {
                            TopAppBar(
                                title = {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .border(
                                                width = 1.dp,
                                                color = Color.Black,
                                                shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
                                            ),
                                        contentAlignment = Alignment.Center

                                    ) {
                                        Text(
                                            text = buildAnnotatedString {
                                                withStyle(style = SpanStyle(color = Color.Black, fontWeight = FontWeight.Bold)) {
                                                    append("Crypto ")
                                                }
                                                withStyle(style = SpanStyle(color = Color.Green, fontWeight = FontWeight.Bold)) {
                                                    append("For")
                                                }
                                            },

                                            maxLines = 1,
                                            fontFamily = firaSansFamily,
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 24.sp
                                        )
                                    }
                                },

                                actions = {
                                    IconButton(
                                        onClick = {

                                        },
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.ic_settings),
                                            contentDescription = "Settings"
                                        )
                                    }
                                }
                            )
                        },

                        bottomBar = {
                            BottomNavigationBar(
                                navController = rememberNavController(),
                                items = listOf(
                                    homeScreen,
                                    searchScreen,
                                    favoriteScreen,
                                    profileScreen,
                                    settingsScreen
                                ),
                                modifier = Modifier.height(100.dp),
                            )
                        },

                        content = { innerPadding ->
                            NavigationGraph(
                                navController = rememberNavController(),
                                modifier = Modifier.padding(innerPadding),
                            )
                        }
                    )
                }
            }
        }
    }
}

