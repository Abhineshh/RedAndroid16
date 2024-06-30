package com.example.tiptime

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.example.tiptime.ui.theme.TipTimeTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class TipUITests {

    @get:Rule
    val composablTestRule = createComposeRule()

    @Test
    fun calculate_20_percent_tip(){
        composablTestRule.setContent {
            TipTimeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    TipTimeLayout()
                }
            }
        }
        composablTestRule.onNodeWithText("Bill_Amount")
            .performTextInput("200")
        composablTestRule.onNodeWithText("Tip Percentage")
            .performTextInput("15")

        val expectedTip = NumberFormat.getCurrencyInstance().format(30)
        composablTestRule.onNodeWithText("Tip Amount: $expectedTip").assertExists(
            "No node with this text was found"
        )
    }
}