package com.example.epiceats.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.epiceats.R
import com.example.epiceats.presentation.utils.BottomSheetToAddProduct

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ParticularCardScreen(navController: NavController){
    var showBottomSheet = remember { mutableStateOf(false) }

    var firstName by remember { mutableStateOf("La Roma's") }
    var lastName by remember { mutableStateOf("Pizzeria") }
    var rating by remember { mutableStateOf("4.2") }
    var time by remember { mutableStateOf("37 mins") }
    var distance by remember { mutableStateOf("2.6 km") }
    var address by remember { mutableStateOf("Crossing Republic") }
    var uniqueness by remember { mutableStateOf("On time Preparation") }
    var discount by remember { mutableStateOf("Flat Rs50 OFF on above Rs249") }
    var offers by remember { mutableStateOf("2 offers") }
    var price by remember { mutableStateOf("₹249") }
    var productName by remember { mutableStateOf("Peri Peri Burger") }

    val scrollBehaviour = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    Scaffold(
        containerColor = colorResource(R.color.white),
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(Color.White),
                title = { },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            painter = painterResource(R.drawable.arrowback),
                            tint = Color.Black,
                            modifier = Modifier.size(28.dp),
                            contentDescription = "Back Navigation"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(R.drawable.outline_group_add_24),
                            tint = Color.Black,
                            modifier = Modifier.size(28.dp),
                            contentDescription = "Group Add"
                        )
                    }
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(R.drawable.outline_more_vert_24),
                            tint = Color.Black,
                            modifier = Modifier.size(28.dp),
                            contentDescription = "More menu"
                        )
                    }
                },
                scrollBehavior = scrollBehaviour
            )
        }
    ){innerPadding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().nestedScroll(scrollBehaviour.nestedScrollConnection)
                .padding(innerPadding)
        ){
            item{
                Column(modifier = Modifier.fillMaxWidth().background(color = Color.White).height(190.dp))
                {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                                .padding(horizontal = 8.dp, vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Column{
                            Text(
                                text = firstName,
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontSize = 25.sp
                            )
                            Row(verticalAlignment = Alignment.CenterVertically){
                                Text(
                                    text = lastName,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 25.sp
                                )
                                Spacer(modifier = Modifier.width(4.dp))

                                Icon(
                                    painter = painterResource(R.drawable.outline_info_24),
                                    tint = Color.Black,
                                    contentDescription = "Information"
                                )
                            }
                        }

                        Column{
                            Card(
                                modifier = Modifier.size(width = 55.dp,height = 30.dp),
                                shape = RoundedCornerShape(6.dp),
                                colors = CardDefaults.cardColors(colorResource(R.color.greendivider)),
                            ){
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceEvenly
                                ){
                                    Text(
                                        text = rating,
                                        modifier = Modifier.padding(start = 4.dp, top = 4.dp),
                                        color = Color.White,
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 18.sp
                                    )
                                    Icon(
                                        painter = painterResource(R.drawable.star),
                                        modifier = Modifier.padding(start = 5.dp, top = 2.dp, end = 4.dp)
                                            .size(18.dp),
                                        tint = Color.White,
                                        contentDescription = null
                                    )
                                }
                            }
                        }
                    }

                    Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp), verticalAlignment = Alignment.CenterVertically){
                        Icon(
                            painter = painterResource(R.drawable.timer),
                            modifier = Modifier.size(17.dp),
                            tint = Color.Green,
                            contentDescription = "timer Clock"
                        )
                        Text(
                            text = time,
                            fontSize = 14.sp,
                            color = Color.DarkGray,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                        Icon(
                            painter = painterResource(R.drawable.dot),
                            modifier = Modifier.size(16.dp),
                            tint = Color.DarkGray,
                            contentDescription = "dot"
                        )
                        Text(
                            text = distance,
                            fontSize = 14.sp,
                            color = Color.DarkGray,
                        )
                        Icon(
                            painter = painterResource(R.drawable.dot),
                            modifier = Modifier.size(16.dp),
                            tint = Color.DarkGray,
                            contentDescription = "dot"
                        )
                        Text(
                            text = address,
                            fontSize = 14.sp,
                            color = Color.DarkGray,
                        )
                        Icon(
                            painter = painterResource(R.drawable.down_arrow),
                            modifier = Modifier.padding(start = 2.dp).size(17.dp),
                            tint = Color.DarkGray,
                            contentDescription = "down arrow"
                        )
                    }

                    Card(modifier = Modifier.padding(start = 8.dp,8.dp).width(165.dp).height(22.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(Color.Gray.copy(alpha = 0.1f)))
                    {
                        Row(modifier = Modifier.fillMaxWidth()){
                            Icon(painterResource(R.drawable.check),
                                modifier = Modifier.padding(start = 8.dp,top = 6.dp).size(12.dp),
                                tint = colorResource(R.color.greyish8Black),
                                contentDescription = null)
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(text = uniqueness, color = Color.Gray, fontSize = 14.sp)
                        }
                    }

                    HorizontalDivider(modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 16.dp),
                        color = Color.Gray,
                        thickness = 1.dp)
                    Row(modifier = Modifier.fillMaxWidth().padding(top = 10.dp))
                    {
                        Icon(
                            painter = painterResource(R.drawable.discount),
                            modifier = Modifier.padding(start = 2.dp,top = 3.dp).size(16.dp),
                            tint = Color.Blue,
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.width(4.dp))

                        Text(
                            text = discount,
                            modifier = Modifier.padding(start = 4.dp),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.weight(1f))

                        Text(
                            text = offers,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Gray
                        )

                        Icon(
                            painter = painterResource(R.drawable.down_arrow),
                            modifier = Modifier.padding(start = 4.dp,top = 4.dp, end = 8.dp).size(16.dp),
                            tint = Color.Gray,
                            contentDescription = "down arrow"
                        )
                    }
                    HorizontalDivider(modifier = Modifier.padding( top = 10.dp),
                        color = Color.LightGray,
                        thickness = 5.dp)

                }


                Column(modifier = Modifier.fillMaxSize().padding(top = 8.dp).background(color = Color.White))
                {
                    Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp).padding(top = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween){

                        Text(
                            text = "Recommended for you",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Icon(
                            painter = painterResource(R.drawable.arrowup),
                            modifier = Modifier.size(16.dp),
                            tint = Color.DarkGray,
                            contentDescription = null
                        )
                    }

                    ItemsList(productName = productName, rating = rating, price = price,onAddClick = {showBottomSheet.value = true})
                    HorizontalDivider(modifier = Modifier.padding(horizontal = 8.dp, vertical = 14.dp),
                        thickness = 1.dp,
                        color = colorResource(R.color.lightPink))

                    ItemsList(productName = productName, rating = rating, price = price,onAddClick = {showBottomSheet.value = true})
                    HorizontalDivider(modifier = Modifier.padding(horizontal = 8.dp, vertical = 14.dp),
                        thickness = 1.dp,
                        color = colorResource(R.color.lightPink))

                    ItemsList(productName = productName, rating = rating, price = price,onAddClick = {showBottomSheet.value = true})
                    HorizontalDivider(modifier = Modifier.padding(horizontal = 8.dp, vertical = 14.dp),
                        thickness = 1.dp,
                        color = colorResource(R.color.lightPink))
                }

                if(showBottomSheet.value){
                    BottomSheetToAddProduct(
                        onDismiss = { showBottomSheet.value = false},
                        navController = navController
                    )
                }
            }
        }
    }
}

@Composable
fun ItemsList(
    productName: String,
    rating: String,
    price: String,
    onAddClick:() -> Unit
){
    Row(modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp, horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween){
        Column(modifier = Modifier.width(200.dp)){
            Row(modifier = Modifier.wrapContentSize().padding(start = 2.dp),
                verticalAlignment = Alignment.CenterVertically){
                Icon(
                    painter = painterResource(R.drawable.veg_icon),
                    modifier = Modifier.size(17.dp),
                    tint = colorResource(R.color.ViewActivityClickableColor),
                    contentDescription = null
                )
                Card(modifier = Modifier
                    .padding(start = 8.dp),
                    shape = RoundedCornerShape(5.dp),
                    colors = CardDefaults.cardColors(containerColor = colorResource(R.color.percentage).copy(alpha = 0.1f))
                ){
                    Text(
                        text = "Bestseller",
                        modifier = Modifier.padding(horizontal = 3.dp),
                        fontSize = 11.sp,
                        color = colorResource(R.color.ZomatoGold)
                    )
                }
            }

            Text(
                text = productName,
                modifier = Modifier.padding(horizontal = 1.dp,vertical = 8.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = colorResource(R.color.black)
            )
            Card(modifier = Modifier.size(width = 50.dp,height = 22.dp),
                shape = RoundedCornerShape(6.dp),
                colors = CardDefaults.cardColors(colorResource(R.color.greendivider))
            ){
                Row(
                  modifier = Modifier.fillMaxWidth(),
                  verticalAlignment = Alignment.CenterVertically,
                  horizontalArrangement = Arrangement.SpaceBetween
                ){
                      Text(
                          text = rating,
                          modifier = Modifier.padding(start = 3.dp,top = 2.dp),
                          fontSize = 14.sp,
                          fontWeight = FontWeight.SemiBold,
                          color = Color.White
                      )
                      Icon(
                          painter = painterResource(R.drawable.star),
                          modifier = Modifier.padding(start = 3.dp, top = 2.dp, end = 3.dp)
                              .size(12.dp),
                          tint = Color.White,
                          contentDescription = null
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
                painter = painterResource(R.drawable.burger3),
                modifier = Modifier.size(120.dp).clip(shape = RoundedCornerShape(15.dp)),
                contentDescription = "Product Image",
                alignment = Alignment.Center
            )
            Card(
                onClick = {
                    onAddClick()
                },
                modifier = Modifier.padding(horizontal = 20.dp)
                    .padding(top = 120.dp).size(width = 100.dp, height = 36.dp),
                shape = RoundedCornerShape(5.dp),
                colors = CardDefaults.cardColors(colorResource(R.color.lightPink)),
                border = BorderStroke(width = 1.dp, color = colorResource(R.color.addButtonRed))
            ){
                Row(modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceBetween)
                {
                    Text(
                        text = "ADD",
                        modifier = Modifier.padding(start = 30.dp,top = 6.dp),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp,
                        color = colorResource(R.color.redish)
                    )
                    Icon(
                        painter = painterResource(R.drawable.baseline_add_24),
                        modifier = Modifier.padding( 3.dp).size(12.dp),
                        tint = Color.Red,
                        contentDescription = "Add item"
                    )
                }
            }
        }
    }
}

//@Preview(showSystemUi = true)
//@Composable
//fun ShowCardScreen(){
//    ParticularCardScreen(rememberNavController())
//}