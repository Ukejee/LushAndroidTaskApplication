package com.ukejee.lushandroidtaskapplication.feature.launch.model

import com.ukejee.lushandroidtaskapplication.data.api.launch.model.GetLaunchResponse

data class Launch(
    val id: String?,
    val name: String,
    val launchDate: String,
    val missionStatus: String,
    val badgeImageUrl: String?
) {

    companion object {
        private const val DATA_NOT_FOUND = "Data is not available"

        fun fromGetLaunchResponse(response: GetLaunchResponse): Launch {
            val status = if (response.success != null) {
                if (response.success) "Successful" else "Failed"
            } else {
                DATA_NOT_FOUND
            }

            return Launch(
                response.id,
                response.name ?: DATA_NOT_FOUND,
                changeDateFormat(response.dateUtc) ?: DATA_NOT_FOUND,
                status,
                response.links?.patch?.large ?: response.links?.patch?.small
            )
        }

        fun changeDateFormat(date: String?): String? {
            var newString: String? = null
            if (date?.contains("T") == true) {
                val stringList = date.split("T")[0].split("-")
                if (stringList.size == 3) {
                    newString = "${stringList[2]}-${stringList[1]}-${stringList[0]}"
                }
            }
            return newString
        }

    }
}
