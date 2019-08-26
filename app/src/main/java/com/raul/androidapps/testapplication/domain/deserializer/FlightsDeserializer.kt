package com.raul.androidapps.testapplication.domain.deserializer

import com.google.gson.*
import com.raul.androidapps.testapplication.domain.model.Flight
import com.raul.androidapps.testapplication.domain.model.Itinerary
import com.raul.androidapps.testapplication.domain.model.Leg
import java.lang.reflect.Type


class FlightsDeserializer : JsonDeserializer<Flight> {

    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): Flight? =

        try {
            val listOfItineraries: MutableList<Itinerary> = mutableListOf()
            val tempListOfLegs: MutableList<Leg> = mutableListOf()
            val gson = Gson()

            val jsonObject = json.asJsonObject

            jsonObject.get("legs").asJsonArray.forEach {
                tempListOfLegs.add(gson.fromJson(it, Leg::class.java))
            }


            jsonObject.get("itineraries").asJsonArray.forEach {
                it.asJsonObject.apply {
                    val id = this.get("id")?.asString ?: ""
                    val price = this.get("price")?.asString ?: ""
                    val agent = this.get("agent")?.asString ?: ""
                    val agentRating = this.get("agent_rating")?.asFloat ?: 0f
                    val legs: MutableList<Leg> = mutableListOf()
                    this.get("legs").asJsonArray.forEach { legIdObject ->
                        val legId = legIdObject.asString
                        tempListOfLegs.firstOrNull { leg -> leg.id == legId }
                            ?.let { filteredLeg ->
                                legs.add(filteredLeg)
                            }
                    }
                    listOfItineraries.add(
                        Itinerary(
                            id = id,
                            price = price,
                            agent = agent,
                            agentRating = agentRating,
                            legs = legs
                        )
                    )
                }
            }

            Flight(listOfItineraries)

        } catch (e: JsonParseException) {
            null
        }

}
