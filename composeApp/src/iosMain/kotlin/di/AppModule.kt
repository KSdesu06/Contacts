package di

import com.example.kat.database.ContactDatabase
import contacts.data.SqlDelightContactDataSource
import contacts.domain.ContactDataSource
import core.data.DatabaseDriverFactory

actual class AppModule {
    actual val contactDataSource: ContactDataSource by lazy {
        SqlDelightContactDataSource(
            db = ContactDatabase(
                driver = DatabaseDriverFactory().create()
            )
        )
    }
}