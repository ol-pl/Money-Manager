package com.olpl.core_presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olpl.core_presentation.viewmodel.events.Events
import com.olpl.core_presentation.viewmodel.events.UiEvents
import com.olpl.utils.StringId
import com.radusalagean.infobarcompose.InfoBarMessage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

abstract class ViewModelExp<E : Events, UiE : UiEvents> : ViewModel() {
    protected val dataScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    protected open val _uiEvents = MutableSharedFlow<UiE>()
    val uiEvents = _uiEvents.asSharedFlow()

    protected val _infoBarState = mutableStateOf<InfoBarMessage?>(null)
    var infoBarState: State<InfoBarMessage?> = _infoBarState

    abstract fun onEvent(event: E)

    fun hideInfoBar() {
        _infoBarState.value = null
    }

    protected fun sendUiEvent(uiEvent: UiE) {
        viewModelScope.launch {
            _uiEvents.emit(uiEvent)
        }
    }

    protected fun showInfoBar(
        text: StringId,
        timeInSeconds: InfoBarTimeLength = InfoBarTimeLength.Short,
        actionText: StringId? = null,
        onAction: () -> Unit = {}
    ) {
        val newInfoBarMessage = InfoBarMessage(
            textStringResId = text,
            actionStringResId = actionText,
            displayTimeSeconds = timeInSeconds.timeInSeconds,
            onAction = onAction
        )
        _infoBarState.value = newInfoBarMessage
    }

    override fun onCleared() {
        dataScope.cancel()
        super.onCleared()
    }

    sealed class InfoBarTimeLength(val timeInSeconds: Int) {
        data object Short : InfoBarTimeLength(3)
        data object Long : InfoBarTimeLength(5)
    }
}