package com.example.medicineapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.example.medicineapp.ui.screens.login.LogInScreen
import org.junit.Rule
import org.junit.Test

class LogInTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    //    testLogInScreen_displaysNameAndPasswordFields: This test verifies that the
    //    UI elements for name and password input are displayed correctly. It uses onNodeWithText to
    //    find the elements by their label text and assertIsDisplayed to assert their visibility.
    //    testLogInScreen_inputFieldsUpdateState: This test simulate
    @Test
    fun testLogInScreen_displaysNameAndPasswordFields() {
        composeTestRule.setContent {
            LogInScreen()
        }

        composeTestRule.onNodeWithText("Name").assertIsDisplayed()
        composeTestRule.onNodeWithText("Password").assertIsDisplayed()
    }


//    testLogInScreen_inputFieldsUpdateState: This test simulates user input into the
//    name and password fields. It uses performTextInput to enter text. Ideally,
//    you would assert that the internal state of the composable has been updated,
//    but since the state is not exposed, you might need to adjust your composable to
//    make it testable in this way (e.g., by using a ViewModel).
    @Test
    fun testLogInScreen_inputFieldsUpdateState() {
        composeTestRule.setContent {
            LogInScreen()
        }

        composeTestRule.onNodeWithText("Name").performTextInput("testuser")
        composeTestRule.onNodeWithText("Password").performTextInput("password123")

        // Assertions to verify the state has been updated would typically go here,
        // but since the state is internal to the composable, we can't directly access it.
        // Instead, you might want to expose the state via a ViewModel and verify its values.
    }


//    testLogInScreen_logInButtonTriggersNavigation: This test checks if clicking
//    the "Log In" button triggers the navigation to the home screen. It uses a lambda
//    function navigateToHome to track whether navigation occurred and asserts its value
//    after the button click.
    @Test
    fun testLogInScreen_logInButtonTriggersNavigation() {
        var navigatedToHome = false
        composeTestRule.setContent {
            LogInScreen(navigateToHome = { navigatedToHome = true })
        }

        composeTestRule.onNodeWithText("Log In").performClick()

        // Assertion to verify navigation occurred
        assert(navigatedToHome)
    }
}