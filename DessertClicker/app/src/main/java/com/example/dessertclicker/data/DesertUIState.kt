package com.example.dessertclicker.data
import androidx.annotation.DrawableRes
import com.example.dessertclicker.data.Datasource
data class DesertUIState(
    var revenue : Int = 0,
    var dessertSold : Int = 0,
    var currentDesertIndex : Int = 0,
    var currentDessertPrice :Int = Datasource.dessertList[currentDesertIndex].price ,
    @DrawableRes var currentDessertImageId: Int = Datasource.dessertList[currentDesertIndex].imageId
)
