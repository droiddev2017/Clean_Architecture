package com.example.assignmentproject.framework.datasource.network.implementation

import android.content.Context
import com.example.assignmentproject.business.domain.model.PlantixData
import com.example.assignmentproject.framework.datasource.network.abstraction.NetworkService
import com.example.assignmentproject.framework.util.readFromAsset
import com.example.assignmentproject.framework.util.readNetworkFromInternalStorage
import com.example.assignmentproject.framework.util.writeNetworkToInternalStorage
import com.google.gson.Gson
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Vinit Saxena on 31/07/21.
 */
@Singleton
class NetworkServiceImpl @Inject constructor(val context: Context, val gson: Gson) :
    NetworkService {
    override suspend fun readData(): PlantixData {
        return if (context.readNetworkFromInternalStorage().isNullOrEmpty()) {
            PlantixData.EMPTY_INSTANCE
        } else {
            gson.fromJson(
                context.readNetworkFromInternalStorage(),
                PlantixData::class.java
            )
        }
    }

    override suspend fun readDataFromAsset(): PlantixData = gson.fromJson(
        context.readFromAsset("names_network.json"),
        PlantixData::class.java
    )

    override suspend fun writeData(data: PlantixData) {
        context.writeNetworkToInternalStorage(gson.toJson(data))
    }
}