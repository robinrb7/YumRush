package com.example.epiceats.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.IconButton
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.epiceats.R
import com.example.epiceats.presentation.navigation.Routes
import com.google.android.gms.maps.model.Circle


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreenCards(navController: NavController){

    Card(onClick = {
         navController.navigate(Routes.ParticularCardScreen)
    },
        shape = RoundedCornerShape(22.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier.fillMaxWidth().height(312.dp).padding(horizontal = 16.dp)
    )
    {
        Box(modifier = Modifier.fillMaxSize()) {
            val pager = rememberPagerState(initialPage = 0) { 4 }

            CardImagesRow(pagerState = pager)
            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 5.dp, start = 1.dp, end = 12.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                when (pager.currentPage) {
                    0 -> PriceCard(name = "Chicken-Biryani", price = "₹359")
                    1 -> PriceCard(name = "Pav Bhaji", price = "₹140")
                    2 -> PriceCard(name = "Veg-Momo", price = "₹159")
                    3 -> PriceCard(name = "Chole-Bhathure", price = "₹130")
                }

                Spacer(modifier  = Modifier.width(16.dp))
                IconButton(onClick = {}) {
                    Icon(
                        painterResource(R.drawable.baseline_bookmark_24),
                        modifier = Modifier.size(34.dp),
                        tint = Color.Black.copy(alpha = 0.6f),
                        contentDescription = "BookMark"
                    )
                }
            }

            PagerCount(pagerState = pager)
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 192.2.dp)
                    .height(120.dp)
            )
            {
                SmallDetailCard()
                DetailCard()
            }
        }
    }
}

@Composable
fun CardImagesRow(pagerState: PagerState){
    HorizontalPager(state = pagerState) {
        when(pagerState.currentPage){
            0 -> AsyncImage(model = R.drawable.chicken_biryani,
                modifier = Modifier.fillMaxWidth(),
                contentDescription = null)
            1 -> AsyncImage(model = R.drawable.pav_bhaji,
                modifier = Modifier.fillMaxWidth(),
                contentDescription = null)
            2 -> AsyncImage(model = R.drawable.veg_momo,
                modifier = Modifier.fillMaxWidth(),
                contentDescription = null)
            3 -> AsyncImage(model = R.drawable.chole_bathure,
                modifier = Modifier.fillMaxWidth(),
                contentDescription = null)

        }
    }
}

@Composable
fun PriceCard(name: String, price: String){
    Card(
        modifier = Modifier.padding(top = 6.dp)
            .size(width = 160.dp,height = 21.dp)
            .clickable{},
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Black.copy(alpha = 0.5f))
    ) {
        Row(modifier = Modifier.fillMaxWidth(),
            Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = name,color = Color.White,fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
            Icon(painterResource(R.drawable.dot),
                modifier = Modifier.size(16.dp),
                tint = Color.White,
                contentDescription = null)
            Text(text = price, color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
        }
    }
}

@Composable
fun PagerCount(pagerState: PagerState){
    Row(horizontalArrangement = Arrangement.spacedBy(2.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(start = 280.dp,top = 196.dp))
    {
        repeat(pagerState.pageCount){
            Spacer(
                modifier = Modifier
                    .background(
                        color = if(pagerState.currentPage==it) Color.White else Color.White.copy(alpha = 0.5f),
                        shape = CircleShape
                    )
                    .size(9.dp)
            )
        }
    }
}

@Composable
fun DetailCard(){
    val restaurantName = remember{mutableStateOf("La Roma's")}
    val rating =  remember{ mutableStateOf("4.2")}

    Card(
        modifier = Modifier.fillMaxWidth().height(100.dp),
        colors = CardDefaults.cardColors(contentColor = Color.White),
        shape = RoundedCornerShape(bottomStart = 22.dp, bottomEnd = 22.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ){
            Row(modifier = Modifier.fillMaxWidth().padding(start = 16.dp,top = 8.dp,end = 16.dp),
                Arrangement.SpaceBetween)
            {
                Text(text = restaurantName.value,color = Color.Black,
                    fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Card(modifier = Modifier.size(width = 45.dp, height = 22.dp),
                    shape = RoundedCornerShape(6.dp),
                    colors = CardDefaults.cardColors(colorResource(R.color.greendivider)),
                    ){
                    Row(modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically)
                    {
                        Text(text = rating.value, modifier = Modifier.padding(start = 4.dp),
                            fontSize = 12.sp,fontWeight = FontWeight.SemiBold, color = Color.White)
                        Icon(painterResource(R.drawable.star),
                            modifier = Modifier.padding(start = 5.dp, top = 6.dp, bottom = 2.dp).size(10.dp),
                            tint = Color.White,
                            contentDescription = null
                            )
                    }
                }
            }
            Card(modifier = Modifier.padding(start = 16.dp,6.dp).width(165.dp).height(22.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(Color.Gray.copy(alpha = 0.2f))
            ){
                Row(modifier = Modifier.fillMaxWidth()){
                    Icon(painterResource(R.drawable.check),
                        modifier = Modifier.padding(start = 8.dp,top = 6.dp).size(12.dp),
                        tint = colorResource(R.color.purple_500),
                        contentDescription = null)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "On Time Preparation",color = Color.Gray,fontSize = 14.sp)
                }
            }
            HorizontalDivider(modifier = Modifier.padding(start = 16.dp, end = 16.dp,top = 6.dp),
                color = colorResource(R.color.purple_200),
                    thickness = 1.dp)
                Row(modifier = Modifier.fillMaxWidth()){
                    Icon(painterResource(R.drawable.discount),
                        modifier = Modifier.padding(start = 16.dp,top = 3.dp).size(16.dp),
                        tint = Color.Blue,
                        contentDescription = null)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "Flat 50 OFF on above 249",
                        modifier = Modifier.padding(start = 4.dp),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Gray
                    )
                }

        }
    }
}

@Composable
fun SmallDetailCard(){
    val timedText = remember{mutableStateOf("44 mins")}
    val distance = remember{ mutableStateOf("1.6 km")}

    Card(
        modifier = Modifier.size(width = 122.dp,height = 25.dp),
        colors = CardDefaults.cardColors(contentColor = Color.White),
        shape = RoundedCornerShape(topEnd = 12.dp)
    ){
        Row(modifier = Modifier.fillMaxWidth()){
            Icon(painterResource(R.drawable.timer),
                modifier = Modifier.padding(start = 5.dp, top = 5.dp, bottom = 5.dp).size(15.dp),
                tint = Color.Green,
                contentDescription = null)
            Text(text = timedText.value,
                modifier = Modifier.padding(start = 2.dp,top = 2.dp, bottom = 2.dp),
                fontSize = 11.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Gray
                )
            Icon(painterResource(R.drawable.dot),
                modifier = Modifier.padding(start = 4.dp).size(18.dp),
                tint = Color.Gray,
                contentDescription = null)
            Text(text = distance.value,
                modifier = Modifier.padding(top = 2.dp, bottom = 2.dp),
                fontSize = 11.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Gray
            )
        }
    }
}


//@Preview(showSystemUi = true)
//@Composable
//fun ShowHomeScreenCards(){
//    HomeScreenCards(rememberNavController())
//}