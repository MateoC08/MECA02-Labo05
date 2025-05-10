package com.pmtaller2.mecados05

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pmtaller2.mecados05.ui.components.Cards
import com.pmtaller2.mecados05.models.viewmodel
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView(viewModel: viewmodel = viewModel()) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = { viewModel.openAddDialog() }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add",
                    tint = Color.Black,
                )
            }
        }
    ) { paddingValues ->
        if (viewModel.isAddDialogOpen) {
            Dialog(
                onDismissRequest = { viewModel.closeDialogs() },
                properties = DialogProperties(
                    dismissOnBackPress = true,
                    dismissOnClickOutside = true
                )
            ) {
                Card(modifier = Modifier.padding(16.dp)) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Agregar tarea",
                            style = MaterialTheme.typography.headlineSmall,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 16.dp),
                            textAlign = TextAlign.Center
                        )
                        TextField(
                            value = viewModel.newCard.title,
                            onValueChange = viewModel::onTitleChange,
                            label = { Text("Title") },
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        TextField(
                            value = viewModel.newCard.description,
                            onValueChange = viewModel::onDescriptionChange,
                            label = { Text("Description") },
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        TextField(
                            value = viewModel.newCard.endDate.toString(),
                            onValueChange = {},
                            readOnly = true,
                            label = { Text("Fecha") },
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(
                            onClick = { viewModel.openDateDialog() },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Seleccionar fecha")
                        }

                        if (viewModel.isDateDialogOpen) {
                            val datePickerState = rememberDatePickerState(initialSelectedDateMillis = Date().time)
                            DatePickerDialog(
                                onDismissRequest = { viewModel.closeDialogs() },
                                confirmButton = {
                                    Button(onClick = {
                                        datePickerState.selectedDateMillis?.let {
                                            viewModel.onDateSelected(Date(it))
                                        }
                                        viewModel.closeDialogs()
                                        viewModel.openAddDialog() // reabrimos el diálogo principal
                                    }) {
                                        Text("OK")
                                    }
                                }
                            ) {
                                DatePicker(state = datePickerState)
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))
                        Button(
                            onClick = { viewModel.addCard() },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Agregar")
                        }
                    }
                }
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = paddingValues.calculateTopPadding() + 16.dp)
        ) {
            val cards = viewModel.cardList
            items(cards.size) { index ->
                val card = cards[index]
                Cards(
                    pos = index,
                    max = cards.size - 1,
                    title = card.title,
                    description = card.description,
                    endDate = card.endDate,
                    checked = card.checked,
                    delete = viewModel::deleteCard,
                    changePosition = viewModel::moveCard
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}
