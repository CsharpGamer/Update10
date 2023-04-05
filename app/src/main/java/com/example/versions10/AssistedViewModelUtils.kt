package com.example.versions10

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.EntryPointAccessors

//Used for TimeslotViewModel. Is for AssistedInject in Compose
//Source:https://github.com/PatilShreyas/NotyKT/blob/0ad40f95026251cc342a099c5c2334543a643410/noty-android/app/composeapp/src/main/java/dev/shreyaspatil/noty/composeapp/utils/AssistedViewModelUtils.kt
@Composable
inline fun <reified VM : ViewModel> assistedViewModel(
    viewModelStoreOwner: ViewModelStoreOwner = checkNotNull(LocalViewModelStoreOwner.current) {
        "No ViewModelStoreOwner was provided via LocalViewModelStoreOwner"
    },
    provideFactory: MainActivity.ViewModelFactoryProvider.() -> ViewModelProvider.Factory,
): VM {
    val factory = provideFactory(assistedViewModelFactory())
    return viewModel(viewModelStoreOwner, factory = factory)
}

@Composable
fun assistedViewModelFactory() = EntryPointAccessors.fromActivity(
    LocalContext.current as Activity,
    MainActivity.ViewModelFactoryProvider::class.java
)