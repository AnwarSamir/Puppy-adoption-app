package sa.waqood.puppyadoptionapp

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sa.waqood.puppyadoptionapp.ui.data.ItemData
import sa.waqood.puppyadoptionapp.ui.dogAgeText
import sa.waqood.puppyadoptionapp.ui.dogLongDescText
import sa.waqood.puppyadoptionapp.ui.dogNameText
import sa.waqood.puppyadoptionapp.ui.theme.PuppyAdoptionAppTheme

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PuppyAdoptionAppTheme {
                // A surface container using the 'background' color from the theme
//                Surface(color = MaterialTheme.colors.background) {
//
//                    val puppyData = intent.getSerializableExtra("puppyData") as ItemData
//                    Greeting(puppyData.toString())
//                }
                val puppyData = intent.getSerializableExtra("puppyData") as ItemData
                ToolbarWidget(this, puppyData);
            }
        }
    }


}

@Composable
fun ToolbarWidget(context: Context, puppyData: ItemData) {
    // theme for our app.
    Scaffold(
        // below line we are
        // creating a top bar.
        topBar = {
            TopAppBar(
                // in below line we are
                // adding title to our top bar.
                title = {
                    // inside title we are
                    // adding text to our toolbar.
                    Text(
                        text = puppyData.name,
                        // below line is use
                        // to give text color.
                        color = Color.White
                    )
                },
                navigationIcon = {
                    // navigation icon is use
                    // for drawer icon.
                    IconButton(onClick = {

                    }) {
                        // below line is use to
                        // specify navigation icon.
                        Icon(Icons.Filled.ArrowBack, "")
                    }
                },
                // below line is use to give background color
                backgroundColor = colorResource(id = R.color.teal_700),

                // content color is use to give
                // color to our content in our toolbar.
                contentColor = Color.White,

                // below line is use to give
                // elevation to our toolbar.
                elevation = 12.dp
            )
        }, content = {
            BuildView(puppyData)
        })

}

@Composable
fun BuildView(puppyData: ItemData) {
    Column() {
        puppyImage(puppyData.image)
        Card(modifier = Modifier.padding(16.dp), elevation = 6.dp,shape = RoundedCornerShape(16.dp)) {
            Column(modifier = Modifier.padding(16.dp)) {
                dogNameText(dogName = puppyData.name)
                dogAgeText(dogAge = puppyData.age)
                dogAgeText(dogAge = puppyData.gender)
                dogLongDescText(dogDesc = puppyData.description)
                takeMeToHome()
            }

        }

    }

}


@Composable
fun takeMeToHome() {
    val context= LocalContext.current
    Button(
        onClick = {
            Toast.makeText(context, "Thanks a lot ^_^ .. ", Toast.LENGTH_SHORT).show()
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Text(text = "Take me to home ....")
    }
}

@Composable
fun puppyImage(image: Int) {
    val image: Painter = painterResource(id = image)

    Image(
        painter = image,
        contentDescription = "",
        contentScale = ContentScale.Crop,            // crop the image if it's not a square
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)

        // clip to the circle shape

    )
}










