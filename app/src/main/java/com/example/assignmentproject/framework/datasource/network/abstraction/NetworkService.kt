package com.example.assignmentproject.framework.datasource.network.abstraction

import com.example.assignmentproject.business.domain.model.PlantixData

/**
 * Created by Vinit Saxena on 31/07/21.
 */
interface NetworkService {
    suspend fun readData(): PlantixData
    suspend fun readDataFromAsset(): PlantixData
    suspend fun writeData(data: PlantixData)
}