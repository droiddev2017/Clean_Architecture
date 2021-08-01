package com.example.assignmentproject.business.data.cache.implementation

import com.example.assignmentproject.business.data.cache.abstraction.CacheDataSource
import com.example.assignmentproject.business.domain.model.PlantixData
import com.example.assignmentproject.framework.datasource.cache.abstraction.LocalCacheService
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Vinit Saxena on 31/07/21.
 */
@Singleton
class CacheDataSourceImpl @Inject constructor(private val localDataService: LocalCacheService) :
    CacheDataSource {
    override suspend fun readData(): PlantixData = localDataService.readData()

    override suspend fun writeData(data: PlantixData) {
        localDataService.writeData(data)
    }
}