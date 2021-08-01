package com.example.assignmentproject.business.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Vinit Saxena on 31/07/21.
 */
@Parcelize
data class PlantixData(val names: List<String>, val version: Int) : Parcelable {
    companion object {
        val EMPTY_INSTANCE = PlantixData(listOf(), -1);
    }
}
