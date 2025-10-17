package com.example.epiceats

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.epiceats.presentation.navigation.App
import com.example.epiceats.ui.theme.EpicEatsTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.distinctUntilChanged

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            //Track scroll direction
            var isVisible by remember { mutableStateOf(true)}
            var lastScrollOffset by remember { mutableStateOf(0) }
            var lastIndex by remember { mutableStateOf(0)}
            val listState = rememberLazyListState()

            //Listen to scroll events
            LaunchedEffect(listState) {
                snapshotFlow{ listState.firstVisibleItemIndex to listState.firstVisibleItemScrollOffset }
                    .distinctUntilChanged()
                    .collect {(index,scrollOffset) ->
                        if(index > lastIndex || (index == lastIndex && scrollOffset > lastScrollOffset - 50)){
                            //Scrolling Up -> Show BottomNavBar
                            isVisible = true
                        }
                        lastIndex = index
                        lastScrollOffset = scrollOffset
                    }
            }

            EpicEatsTheme {
                App(
                    isVisible = isVisible,
                    listState = listState
                )
            }
        }
    }
}

