package com.arabic.kamuslinguistik.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arabic.kamuslinguistik.data.DatabaseSeeder1
import com.arabic.kamuslinguistik.data.IstilahDao1
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlin.collections.emptyList

class IstilahViewModel1(
    private val dao: IstilahDao1
) : ViewModel() {

    fun seedDatabase1(context: Context) {
        viewModelScope.launch {
            val count = dao.countData()
            if (count == 0) {
                val data = DatabaseSeeder1.loadIstilahBagian1(context)
                dao.insertAll(data)
            }
        }
    }

    val istilahList1 = dao.getAll()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

}

