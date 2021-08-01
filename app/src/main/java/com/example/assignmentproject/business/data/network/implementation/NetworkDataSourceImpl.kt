package com.example.assignmentproject.business.data.network.implementation

import com.example.assignmentproject.business.data.network.abstraction.NetworkDataSource
import com.example.assignmentproject.business.domain.model.PlantixData
import com.example.assignmentproject.framework.datasource.network.abstraction.NetworkService
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Vinit Saxena on 31/07/21.
 */
@Singleton
class NetworkDataSourceImpl @Inject constructor(val networkService: NetworkService) :
    NetworkDataSource {
    override suspend fun readData(): PlantixData = networkService.readData()
    override suspend fun readDataFromAsset(): PlantixData = networkService.readDataFromAsset()

    override suspend fun writeData(data: PlantixData) {
        networkService.writeData(data)
    }
}