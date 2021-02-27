package sa.waqood.puppyadoptionapp.ui.data

import java.io.Serializable

data class ItemData(
    var age: String,
    var description: String,
    var image: Int,
    var name: String,
    val gender:String="female"
):Serializable