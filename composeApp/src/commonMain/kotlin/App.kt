import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import contacts.presentation.ContactListScreen
import contacts.presentation.ContactListViewModel
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import di.AppModule
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App(appModule: AppModule) {
    MaterialTheme {
        val viewModel = getViewModel(
            key = "contact-screen",
            factory = viewModelFactory {
                ContactListViewModel(appModule.contactDataSource)
            }
        )
        val state by viewModel.state.collectAsState()
        ContactListScreen(
            state = state,
            newContact = viewModel.newContact,
            onEvent = viewModel::onEvent
        )
    }
}