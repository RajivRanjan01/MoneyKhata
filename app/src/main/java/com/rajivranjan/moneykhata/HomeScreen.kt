package com.rajivranjan.moneykhata

import android.R.attr.end
import android.R.attr.start
import android.R.attr.top
import android.R.color.white
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (nameRow , list, card, topBar) = createRefs()

            Image(
                painter = painterResource(id = R.drawable.rectangle_9),
                contentDescription = null,
                modifier = Modifier.constrainAs(topBar) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )
            Box(
                modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp,start = 16.dp,end = 16.dp)
                .constrainAs(nameRow){
                top.linkTo(parent.top);
                start.linkTo(parent.start);
                end.linkTo(parent.end);
            }){
                Column {
                    Text(text = "Good Afternoon",
                        fontSize = 16.sp,
                        color = Color.White)
                    Text(text = "Expense Tracker",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White)
                }
                Image(
                    painter = painterResource(R.drawable.group_8),
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }

        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewHomeScreen() {
    HomeScreen()
}

