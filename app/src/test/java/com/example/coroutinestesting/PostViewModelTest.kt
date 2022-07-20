package com.example.coroutinestesting

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class PostViewModelTest {

    private val systemUnderTest = PostViewModel()

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    /*@Test
    fun `loadMessage - get the expected value mocking main dispatcher`() = runTest {
        val testDispatcher = UnconfinedTestDispatcher(testScheduler)
        Dispatchers.setMain(testDispatcher)
        try {
            systemUnderTest.loadMessage()
            assertThat(systemUnderTest.message.value).isEqualTo("Hello testers!")
        } finally {
            Dispatchers.resetMain()
        }
    }*/

    @Test
    fun `loadMessage - get the expected value mocking main dispatcher`() = runTest {
        systemUnderTest.loadMessage()
        assertThat(systemUnderTest.message.value).isEqualTo("Hello testers!")
    }
}