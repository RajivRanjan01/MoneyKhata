package com.rajivranjan.moneykhata

import android.R.attr.end
import android.R.attr.start
import android.R.attr.top
import android.R.color.white
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.Dimension
import com.rajivranjan.moneykhata.ui.theme.Zinc

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
                .padding(top = 64.dp,start = 16.dp,end = 16.dp)
                .constrainAs(nameRow){
                top.linkTo(parent.top);
                start.linkTo(parent.start);
                end.linkTo(parent.end);
            })
            {
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
                    painter = painterResource(R.drawable.bell_1),
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }
            cardItem(modifier = Modifier.constrainAs(card){
                top.linkTo(nameRow.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)


            })
            TransactionList(modifier = Modifier.fillMaxWidth().constrainAs(list){
                top.linkTo(card.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
                height = Dimension.fillToConstraints
            })

        }
    }
}
@Composable
fun cardItem(modifier:Modifier){
    Column(modifier = modifier
        .padding(16.dp)
        .fillMaxWidth()
        .height(200.dp)
        .clip(RoundedCornerShape(16.dp))
        .background(Zinc)
        .padding(16.dp)
    )
    {
        Box(modifier = Modifier.fillMaxWidth().weight(1f)){
           Column(modifier = Modifier.align(Alignment.CenterStart)) {  Text(text = "Total Balance",
               fontSize = 16.sp,
               color = Color.White)
               Text(text = " $ 1200",
                   fontSize = 20.sp,
                   fontWeight = FontWeight.Bold,
                   color = Color.White) }
            Image(
                painter = painterResource(R.drawable.group_8),
                contentDescription = null,
                modifier = Modifier.align(Alignment.CenterEnd)
            )
        }
        Box(modifier = Modifier.fillMaxWidth().weight(1f)) {

            cardRowItem(modifier = Modifier.align(Alignment.CenterStart),
                title = "Income",
                amount = " $ 12,46,388",
                image = R.drawable.frame_5)
            cardRowItem(modifier = Modifier.align(Alignment.CenterEnd),
                title = "Expense",
                amount = " $ 12,46,388",
                image = R.drawable.frame_7)

    }

}
}

@Composable
fun TransactionList(modifier:Modifier){
    Column(modifier = modifier.padding(horizontal = 16.dp)) {
        Box(modifier = Modifier.fillMaxWidth()){
            Text(text = "Recent Transactions",
                color = Zinc,
                fontSize = 20.sp)
            Text(
                text = "View All",
                fontSize = 16.sp,
                color = Zinc,
                modifier = Modifier.align(Alignment.CenterEnd)
            )


        }


    }

}

@Composable
fun cardRowItem(modifier:Modifier , title:String, amount:String,image:Int ){
    Column(modifier = modifier)  {
        Row {
            Image(painter = painterResource(image),contentDescription = null)
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = title, fontSize = 16.sp, color = Color.White)

        }
        Text(text = amount , fontSize = 20.sp, color = Color.White )
    }
}

@Composable
fun TransactionItem(modifier:Modifier,title:String,amount:String,icon: Int){
Column(modifier = modifier) {

}
}


@Composable
@Preview(showBackground = true)
fun PreviewHomeScreen() {
    HomeScreen()
}

