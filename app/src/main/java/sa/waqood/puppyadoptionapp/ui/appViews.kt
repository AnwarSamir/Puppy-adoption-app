package sa.waqood.puppyadoptionapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.chrisbanes.accompanist.coil.CoilImage
import sa.waqood.puppyadoptionapp.R

@Composable
fun dogNameText(dogName: String) {
    Text(

        fontFamily = FontFamily(Font(R.font.font)),
        text = dogName,
        style = TextStyle(color = Color.Black),
        fontSize = 20.sp,
        modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp)
    )
}

@Composable
fun dogDescText(dogDesc: String) {
    Text(
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        fontFamily = FontFamily(Font(R.font.font1)),
        text = dogDesc,
        style = TextStyle(color = Color.Gray),
        fontSize = 15.sp,
        modifier = Modifier.padding(0.dp, 2.dp, 0.dp, 0.dp)
    )
}

@Composable
fun dogLongDescText(dogDesc: String) {
    Text(
        fontFamily = FontFamily(Font(R.font.font1)),
        text = dogDesc,
        style = TextStyle(color = Color.Gray),
        fontSize = 15.sp,
        modifier = Modifier.padding(0.dp, 2.dp, 0.dp, 0.dp)
    )
}

@Composable
fun dogAgeText(dogAge: String) {
    Text(
        fontFamily = FontFamily(Font(R.font.font1)),
        text = dogAge,
        style = TextStyle(color = Color.Gray),
        fontSize = 15.sp,
        modifier = Modifier.padding(0.dp, 2.dp, 0.dp, 0.dp)
    )
}


@Composable
fun loadImage(imageId: Int) {



    CoilImage(
       imageId,
        contentDescription = "",
        contentScale = ContentScale.Crop,            // crop the image if it's not a square
        modifier = Modifier
            .size(99.dp)
            .clip(
                RoundedCornerShape(
                    5.dp,
                    0.dp,
                    0.dp,
                    5.dp
                )
            )                       // clip to the circle shape

    )


}



