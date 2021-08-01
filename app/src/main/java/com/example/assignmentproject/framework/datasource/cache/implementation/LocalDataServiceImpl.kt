package com.example.assignmentproject.framework.datasource.cache.implementation

import android.content.Context
import com.example.assignmentproject.business.domain.model.PlantixData
import com.example.assignmentproject.framework.datasource.cache.abstraction.LocalCacheService
import com.example.assignmentproject.framework.util.readCacheFromInternalStorage
import com.example.assignmentproject.framework.util.writeCacheToInternalStorage
import com.google.gson.Gson
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Vinit Saxena on 31/07/21.
 */
@Singleton
class LocalDataServiceImpl @Inject constructor(val context: Context, val gson: Gson) :
    LocalCacheService {
    override suspend fun readData(): PlantixData {
        return if (context.readCacheFromInternalStorage().isNullOrEmpty()) {
            PlantixData.EMPTY_INSTANCE
        } else {
            gson.fromJson(
                context.readCacheFromInternalStorage(),
                PlantixData::class.java
            )
        }
    }


    override suspend fun writeData(data: PlantixData) {
        context.writeCacheToInternalStorage(gson.toJson(data))
    }
}