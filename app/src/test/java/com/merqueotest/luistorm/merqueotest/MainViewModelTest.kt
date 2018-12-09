package com.merqueotest.luistorm.merqueotest

import android.app.Application
import androidx.test.core.app.ApplicationProvider
import org.junit.Test
import com.google.common.truth.Truth.assertThat
import com.merqueotest.luistorm.merqueotest.ui.viewmodels.MainViewModel

class MainViewModelTest {

    private val context = ApplicationProvider.getApplicationContext<Application>()

    @Test
    fun getMoviesFromDatabaseTest() {
        val mainViewModel = MainViewModel(context)
        assertThat(mainViewModel.getPopularMovies(context.applicationContext))
    }

}