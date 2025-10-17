package com.example.epiceats.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.epiceats.R
import com.example.epiceats.presentation.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarDiningScreen(scrollBehavior: TopAppBarScrollBehavior, navController: NavController){
    val collapsedFraction = scrollBehavior.state.collapsedFraction

    //Content Color transitions fro White(on deep blue) to Black (on Light Background)
    val contentColor = lerp(
        Color.White,
        Color.Transparent,
        collapsedFraction
    )

    //Apply Alpha to fade content when scrolling
    val contentAlpha = 1f - collapsedFraction


    TopAppBar(
        title = {
            Column(modifier = Modifier.alpha(contentAlpha)){
                Row(modifier = Modifier.fillMaxWidth().height(22.dp))
                {
                    Text(text="Home", fontSize = 20.sp,color = contentColor, fontWeight = FontWeight.Bold)
                    Icon(painter = painterResource(R.drawable.down_arrow),
                        modifier = Modifier.size(30.dp).padding(top = 6.dp),
                        tint = contentColor,
                        contentDescription = "Down Arrow"
                    )
                }
                Text(text = "Hostel J, Prem Nagar, Thapar University",
                    fontWeight = FontWeight.SemiBold,
                    color = contentColor,
                    fontSize = 15.sp)
            }
        },
        navigationIcon = {
            Icon(painter = painterResource(R.drawable.locationdeliveryscreen),
                modifier = Modifier.size(30.dp),
                tint = contentColor,
                contentDescription = "Location"
            )
        },
        actions = {
            IconButton(onClick ={
                navController.navigate(Routes.ProfileScreen)
            }) {
                Icon(
                    painter = painterResource(R.drawable.profile),
                    tint = contentColor,
                    contentDescription = "Profile"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(Color.Transparent),
        scrollBehavior = scrollBehavior,
        modifier = Modifier.fillMaxWidth(),
    )
}