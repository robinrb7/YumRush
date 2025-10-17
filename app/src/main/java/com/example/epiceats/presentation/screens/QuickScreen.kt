package com.example.epiceats.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.epiceats.R
import com.example.epiceats.presentation.components.HomeScreenCards
import com.example.epiceats.presentation.components.TopAppBarDiningScreen
import com.example.epiceats.presentation.utils.BottomSheetToAddProduct

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuickScreen(navController: NavController, listState: LazyListState){
    val scrollBehaviour = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    var showBottomSheet = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBarDiningScreen(scrollBehaviour,navController)
        }
    ) { innerPadding ->
        LazyColumn(contentPadding = PaddingValues(vertical = 0.dp),
            state = listState,
            modifier = Modifier.fillMaxSize().background(color = Color.White)
                .padding(bottom = innerPadding.calculateBottomPadding())
                .nestedScroll(scrollBehaviour.nestedScrollConnection)
            ){
            item{
                Box(modifier = Modifier.fillMaxWidth())
                {
                    Image(
                        painter = painterResource(R.drawable.quickbanner),
                        contentDescription = "Quick Screen",
                        modifier = Modifier.fillMaxSize().clip(shape = RoundedCornerShape(bottomStart = 15.dp, bottomEnd = 15.dp))
                    )
                }
            }

            item{
                LazyRow(modifier = Modifier.fillMaxWidth()) {
                    items(6){
                        QuickScreenComponents(navController,onAddClick = {showBottomSheet.value = true})
                    }
                }
                if(showBottomSheet.value){
                    BottomSheetToAddProduct(
                        onDismiss = {showBottomSheet.value = false},
                        navController = navController
                    )
                }
            }

            items(5){
                Spacer(modifier = Modifier.height(16.dp))
                HomeScreenCards(navController)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }

    }
}

@Composable
fun QuickScreenComponents(navController: NavController,onAddClick: () -> Unit){
    var productName by remember{ mutableStateOf("Peri Peri Burger")}
    var rating by remember{ mutableStateOf("4.2")}
    var price by remember{ mutableStateOf("₹249")}

    Card(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ){
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 5.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Column(modifier = Modifier.width(200.dp)){
                Row(
                    modifier = Modifier.wrapContentSize().padding(start = 2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        painter = painterResource(id = R.drawable.veg_icon),
                        contentDescription = null,
                        tint = colorResource(R.color.ViewActivityClickableColor),
                        modifier = Modifier.size(17.dp)
                    )
                    Card(
                        modifier = Modifier
                            .padding(start = 8.dp),
                        shape = RoundedCornerShape(5.dp),
                        colors = CardDefaults.cardColors(containerColor = colorResource(R.color.completecentageback).copy(alpha = 0.1f))
                    ){
                        Text(
                            text = "BestSeller",
                            modifier = Modifier.padding(horizontal = 3.dp),
                            color = colorResource(R.color.percentage),
                            fontSize = 11.sp,
                        )
                    }
                }

                Text(
                    text = productName,
                    modifier = Modifier.padding(horizontal = 1.dp,vertical = 8.dp),
                    color = colorResource(R.color.black),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Card(
                    modifier = Modifier.size(width = 50.dp,height = 22.dp),
                    shape = RoundedCornerShape(6.dp),
                    colors = CardDefaults.cardColors(containerColor = colorResource(R.color.ViewActivityClickableColor))
                ){
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    )  {
                        Text(
                            text = rating,
                            modifier = Modifier.padding(start = 3.dp,top = 2.dp),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.padding(start = 3.dp,top = 2.dp,end = 3.dp)
                                .size(12.dp)
                        )
                    }
                }

                Text(
                    text = price,
                    modifier = Modifier.padding(horizontal = 1.dp,vertical = 8.dp),
                    fontSize = 16.sp,
                    color = colorResource(R.color.black)
                )
            }
            Box(modifier = Modifier.size(160.dp),
                contentAlignment = Alignment.Center
            ){
                Image(
                    painter = painterResource(id = R.drawable.burger3),
                    contentDescription = "Product Image",
                    alignment = Alignment.Center,
                    modifier = Modifier.size(120.dp).clip(shape = RoundedCornerShape(15.dp))
                )
                Card(
                    onClick = {
                        onAddClick()
                    },
                    modifier = Modifier.padding(horizontal = 20.dp)
                        .padding(top = 120.dp).size(width = 100.dp,height = 36.dp),
                    shape = RoundedCornerShape(5.dp),
                    colors = CardDefaults.cardColors(containerColor = colorResource(R.color.lightPink)),
                    border = BorderStroke(width = 1.dp, color = colorResource(R.color.redish))
                ){
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "ADD",
                            modifier = Modifier.padding(start = 30.dp,top = 6.dp),
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = colorResource(R.color.redish)
                        )

                        Icon(
                            painter = painterResource(id = R.drawable.baseline_add_24),
                            contentDescription = "Add item",
                            tint = Color.Red,
                            modifier = Modifier.padding(3.dp).size(12.dp)
                        )
                    }
                }
            }
        }
    }
}