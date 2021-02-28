/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package sa.waqood.puppyadoptionapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sa.waqood.puppyadoptionapp.ui.theme.PuppyAdoptionAppTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import sa.waqood.puppyadoptionapp.ui.data.ItemData
import sa.waqood.puppyadoptionapp.ui.dogAgeText
import sa.waqood.puppyadoptionapp.ui.dogDescText
import sa.waqood.puppyadoptionapp.ui.dogNameText
import sa.waqood.puppyadoptionapp.ui.loadImage
import androidx.compose.foundation.layout.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PuppyAdoptionAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = Color.LightGray) {
                    PuppyAdoption()
                }
            }
        }
    }
}


@Composable
fun PuppyAdoption() {
    val context = LocalContext.current
    Column(modifier = Modifier.padding(0.dp, 8.dp, 0.dp, 0.dp)) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))
                .background(Color.White)
                .fillMaxWidth()
                .padding(0.dp, 8.dp, 0.dp, 8.dp)
        ) {
            Text(
                color = Color.Blue,
                text = "Pick a Puppy with an easy way ",
                fontFamily = FontFamily(Font(R.font.font)),
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }

        LazyColumn(content = {

            items(puppyAdoptionList()) { item ->
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .clickable {
                            val intent = Intent(context, DetailsActivity::class.java)
                            intent.putExtra("puppyData",item )
                            context.startActivity(intent)
                        },
                    elevation = 3.dp,
                    shape = RoundedCornerShape(5.dp),
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {

                        loadImage(imageId = item.image)
                        Column(modifier = Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp)) {
                            dogNameText(dogName = item.name)
                            dogAgeText(dogAge = item.age)
                            dogDescText(dogDesc = item.description)
                        }
                    }
                }


            }
        }, modifier = Modifier.fillMaxWidth())
    }


}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PuppyAdoptionAppTheme {
        PuppyAdoption()
    }
}


private fun puppyAdoptionList(): List<ItemData> {
    val listOfData = ArrayList<ItemData>()

        listOfData.add(
            ItemData(
                "2 months",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                R.drawable.dog1,
                "Bella"
            )
        )



        listOfData.add(
            ItemData(
                "3 months",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                R.drawable.dog2,
                "Betty"
            )
        )

        listOfData.add(
            ItemData(
                "4 months",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                R.drawable.dog3,
                "Barkley"
            )
        )


        listOfData.add(
            ItemData(
                "5 months",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                R.drawable.dog4,
                "Cheyenne"
            )
        )
        listOfData.add(
            ItemData(
                "6 months",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                R.drawable.dog5,
                "Buzz"
            )
        )

        listOfData.add(
            ItemData(
                "7 months",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                R.drawable.dog6,
                "Cricket"
            )
        )


        listOfData.add(
            ItemData(
                "8 months",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                R.drawable.dog7,
                "Cooper"
            )
        )



        listOfData.add(
            ItemData(
                "9 months",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                R.drawable.dog8,
                "Georgia"
            )
        )




    return listOfData
}
