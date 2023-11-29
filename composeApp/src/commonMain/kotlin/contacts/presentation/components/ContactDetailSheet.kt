package contacts.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import contacts.domain.Contact
import contacts.presentation.ContactListEvent
import core.presentation.BottomSheetFromWish

@Composable
fun ContactDetailSheet(
    isOpen: Boolean,
    selectContact: Contact?,
   // onEvent: (ContactListEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    BottomSheetFromWish(
        visible = isOpen,
        modifier = modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopStart
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(Modifier.height(60.dp))
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = "close"
                )
                Spacer(Modifier.height(16.dp))
                Text(
                    text = "${selectContact?.firstName} ${selectContact?.lastName}",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )
                Spacer(Modifier.height(16.dp))
/*                EditRow(
                    onEditClick = {
                        selectContact?.let {
                            onEvent(ContactListEvent.EditContact(it))
                        }
                    },
                    onDeleteClick = {
                        onEvent(ContactListEvent.DeleteContact)
                    }
                )*/
                /*Spacer(Modifier.height(16.dp))
                ContactInfoSection(
                    title = "Phone number",
                    value = selectContact?.phoneNumber ?: "-",
                    icon = Icons.Rounded.Phone,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(16.dp))
                ContactInfoSection(
                    title = "Email",
                    value = selectContact?.email ?: "-",
                    icon = Icons.Rounded.Email,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(16.dp))*/
                /*Button(
                    onClick = {
                        onEvent(ContactListEvent.SaveContact)
                    }
                ) {
                    Text(text = "Save contact")
                }*/
            }
            /*IconButton(
                onClick = {
                    onEvent(ContactListEvent.DismissContact)
                }
            ) {
                Icon(
                    imageVector = Icons.Rounded.Close,
                    contentDescription = "close"
                )
            }*/
        }
    }
}

@Composable
private fun EditRow(
    onEditClick: () -> Unit,
    onDeleteClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier) {
        IconButton(
            onClick = onEditClick
        ) {
            Icon(
                imageVector = Icons.Rounded.Edit,
                contentDescription = "Edit contact"
            )
        }
        IconButton(
            onClick = onDeleteClick
        ) {
            Icon(
                imageVector = Icons.Rounded.Delete,
                contentDescription = "Delete contact"
            )
        }
    }
}


@Composable
private fun ContactInfoSection(
    title: String,
    value: String,
    icon: ImageVector,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier
                .clip(CircleShape)
                .background(MaterialTheme.colors.secondary)
                .padding(8.dp),
            tint = MaterialTheme.colors.secondary
        )
        Spacer(Modifier.width(16.dp))
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = title,
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colors.secondary,
                fontSize = 12.sp
            )
            Text(
                text = value,
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colors.onBackground,
                fontSize = 18.sp
            )
        }
    }
}
