package com.mansao.characterhilt.data.remote.response

import com.google.gson.annotations.SerializedName

data class GetAllCharactersResponse(

	@field:SerializedName("GetAllCharactersResponse")
	val getAllCharactersResponse: List<GetAllCharactersResponseItem>
)

data class Wand(

	@field:SerializedName("core")
	val core: String,

	@field:SerializedName("length")
	val length: Double,

	@field:SerializedName("wood")
	val wood: String
)

data class GetAllCharactersResponseItem(

	@field:SerializedName("patronus")
	val patronus: String,

	@field:SerializedName("hogwartsStudent")
	val hogwartsStudent: Boolean,

	@field:SerializedName("image")
	val image: String,

	@field:SerializedName("ancestry")
	val ancestry: String,

	@field:SerializedName("gender")
	val gender: String,

	@field:SerializedName("alive")
	val alive: Boolean,

	@field:SerializedName("hairColour")
	val hairColour: String,

	@field:SerializedName("dateOfBirth")
	val dateOfBirth: String,

	@field:SerializedName("house")
	val house: String,

	@field:SerializedName("hogwartsStaff")
	val hogwartsStaff: Boolean,

	@field:SerializedName("alternate_names")
	val alternateNames: List<String>,

	@field:SerializedName("actor")
	val actor: String,

	@field:SerializedName("alternate_actors")
	val alternateActors: List<String>,

	@field:SerializedName("species")
	val species: String,

	@field:SerializedName("wand")
	val wand: Wand,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("wizard")
	val wizard: Boolean,

	@field:SerializedName("eyeColour")
	val eyeColour: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("yearOfBirth")
	val yearOfBirth: Int
)
