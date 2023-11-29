package contacts.data

import com.example.kat.database.ContactEntity
import contacts.domain.Contact

fun ContactEntity.toContact(): Contact {
    return Contact(
        id = id,
        firstName = firstName,
        lastName = lastName,
        email = email,
        phoneNumber = phoneNumber
    )
}