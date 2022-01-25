package com.ukejee.lushandroidtaskapplication.feature.launch.model

import com.ukejee.lushandroidtaskapplication.data.api.launch.model.GetLaunchResponse
import com.ukejee.lushandroidtaskapplication.data.api.launch.model.Links
import com.ukejee.lushandroidtaskapplication.data.api.launch.model.Patch
import org.junit.Assert.*
import org.junit.Test

class LaunchTest {

    @Test
    fun fromGetLaunchResponse_correctGetLaunchResponse_returnsCorrectLaunch() {
        //Given
        val response = GetLaunchResponse(id = "1",
            name = "TestLaunch", links = Links(patch = Patch("largePatch", "smallPatch")),
            success = true, dateUtc = "2006-03-24T22:30:00.000Z"
        )
        val launch = Launch(id = "1", name = "TestLaunch", launchDate = "24-03-2006", missionStatus = "Successful", badgeImageUrl = "largePatch")

        //When
        val result = Launch.fromGetLaunchResponse(response)

        //Then
        assertEquals(result, launch)
    }

    @Test
    fun fromGetLaunchResponse_getLaunchResponseWithFalseSuccess_returnsLaunchWithFailedMissionStatus() {
        //Given
        val response = GetLaunchResponse(id = "1",
            name = "TestLaunch", links = Links(patch = Patch("largePatch", "smallPatch")),
            success = false, dateUtc = "2006-03-24T22:30:00.000Z"
        )
        val launch = Launch(id = "1", name = "TestLaunch", launchDate = "24-03-2006", missionStatus = "Failed", badgeImageUrl = "largePatch")

        //When
        val result = Launch.fromGetLaunchResponse(response)

        //Then
        assertEquals(result, launch)
    }

    @Test
    fun fromGetLaunchResponse_getLaunchResponseWithoutLargePatch_returnsLaunchWithSmallPatch() {
        //Given
        val response = GetLaunchResponse(id = "1",
            name = "TestLaunch", links = Links(patch = Patch(small = "smallPatch")),
            success = false, dateUtc = "2006-03-24T22:30:00.000Z"
        )
        val launch = Launch(id = "1", name = "TestLaunch", launchDate = "24-03-2006", missionStatus = "Failed", badgeImageUrl = "smallPatch")

        //When
        val result = Launch.fromGetLaunchResponse(response)

        //Then
        assertEquals(result, launch)
    }

    @Test
    fun fromGetLaunchResponse_getLaunchResponseWithoutName_returnsLaunchWithDataNotFound() {
        //Given
        val response = GetLaunchResponse( id = "1", links = Links(patch = Patch(small = "smallPatch")),
            success = false, dateUtc = "2006-03-24T22:30:00.000Z"
        )
        val launch = Launch(id = "1", name = "Data is not available", launchDate = "24-03-2006", missionStatus = "Failed", badgeImageUrl = "smallPatch")

        //When
        val result = Launch.fromGetLaunchResponse(response)

        //Then
        assertEquals(result, launch)
    }

    @Test
    fun fromGetLaunchResponse_getLaunchResponseWithoutDate_returnsLaunchWithDataNotFound() {
        //Given
        val response = GetLaunchResponse( id = "1", links = Links(patch = Patch(small = "smallPatch")),
            success = false
        )
        val launch = Launch(id = "1", name = "Data is not available", launchDate = "Data is not available", missionStatus = "Failed", badgeImageUrl = "smallPatch")

        //When
        val result = Launch.fromGetLaunchResponse(response)

        //Then
        assertEquals(result, launch)
    }

    @Test
    fun fromChangeDateFormat_correctDateString_returnsCorrectFormattedDateString() {
        //Given
        val date = "2006-03-24T22:30:00.000Z"

        //When
        val result = Launch.changeDateFormat(date)

        //Then
        assertEquals(result, "24-03-2006")
    }

    @Test
    fun fromChangeDateFormat_wrongDateString_returnsNullDateString() {
        //Given
        val date = "2006-03-24P22:30:00.000Z"

        //When
        val result = Launch.changeDateFormat(date)

        //Then
        assertEquals(result, null)
    }

    @Test
    fun fromChangeDateFormat_nullDateString_returnsNullDateString() {
        //Given
        val date = null

        //When
        val result = Launch.changeDateFormat(date)

        //Then
        assertEquals(result, null)
    }
}