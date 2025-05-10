package com.pmtaller2.mecados05.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.util.Date

class viewmodel : ViewModel() {

    private val _cardList = mutableStateListOf<Card>()
    val cardList: List<Card> get() = _cardList

    var newCard by mutableStateOf(Card(title = "", description = ""))
        private set

    var isAddDialogOpen by mutableStateOf(false)
        private set

    var isDateDialogOpen by mutableStateOf(false)
        private set

    fun onTitleChange(newTitle: String) {
        newCard = newCard.copy(title = newTitle)
    }

    fun onDescriptionChange(newDescription: String) {
        newCard = newCard.copy(description = newDescription)
    }

    fun onDateSelected(date: Date) {
        newCard = newCard.copy(endDate = date)
    }

    fun addCard() {
        _cardList.add(newCard.copy(pos = _cardList.size))
        resetNewCard()
        closeDialogs()
    }

    fun deleteCard(pos: Int) {
        _cardList.removeAt(pos)
        updatePositions()
    }


    fun moveCard(from: Int, to: Int) {
        if (to in _cardList.indices) {
            val card = _cardList.removeAt(from)
            _cardList.add(to, card)
            updatePositions()
        }
    }

    private fun updatePositions() {
        _cardList.forEachIndexed { index, card ->
            _cardList[index] = card.copy(pos = index)
        }
    }

    private fun resetNewCard() {
        newCard = Card(title = "", description = "")
    }

    fun openAddDialog() {
        isAddDialogOpen = true
    }

    fun closeDialogs() {
        isAddDialogOpen = false
        isDateDialogOpen = false
    }

    fun openDateDialog() {
        isDateDialogOpen = true
    }
}
