package com.example.epiceats.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.epiceats.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController){

    Scaffold(modifier = Modifier.fillMaxWidth(),
        topBar = {
            TopAppBar(
                modifier = Modifier.background(color = colorResource(R.color.white)),
                title = {},
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "ArrowBack")
                    }
                },
            )
        }
    ){values ->
        Column( modifier = Modifier.fillMaxSize()
            .background(color = colorResource(R.color.lightPink))
            .padding(values)
        ){
            Spacer(modifier = Modifier.height(8.dp))
            Card(
                modifier = Modifier.fillMaxWidth()
                    .height(110.dp)
                    .padding(horizontal = 10.dp),
                shape = RoundedCornerShape(topStart = 12.dp, bottomStart = 0.dp,bottomEnd = 0.dp),
                colors = CardDefaults.cardColors(Color.White)
            ){
                Row(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        modifier = Modifier.size(80.dp).clip(CircleShape),
                        painter = painterResource(id = R.drawable.profielogo),
                        contentDescription = "Profile Image",
                        tint = Color.Unspecified
                    )
                    Spacer(modifier = Modifier.width(7.dp))
                    Column{
                        Text(
                            text = "Name",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 23.sp
                        )
                        Text(
                            text = "gmail2025@gmail.com",
                            color = Color.DarkGray,
                            fontSize = 12.sp
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(2.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(
                                text = "View activity",
                                color = colorResource(id = R.color.ViewActivityClickableColor),
                                fontSize = 13.sp
                            )
                            Icon(
                                modifier = Modifier.size(16.dp),
                                imageVector = Icons.Default.PlayArrow,
                                contentDescription = "Forward Arrow",
                                tint = Color.DarkGray
                            )
                        }
                    }
                }
            }

            ZomatoGold()
            Lazycolumn()
        }

    }
}

@Composable
fun ZomatoGold(){

    Card(
        colors = CardDefaults.cardColors(containerColor = Color.Black),
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 10.dp)
            .height(65.dp),
        shape = RoundedCornerShape(bottomEnd = 12.dp, bottomStart = 12.dp, topEnd = 0.dp, topStart = 0.dp)
    ){
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                painter = painterResource(id = R.drawable.goldicon1),
                contentDescription = "Zomato gold Image",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Join Zomato Gold",
                color = colorResource(id = R.color.ZomatoGold),
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.width(10.dp))
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Arrow right",
                tint = Color.White
            )
        }
    }
}


@Composable
fun Lazycolumn(){
    val cardList = listOf(
        cardItem.ColumnGrid(name = "Robin"),
        cardItem.FirstCard(ProfileName = "Your Profile", percentageText = "48% Completed"),
        cardItem.SecondCard(vegText = "Veg Mode"),
        cardItem.ThirdCard(Appearance = "Appearance"),
        cardItem.FourthCard(rating = "Your rating"),
        cardItem.FifthCard(Food_Order = "Food Orders"),
        cardItem.SixthCard(TitleName = "Dining and Experience"),
        cardItem.SeventhCard(title = "done"),
        cardItem.EighthCard(title = "done"),
        cardItem.NinthCard(title = "done"),
        cardItem.TenthCard(title = "done"),
        cardItem.EleventhCard(title = "eleventhDone")
    )

    LazyColumn(modifier = Modifier.fillMaxSize()){
        items(cardList){item ->
            when(item){
                is cardItem.ColumnGrid -> ColumnGrid(item)
                is cardItem.FirstCard -> ProfileCard(item)
                is cardItem.SecondCard -> VegModeCard(item)
                is cardItem.ThirdCard -> AppearanceCard(item)
                is cardItem.FourthCard -> RatingCard(item)
                is cardItem.FifthCard -> FoodOrderCard(item)
                is cardItem.SixthCard -> DiningCard(item)
                is cardItem.SeventhCard -> SeventhCard(item)
                is cardItem.EighthCard -> EighthCard(item)
                is cardItem.NinthCard -> NinthCard(item)
                is cardItem.TenthCard -> TenthCard(item)
                is cardItem.EleventhCard -> EleventhCard(item)
            }
        }
    }
}




@Composable
fun ColumnGrid(card: cardItem.ColumnGrid){
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Card(
            modifier = Modifier.fillMaxWidth().weight(1f),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ){
            Column(modifier = Modifier.fillMaxSize()){
                Icon(
                    painter = painterResource(id = R.drawable.outline_bookmark_24),
                    contentDescription = "Collection",
                    tint = Color.Gray,
                    modifier = Modifier.padding(start = 20.dp,top = 15.dp,bottom = 5.dp)
                        .size(30.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "Collection",
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }

        Spacer(modifier = Modifier.width(10.dp))
        Card(
            modifier = Modifier.fillMaxWidth().weight(1f),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ){
            Column(modifier = Modifier.fillMaxSize()){
                Icon(
                    painter = painterResource(id = R.drawable.rupeesymbol),
                    contentDescription = "Money",
                    tint = Color.Gray,
                    modifier = Modifier.padding(start = 20.dp,top = 15.dp,bottom = 5.dp)
                        .size(30.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "Money",
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Row(
                        modifier = Modifier
                            .size(width = 30.dp, height = 20.dp)
                            .background(color = Color(0xFFB9F3BB),
                                shape = RoundedCornerShape(8.dp)),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(
                            text = "₹0",
                            color = colorResource(R.color.ViewActivityClickableColor),
                            fontSize = 14.sp,
                        )
                    }
                }


            }
        }
    }
}



@Composable
fun ProfileCard(card: cardItem.FirstCard){
    Card(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ){
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "Your Profile Icon",
                tint = Color.LightGray,
                modifier = Modifier.size(25.dp)
            )

            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "Your Profile", color = Color.Black)
            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "48% Completed",
                modifier = Modifier.clip(shape = RoundedCornerShape(12.dp))
                    .background(color = colorResource(R.color.completecentageback)),
                color = colorResource(R.color.ZomatoGold),
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold
            )
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "forward arrow",
                tint = Color.DarkGray,
                modifier = Modifier.padding(start = 5.dp)
            )
        }
    }
}

@Composable
fun VegModeCard(card: cardItem.SecondCard){
    var switch1 by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ){
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                painter = painterResource(id = R.drawable.veg_icon),
                contentDescription = "Veg Mode Icon",
                tint = colorResource(R.color.greendivider),
                modifier = Modifier.size(22.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(text = "Veg Mode", color = Color.Black)
            Spacer(modifier = Modifier.weight(1f))
             //Toggle Button for the veg mode
            Switch(
                checked = switch1,
                onCheckedChange = {switch1 = it},
                colors = SwitchDefaults.colors(
                     checkedTrackColor = Color(0xFF2F9133),
                ),
                modifier = Modifier.height(16.dp)
            )
        }
    }
}

@Composable
fun AppearanceCard(card: cardItem.ThirdCard){
    Card(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ){
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            //Appearance one icon need to be added download
            Icon(
                painter = painterResource(R.drawable.paint),
                contentDescription = "Your Profile",
                tint = Color.LightGray,
                modifier = Modifier.size(20.dp)
            )

            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "Appearance", color = Color.Black)
            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "LIGHT",
                color = Color.Gray,
                fontWeight = FontWeight.Bold
            )
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "forward arrow",
                tint = Color.Gray
            )
        }
    }
}

@Composable
fun RatingCard(card: cardItem.FourthCard){
    Card(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ){
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                painter = painterResource(R.drawable.rating),
                contentDescription = "Rating Icon",
                tint = Color.LightGray,
                modifier = Modifier.size(25.dp)
            )

            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "Your rating", color = Color.Black)
            Spacer(modifier = Modifier.weight(1f))

            Icon(
                painter = painterResource(R.drawable.startrating),
                contentDescription = "forward arrow",
                tint = Color.Gray
            )
        }
    }
}

@Composable
fun FoodOrderCard(card: cardItem.FifthCard){
    Card(
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 10.dp).fillMaxWidth().height(400.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ){
        Column {
            Row {
                VerticalDivider(
                    thickness = 3.dp,
                    modifier = Modifier.height(34.dp).padding(top = 12.dp)
                        .clip(shape = RoundedCornerShape(10.dp)),
                    color = colorResource(R.color.purple_500)
                )
                Text(
                    text = "Food Orders",
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                )

            }

            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.order),
                    contentDescription = "Your orders",
                    tint = Color.LightGray,
                    modifier = Modifier.size(25.dp)
                )

                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Your orders", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    tint = Color.Gray
                )
            }

            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp,top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Your Profile",
                    tint = Color.LightGray,
                    modifier = Modifier.size(25.dp)
                )

                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Favorite orders", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    tint = Color.Gray
                )
            }

            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp,top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.thumbs),
                    contentDescription = "Your Profile",
                    tint = Color.LightGray,
                    modifier = Modifier.size(25.dp)
                )

                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Manage recommendations", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    tint = Color.Gray
                )
            }

            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp,top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.train),
                    contentDescription = "Your Profile",
                    tint = Color.LightGray,
                    modifier = Modifier.size(25.dp)
                )

                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Order on train", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    tint = Color.Gray
                )
            }

            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp,top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.addressbook),
                    contentDescription = "Your Profile",
                    tint = Color.LightGray,
                    modifier = Modifier.size(25.dp)
                )

                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Address book", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    tint = Color.Gray
                )
            }
            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp,top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.hiddden),
                    contentDescription = "Your Profile",
                    tint = Color.LightGray,
                    modifier = Modifier.size(25.dp)
                )

                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Hidden Restaurants", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    tint = Color.Gray
                )
            }
            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp,top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.message),
                    contentDescription = "Your Profile",
                    tint = Color.LightGray,
                    modifier = Modifier.size(25.dp)
                )

                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Online ordering help", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    tint = Color.Gray
                )
                Spacer(modifier = Modifier.width(4.dp))
            }
        }
    }
}


@Composable
fun DiningCard(card: cardItem.SixthCard){
    Card(
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 10.dp).fillMaxWidth().height(350.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ){
        Column {
            Row {
                VerticalDivider(
                    thickness = 3.dp,
                    modifier = Modifier.height(34.dp).padding(top = 12.dp)
                        .clip(shape = RoundedCornerShape(10.dp)),
                    color = colorResource(R.color.purple_500)
                )
                Text(
                    text = "Dining and Experiences",
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.hiddden),
                    contentDescription = "Your orders",
                    tint = Color.LightGray,
                    modifier = Modifier.size(25.dp)
                )

                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Your dining transactions", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    tint = Color.Gray
                )
            }

            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp,top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.gift),
                    contentDescription = "Your Profile",
                    tint = Color.LightGray,
                    modifier = Modifier.size(25.dp)
                )

                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Your dining rewards", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    tint = Color.Gray
                )
            }

            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp,top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.dining),
                    contentDescription = "Your Profile",
                    tint = Color.LightGray,
                    modifier = Modifier.size(25.dp)
                )

                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Your bookings", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    tint = Color.Gray
                )
            }

            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp,top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.message),
                    contentDescription = "Your Profile",
                    tint = Color.LightGray,
                    modifier = Modifier.size(25.dp)
                )

                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Dining help", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    tint = Color.Gray
                )
            }

            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp,top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Your Profile",
                    tint = Color.LightGray,
                    modifier = Modifier.size(25.dp)
                )

                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Dining settings", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    tint = Color.Gray
                )
            }
            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp,top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "Your Profile",
                    tint = Color.LightGray,
                    modifier = Modifier.size(25.dp)
                )

                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Frequently asked questions", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    tint = Color.Gray
                )
            }

            Spacer(modifier = Modifier.width(4.dp))
        }
    }
}


@Composable
fun SeventhCard(card: cardItem.SeventhCard){
    Card(
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 10.dp).fillMaxWidth().height(120.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ){
        Column {
            Row {
                VerticalDivider(
                    thickness = 3.dp,
                    modifier = Modifier.height(34.dp).padding(top = 12.dp)
                        .clip(shape = RoundedCornerShape(10.dp)),
                    color = colorResource(R.color.purple_700)
                )
                Text(
                    text = "Feeding India",
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.impact),
                    contentDescription = "Your orders",
                    tint = Color.LightGray,
                    modifier = Modifier.size(25.dp)
                )

                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Your impact", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    tint = Color.Gray
                )
            }

            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp,top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.reciept),
                    contentDescription = "Your orders",
                    tint = Color.LightGray,
                    modifier = Modifier.padding(start = 25.dp)
                )

                Text(
                    text = "Get Feeding India receipt",
                    color = Color.Black,
                    modifier = Modifier.padding(start = 5.dp,top = 10.dp).weight(1f)
                )

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    modifier = Modifier.padding(start = 5.dp,top = 10.dp),
                    tint = Color.Gray
                )
            }
        }
    }
}

@Composable
fun EighthCard(card: cardItem.EighthCard){
    Card(
        modifier = Modifier.padding(start = 10.dp, top = 13.dp,end = 10.dp).fillMaxWidth().height(310.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ){
        Column {
            Row {
                VerticalDivider(
                    thickness = 3.dp,
                    modifier = Modifier.height(34.dp).padding(top = 12.dp)
                        .clip(shape = RoundedCornerShape(10.dp)),
                    color = colorResource(R.color.purple_700)
                )
                Text(
                    text = "Money",
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.rupeesymbol),
                    contentDescription = "Your orders",
                    tint = Color.LightGray,
                    modifier = Modifier.padding(start = 25.dp)
                )

                Text(text = "Zomato Money",
                    color = Color.Black,
                    modifier = Modifier.padding(start = 5.dp, top = 10.dp)
                        .weight(1f)
                )

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    tint = Color.Gray
                )
            }

            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp,top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.giftcard),
                    contentDescription = "Your orders",
                    tint = Color.LightGray,
                    modifier = Modifier.padding(start = 25.dp)
                )

                Text(
                    text = "Buy Gift Card",
                    color = Color.Black,
                    modifier = Modifier.padding(start = 5.dp,top = 10.dp).weight(1f)
                )

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    modifier = Modifier.padding(start = 5.dp,top = 10.dp),
                    tint = Color.Gray
                )
            }

            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp,top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.claimgiftcard),
                    contentDescription = "Your Profile",
                    tint = Color.LightGray,
                    modifier = Modifier.padding(start = 25.dp)
                )

                Text(
                    text = "Claim Gift Card",
                    color = Color.Black,
                    modifier = Modifier.padding(start = 5.dp,top = 10.dp).weight(1f)
                )

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    modifier = Modifier.padding(start = 5.dp,top = 10.dp),
                    tint = Color.Gray
                )
            }

            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp,top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.z),
                    contentDescription = "Your Profile",
                    tint = Color.LightGray,
                    modifier = Modifier.padding(start = 5.dp)
                )

                Text(
                    text = "Zomato Credits",
                    color = Color.Black,
                    modifier = Modifier.padding(start = 5.dp,top = 10.dp).weight(1f)
                )

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    modifier = Modifier.padding(start = 5.dp,top = 10.dp),
                    tint = Color.Gray
                )
            }

            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp,top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.payment),
                    contentDescription = "Your Profile",
                    tint = Color.LightGray,
                    modifier = Modifier.padding(start = 5.dp)
                )

                Text(
                    text = "Payment settings",
                    color = Color.Black,
                    modifier = Modifier.padding(start = 5.dp,top = 10.dp).weight(1f)
                )

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    modifier = Modifier.padding(start = 5.dp,top = 10.dp),
                    tint = Color.Gray
                )
            }

        }
    }
}

@Composable
fun NinthCard(card: cardItem.NinthCard){
    Card(
        modifier = Modifier.padding(start = 10.dp, top = 13.dp,end = 10.dp).fillMaxWidth().height(120.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ){
        Column {
            Row {
                VerticalDivider(
                    thickness = 3.dp,
                    modifier = Modifier.height(34.dp).padding(top = 12.dp)
                        .clip(shape = RoundedCornerShape(10.dp)),
                    color = colorResource(R.color.purple_700)
                )
                Text(
                    text = "Zomato For Enterprise",
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.building),
                    contentDescription = "Your orders",
                    tint = Color.LightGray,
                    modifier = Modifier.padding(start = 5.dp)
                )

                Text(text = "For employees",
                    color = Color.Black,
                    modifier = Modifier.padding(start = 5.dp, top = 10.dp)
                        .weight(1f)
                )

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    modifier = Modifier.padding(start = 5.dp,top = 10.dp),
                    tint = Color.Gray
                )
            }

            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp,top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.empcard),
                    contentDescription = "Your orders",
                    tint = Color.LightGray,
                    modifier = Modifier.padding(start = 5.dp)
                )

                Text(
                    text = "For employees",
                    color = Color.Black,
                    modifier = Modifier.padding(start = 5.dp,top = 10.dp).weight(1f)
                )

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    modifier = Modifier.padding(start = 5.dp,top = 10.dp),
                    tint = Color.Gray
                )
            }

        }
    }
}

@Composable
fun TenthCard(card: cardItem.TenthCard){
    Card(
        modifier = Modifier.padding(start = 10.dp, top = 13.dp,end = 10.dp).fillMaxWidth().height(120.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ){
        Column {
            Row {
                VerticalDivider(
                    thickness = 3.dp,
                    modifier = Modifier.height(34.dp).padding(top = 12.dp)
                        .clip(shape = RoundedCornerShape(10.dp)),
                    color = colorResource(R.color.purple_500)
                )
                Text(
                    text = "Coupons",
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.coupons),
                    contentDescription = "Your orders",
                    tint = Color.LightGray,
                    modifier = Modifier.padding(start = 5.dp)
                )

                Text(text = "Collected coupons",
                    color = Color.Black,
                    modifier = Modifier.padding(start = 5.dp, top = 10.dp)
                        .weight(1f)
                )

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    tint = Color.Gray
                )
            }

            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp,top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.coupons),
                    contentDescription = "Your orders",
                    tint = Color.LightGray,
                    modifier = Modifier.padding(start = 5.dp)
                )

                Text(
                    text = "Redeem Gold coupons",
                    color = Color.Black,
                    modifier = Modifier.padding(start = 5.dp,top = 10.dp).weight(1f)
                )

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    modifier = Modifier.padding(start = 5.dp,top = 10.dp),
                    tint = Color.Gray
                )
            }

        }
    }
}


@Composable
fun EleventhCard(card: cardItem.EleventhCard){
    Card(
        modifier = Modifier.padding(start = 10.dp, top = 13.dp,end = 10.dp).fillMaxWidth().height(300.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ){
        Column {
            Row {
                VerticalDivider(
                    thickness = 3.dp,
                    modifier = Modifier.height(34.dp).padding(top = 12.dp)
                        .clip(shape = RoundedCornerShape(10.dp)),
                    color = colorResource(R.color.purple_500)
                )
                Text(
                    text = "More",
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "Your orders",
                    tint = Color.LightGray,
                    modifier = Modifier.padding(start = 5.dp, top = 5.dp)
                )

                Text(text = "About",
                    color = Color.Black,
                    modifier = Modifier.padding(start = 5.dp, top = 10.dp)
                        .weight(1f)
                )

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                    tint = Color.Gray
                )
            }

            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp,top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.feedback),
                    contentDescription = "Your Profile",
                    tint = Color.LightGray,
                    modifier = Modifier.padding(start = 5.dp,top = 5.dp)
                )

                Text(
                    text = "Send Feedback",
                    color = Color.Black,
                    modifier = Modifier.padding(start = 5.dp,top = 10.dp).weight(1f)
                )

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    modifier = Modifier.padding(start = 5.dp,top = 10.dp),
                    tint = Color.Gray
                )
            }

            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp,top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "Your Profile",
                    tint = Color.LightGray,
                    modifier = Modifier.padding(start = 5.dp,top = 5.dp)
                )

                Text(
                    text = "Report a safety emergency",
                    color = Color.Black,
                    modifier = Modifier.padding(start = 5.dp,top = 10.dp).weight(1f)
                )

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    modifier = Modifier.padding(start = 5.dp,top = 10.dp),
                    tint = Color.Gray
                )
            }

            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp,top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Your Profile",
                    tint = Color.LightGray,
                    modifier = Modifier.padding(start = 5.dp,top = 5.dp)
                )

                Text(
                    text = "Settings",
                    color = Color.Black,
                    modifier = Modifier.padding(start = 5.dp,top = 10.dp).weight(1f)
                )

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    modifier = Modifier.padding(start = 5.dp,top = 10.dp),
                    tint = Color.Gray
                )
            }

            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier.padding(start = 53.dp,top = 10.dp).weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.logout),
                    contentDescription = "Your Profile",
                    tint = Color.LightGray,
                    modifier = Modifier.padding(start = 5.dp,top = 5.dp)
                )

                Text(
                    text = "Logout",
                    color = Color.Black,
                    modifier = Modifier.padding(start = 5.dp,top = 10.dp).weight(1f)
                )

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    modifier = Modifier.padding(start = 5.dp,top = 10.dp),
                    tint = Color.Gray
                )
            }

        }
    }
}

sealed class cardItem{
    data class FirstCard(
        val ProfileName: String,
        val percentageText: String
    ): cardItem()

    data class ColumnGrid(val name: String)
    data class SecondCard( val vegText: String): cardItem()
    data class ThirdCard( val Appearance: String): cardItem()
    data class FourthCard( val rating: String): cardItem()
    data class FifthCard( val Food_Order: String): cardItem()
    data class SixthCard( val TitleName: String): cardItem()
    data class SeventhCard( val title: String): cardItem()
    data class EighthCard( val title: String): cardItem()
    data class NinthCard( val title: String): cardItem()
    data class TenthCard( val title: String): cardItem()
    data class EleventhCard( val title: String): cardItem()
}

@Preview(showSystemUi = true)
@Composable
fun ShowProfileScreen(){
    ProfileScreen(rememberNavController())
}






