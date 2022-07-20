package com.example.coroutinestesting

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Test

@ExperimentalCoroutinesApi
class PostRepositoryImplTest {

    private val systemUnderTest = PostRepositoryImpl()

    @Test
    fun `getPost - check method returns a valid post after waiting for it`() = runTest {
        val data = systemUnderTest.getPost()
        assertThat(data).isNotNull()
        assertThat(data.title).isEqualTo("Title")
    }

    // StandardTestDispatcher
    @Test
    fun `createPost - check method returns two posts creating them in two different coroutines`() =
        runTest {
            launch { systemUnderTest.createPost("Title A") }
            launch { systemUnderTest.createPost("Title B") }
            // Yield the test until all coroutines finish
            advanceUntilIdle()

            assertThat(systemUnderTest.getAllPosts()).isEqualTo(listOf(Post("Title A"), Post("Title B")))
        }

    @Test
    fun `createPost - check method returns two posts creating them in two different coroutines using UnconfinedTestDispatcher`() =
        runTest(UnconfinedTestDispatcher()) {
            launch { systemUnderTest.createPost("Title A") }
            launch { systemUnderTest.createPost("Title B") }

            assertThat(systemUnderTest.getAllPosts()).isEqualTo(listOf(Post("Title A"), Post("Title B")))
        }
}