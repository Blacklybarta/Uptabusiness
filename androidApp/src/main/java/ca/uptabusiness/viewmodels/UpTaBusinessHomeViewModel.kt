package ca.uptabusiness.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import ca.uptabusiness.android.R

class UpTaBusinessViewModel : ViewModel() {

    val foodState: SnapshotStateList<Int> = mutableStateListOf<Int>().apply {
        addAll(getCulinaryPictures())
    }
    val eventsState: SnapshotStateList<Int> = mutableStateListOf<Int>().apply {
        addAll(getEventsPictures())
    }

    private fun getEventsPictures(shuffled: Boolean = false): List<Int> {
        val photos = listOf(
            R.drawable.corpo_produit_2,
            R.drawable.corpo_produit__3,
            R.drawable.corpo_produit__4,
            R.drawable.corpo_produit__5,
            R.drawable.corpo_produit__6,
            R.drawable.corpo_produit__7,
            R.drawable.corpo_produit__8,
            R.drawable.evenement__94,
            R.drawable.evenement__95,
            R.drawable.evenement__96,
            R.drawable.evenement__97,
            R.drawable.evenement__98,
            R.drawable.evenement__99,
            R.drawable.evenement__100,
            R.drawable.evenement__101,
            R.drawable.evenement__104,
            R.drawable.evenement__105,
            R.drawable.evenement__106,
            R.drawable.evenement__107,
            R.drawable.evenement__108,
            R.drawable.evenement__109,
            R.drawable.evenement__110,
            R.drawable.evenement__111
        )
        return if (shuffled) photos.shuffled() else photos
    }

    private fun getCulinaryPictures(shuffled: Boolean = false): List<Int> {
        val photos = listOf(
            R.drawable.gateaux_fete_des_meres__2,
            R.drawable.gateaux_fete_des_meres__3,
            R.drawable.gateaux_fete_des_meres__4,
            R.drawable.gateaux_fete_des_meres__5,
            R.drawable.gateaux_fete_des_meres__6,
            R.drawable.gateaux_fete_des_peres__2,
            R.drawable.gateaux_fete_des_peres__3,
            R.drawable.gateaux_fete_des_peres__4,
            R.drawable.gateaux_fete_des_peres__5,
            R.drawable.gateaux_fete_des_peres__6,
            R.drawable.gateaux_fete_des_peres__7,
            R.drawable.gateaux_fete_des_peres__8,
            R.drawable.gateaux_fete_des_peres__9,
            R.drawable.gateaux_fete_des_peres__10,
            R.drawable.gateaux_fete_des_peres__11,
            R.drawable.gateaux_fete_des_peres__12,
            R.drawable.gateaux_fete_des_peres__13,
            R.drawable.gateaux_fete_des_peres__14,
            R.drawable.gateaux_fete_des_peres__15,
            R.drawable.gateaux_fete_des_peres__16,
            R.drawable.gateaux_fete_des_peres__17,
            R.drawable.gateauxt_2,
            R.drawable.gateauxt_2_2,
            R.drawable.gateauxt_2_3,
            R.drawable.gateauxt_2_4,
            R.drawable.gateauxt_2_5,
            R.drawable.gateauxt_2_6,
            R.drawable.gateauxt_2_7,
            R.drawable.gateauxt_2_8,
            R.drawable.gateauxt_2_9,
            R.drawable.saint_valentin_cookie_1,
            R.drawable.saint_valentin_cookie_2,
            R.drawable.saint_valentin_cookie_2_2,
            R.drawable.saint_valentin_cookie_2_3,
            R.drawable.saint_valentin_cookie_2_4,
            R.drawable.saint_valentin_cookie_2_5,
            R.drawable.saint_valentin_cookie_2_6,
            R.drawable.saint_valentin_cookie_2_7,
        )

        return if (shuffled) photos.shuffled() else photos
    }

    private fun refreshEvents() {
        eventsState.clear()
        eventsState.addAll(getEventsPictures(true))
    }

    private fun refreshFood() {
        foodState.clear()
        foodState.addAll(getCulinaryPictures(true))
    }

    fun onEvent(event: UpTaBusinessEvent) {
        when (event) {
            UpTaBusinessEvent.RefreshEvents -> refreshEvents()
            UpTaBusinessEvent.RefreshFood -> refreshFood()
        }
    }
}

sealed interface UpTaBusinessEvent {
    data object RefreshEvents : UpTaBusinessEvent
    data object RefreshFood : UpTaBusinessEvent
}
