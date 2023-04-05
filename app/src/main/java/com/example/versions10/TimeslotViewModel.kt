package com.example.versions10

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
interface AssistedInjectModule

class TimeslotViewModel @AssistedInject constructor(
    @Assisted private val timeslotId: Int,
) : ViewModel() {

   @AssistedFactory
    interface Factory {
        fun create(timeslotId: Int): TimeslotViewModel
    }

    @Suppress("UNCHECKED_CAST")
    companion object {
        fun provideFactory(factory: Factory, id: Int): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return factory.create(id) as T
                }
            }
        }
    }

}

