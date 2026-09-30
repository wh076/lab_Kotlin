package com.example.myinformation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myinformation.ui.theme.MyInformationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyInformationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFD2E8D4)
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.android_logo),
                contentDescription = null,
                modifier = Modifier.size(120.dp)
            )
            Text(
                text = stringResource(R.string.full_name),
                fontSize = 40.sp,
                lineHeight = 48.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(start = 16.dp, top = 8.dp, end = 16.dp)
            )
            Text(
                text = stringResource(R.string.title),
                fontWeight = FontWeight.Bold,
                color = Color(0xFF006D3B)
            )
        }
        Column(modifier = Modifier.padding(bottom = 48.dp)) {
            Row(modifier = Modifier.padding(8.dp)) {
                Icon(Icons.Default.Phone, contentDescription = null, tint = Color(0xFF006D3B))
                Text(text = stringResource(R.string.phone), modifier = Modifier.padding(start = 16.dp))
            }
            Row(modifier = Modifier.padding(8.dp)) {
                Icon(Icons.Default.Share, contentDescription = null, tint = Color(0xFF006D3B))
                Text(text = stringResource(R.string.social), modifier = Modifier.padding(start = 16.dp))
            }
            Row(modifier = Modifier.padding(8.dp)) {
                Icon(Icons.Default.Email, contentDescription = null, tint = Color(0xFF006D3B))
                Text(text = stringResource(R.string.email), modifier = Modifier.padding(start = 16.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    MyInformationTheme {
        Surface(color = Color(0xFFD2E8D4)) {
            BusinessCard()
        }
    }
}
