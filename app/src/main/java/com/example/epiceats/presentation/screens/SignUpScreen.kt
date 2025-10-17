package com.example.epiceats.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.epiceats.R
import com.example.epiceats.data.models.AuthRequest
import com.example.epiceats.presentation.components.CheckboxComponent
import com.example.epiceats.presentation.components.OrComponent
import com.example.epiceats.presentation.navigation.Routes
import com.example.epiceats.presentation.navigation.SubNavigation
import com.example.epiceats.presentation.viewmodel.ProjectViewModel

@Composable
fun SignUpScreen(viewModel: ProjectViewModel = hiltViewModel(),
                 navController: NavController){
    val state = viewModel.signUpScreenState.collectAsStateWithLifecycle()
    val context = LocalContext.current

    LaunchedEffect(state.value.errorMessage) {
        state.value.errorMessage?.let { message ->
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        }
    }

    LaunchedEffect(state.value.tokenPair) {
        state.value.tokenPair?.let {
            navController.navigate(SubNavigation.MainHomeScreen) {
                popUpTo(SubNavigation.LoginSignUpScreen) { inclusive = false }
            }
        }
    }

    if(state.value.isLoading){
        Box(modifier = Modifier.fillMaxSize()){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
    else{
        var fullName by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var address by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var confirmPassword by remember { mutableStateOf("") }

        Scaffold(modifier = Modifier.fillMaxSize())
        {innerPadding ->
            LazyColumn(
                modifier = Modifier.fillMaxSize()
                    .padding(bottom = innerPadding.calculateBottomPadding())
            ){
              item{
                  Box(modifier = Modifier.fillMaxWidth()){
                      Image(
                          painter  = painterResource(R.drawable.yumrushsignup),
                          contentScale = ContentScale.Crop,
                          contentDescription = "Zomato Image"
                      )
                      Button(
                          onClick = {},
                          modifier = Modifier.padding(vertical = 50.dp, horizontal = 16.dp)
                              .align(Alignment.TopEnd)
                              .clip(CircleShape)
                              .size(width = 78.dp, height = 35.dp),
                          colors = ButtonDefaults.buttonColors(
                              containerColor = Color.DarkGray.copy(alpha = 0.8f),
                              contentColor = Color.LightGray
                          ),
                          shape = CircleShape,
                      ){
                          Text(text = "Skip", Modifier.clickable{
                              navController.navigate(SubNavigation.MainHomeScreen)
                          })
                      }
                  }
                  Spacer(modifier = Modifier.height(6.dp))
                  Column(modifier = Modifier.fillMaxWidth(),
                      horizontalAlignment = Alignment.CenterHorizontally)
                  {
                      Text(
                          text = "Get Started",
                          fontSize = 44.sp,
                          fontWeight = FontWeight.Bold
                      )
                      Text(
                          text = "by creating a free account",
                          fontSize = 16.sp,
                      )
                  }
                  Spacer(modifier = Modifier.height(18.dp))
                  MyTextField(
                      value = fullName,
                      onValueChange = {fullName = it},
                      placeholderValue = "Full Name",
                      painterResource(R.drawable.userprofile)
                  )
                  Spacer(modifier = Modifier.height(8.dp))
                  MyTextField(
                      value = email,
                      onValueChange = {email = it},
                      placeholderValue = "Email",
                      painterResource(R.drawable.mail)
                  )
                  Spacer(modifier = Modifier.height(8.dp))
                  MyTextField(
                      value = address,
                      onValueChange = {address = it},
                      placeholderValue = "Address",
                      painterResource(R.drawable.address)
                  )

                  Spacer(modifier = Modifier.height(8.dp))
                  PasswordTextField(
                      value = password,
                      onValueChange = {password = it},
                      placeholderValue = "Password",
                      painterResource(R.drawable.padlock)
                  )
                  Spacer(modifier = Modifier.height(10.dp))
                  PasswordTextField(
                      value = confirmPassword,
                      onValueChange = {confirmPassword = it},
                      placeholderValue = "Confirm Password",
                      painterResource(R.drawable.padlock)
                  )
                  Spacer(modifier = Modifier.height(5.dp))
                  CheckboxComponent(value = stringResource(id = R.string.term_conditions))
                  Spacer(modifier = Modifier.height(20.dp))
                  val context = LocalContext.current

                  Button(
                      onClick = {
                          if (
                              fullName.isNotBlank() && email.isNotBlank() && address.isNotBlank()
                              && password.isNotBlank() && confirmPassword.isNotBlank()
                          ) {
                              if (password == confirmPassword) {
                                  val userData = AuthRequest(
                                      email = email,
                                      password = password
                                  )

                                  viewModel.createUser(userData)
                              } else {
                                  Toast.makeText(
                                      context,
                                      "Passwords and Confirm password do not match",
                                      Toast.LENGTH_SHORT
                                  ).show()
                              }
                          } else {
                              Toast.makeText(
                                  context,
                                  "Please fill All Fields",
                                  Toast.LENGTH_SHORT
                              ).show()
                          }
                      },
                      modifier = Modifier.fillMaxWidth()
                          .padding(start = 16.dp, end = 16.dp, bottom = 14.dp).height(50.dp),
                      colors = ButtonDefaults.buttonColors(colorResource(id = R.color.ZomatoGold)),
                      elevation = ButtonDefaults.buttonElevation(4.dp),
                      shape = RoundedCornerShape(12.dp)
                  ){
                      Row(modifier = Modifier.fillMaxWidth().padding(4.dp), Arrangement.Center){
                          Text("Next", fontSize = 22.sp, color = colorResource(R.color.white), fontWeight = FontWeight.SemiBold)
                          Spacer(modifier = Modifier.width(4.dp))
                          Icon(
                              painter = painterResource(R.drawable.baseline_arrow_forward_ios_24),
                              contentDescription = null,
                              modifier = Modifier.padding(top = 4.dp).size(20.dp)
                          )
                      }
                  }

                  Row(modifier = Modifier.fillMaxWidth(), Arrangement.Center){
                      Text("Already a member?")
                      Spacer(modifier = Modifier.width(2.dp))
                      Text(
                            "Login in",
                          modifier = Modifier.clickable{
                              navController.navigate(Routes.LoginScreen)
                          },
                          color = colorResource(R.color.addButtonRed)
                      )
                  }
                  OrComponent()

              }
            }
        }
    }
}

@Composable
fun MyTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholderValue: String,
    painterResource: Painter
){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(text = placeholderValue, color = Color.Gray) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        singleLine = true,
        textStyle = TextStyle(color = Color.Black),
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(unfocusedBorderColor = colorResource(R.color.percentage), focusedBorderColor = colorResource(R.color.ZomatoGold)),
        keyboardOptions = KeyboardOptions.Default,
        leadingIcon = {
            Icon(
                painter = painterResource,
                contentDescription = "Icon",
                modifier = Modifier.size(20.dp),
                tint = Color.Gray
            )
        }
    )
}

@Composable
fun PasswordTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholderValue: String,
    painterResource: Painter
){
    val passwordVisible = remember {mutableStateOf(false)}
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(text = placeholderValue, color = Color.Gray) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        singleLine = true,
        textStyle = TextStyle(color = Color.Black),
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(unfocusedBorderColor = colorResource(R.color.percentage), focusedBorderColor = colorResource(R.color.ZomatoGold)),
        keyboardOptions = KeyboardOptions.Default,
        leadingIcon = {
            Icon(
                painter = painterResource,
                contentDescription = "Icon",
                modifier = Modifier.size(20.dp),
                tint = Color.Gray
            )
        },
        trailingIcon = {
            val iconImage = if(passwordVisible.value){
                Icons.Filled.Visibility
            }else{
                Icons.Filled.VisibilityOff
            }
            val description = if( passwordVisible.value){
                stringResource(id = R.string.hide_password)
            }else{
                stringResource(id = R.string.show_password)
            }

            IconButton(onClick = {passwordVisible.value = !passwordVisible.value}){
                Icon(
                    imageVector = iconImage,
                    contentDescription = description,
                    tint = Color.Gray
                )
            }
        },
        visualTransformation = if(passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation()
    )
}


