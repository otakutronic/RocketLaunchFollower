package com.lush.rocketlaunches.home.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lush.rocketlaunches.domain.usecase.GetRocketLaunchesUseCase
import com.lush.rocketlaunches.domain.model.Launch
import com.lush.rocketlaunches.home.util.asLiveData
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import com.lush.rocketlaunches.domain.model.Result
import com.lush.rocketlaunches.domain.util.Constants.ROCKET_ID

class HomeViewModel(private val getRocketLaunchesUseCase: GetRocketLaunchesUseCase
) : ViewModel() {

    private val _launches = MutableLiveData<Result<List<Launch>>>()
    val launches = _launches.asLiveData()

    init {
        getRocketLaunches()
    }

    fun getRocketLaunches() {
        getRocketLaunchesUseCase(ROCKET_ID).onEach {
            _launches.value = it
        }.launchIn(viewModelScope)
    }
}
