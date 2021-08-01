package com.example.assignmentproject.framework.datasource.cache.abstraction

import com.example.assignmentproject.business.domain.model.PlantixData

/**
 * Created by Vinit Saxena on 31/07/21.
 */
interface LocalCacheService {
    suspend fun readData(): PlantixData
    suspend fun writeData(data: PlantixData)
}