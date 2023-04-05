package com.example.versions10

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

//Source:https://github.com/PatilShreyas/NotyKT/blob/9ebd78f37334c9af1f90ca9e9cf7fd241811f9f5/noty-android/app/src/main/java/dev/shreyaspatil/noty/view/viewmodel/NoteDetailViewModel.kt
@Module
@InstallIn(ActivityRetainedComponent::class)
interface AssistedInjectModule

//@HiltViewModel
class TimeslotViewModel @AssistedInject constructor(
    @Assisted private val timeslotId: Int,
) : ViewModel() {


    init {
        println("$TAG.init() start timeslotId=$timeslotId")
    }




    //Source:https://github.com/PatilShreyas/NotyKT/blob/9ebd78f37334c9af1f90ca9e9cf7fd241811f9f5/noty-android/app/src/main/java/dev/shreyaspatil/noty/view/viewmodel/NoteDetailViewModel.kt
    @AssistedFactory
    interface Factory {
        fun create(timeslotId: Int): TimeslotViewModel
    }

    //Source:https://github.com/PatilShreyas/NotyKT/blob/9ebd78f37334c9af1f90ca9e9cf7fd241811f9f5/noty-android/app/src/main/java/dev/shreyaspatil/noty/view/viewmodel/NoteDetailViewModel.kt
    @Suppress("UNCHECKED_CAST")
    companion object {
        private const val TAG = "TimeslotViewModel"

        fun provideFactory(factory: Factory, id: Int): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return factory.create(id) as T
                }
            }
        }
    }

}

