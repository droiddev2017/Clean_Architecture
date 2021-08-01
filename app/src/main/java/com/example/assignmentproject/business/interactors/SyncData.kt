package com.example.assignmentproject.business.interactors

import com.example.assignmentproject.business.data.cache.abstraction.CacheDataSource
import com.example.assignmentproject.business.data.network.abstraction.NetworkDataSource
import com.example.assignmentproject.business.domain.model.PlantixData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Vinit Saxena on 01/08/21.
 */
@Singleton
class SyncData @Inject constructor(
    val cacheDataSource: CacheDataSource,
    val networkDataSource: NetworkDataSource
) {

    suspend fun syn() = withContext(Dispatchers.IO) {
        val cacheData = cacheDataSource.readData()
        val networkData = networkDataSource.readData()

        syncNetworkDataToCacheData(cacheData, networkData)
    }

    private suspend fun syncNetworkDataToCacheData(
        cacheData: PlantixData,
        networkData: PlantixData
    ) = withContext(Dispatchers.IO) {
        if (networkData.version > cacheData.version) {
            cacheDataSource.writeData(networkData)
        }
    }

    private suspend fun firstTimeAddData() = withContext(Dispatchers.IO) {
        val networkData = networkDataSource.readDataFromAsset()
        networkDataSource.writeData(networkData)
        cacheDataSource.writeData(networkData)
    }

    suspend fun updateFakeServerData(version: Int) = withContext(Dispatchers.IO) {
        val networkData = networkDataSource.readData()
        if (networkData == PlantixData.EMPTY_INSTANCE) {
            firstTimeAddData()
        } else {
            if (version > networkData.version) {
                val list = networkData.names.toMutableList()
                list.shuffle()
                networkDataSource.writeData(networkData.copy(names = list, version = version))
                syn()
            }
        }
    }

}