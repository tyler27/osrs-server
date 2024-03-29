package com.osrs.cache.entry.config.obj

import com.osrs.cache.entry.EntryType
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class ObjEntryType(
    override val id: Int,
    var model: Int = 0,
    var name: String = "null",
    var zoom2d: Int = 2000,
    var xan2d: Int = 0,
    var yan2d: Int = 0,
    var zan2d: Int = 0,
    var weight: Int = 0,
    var offsetX2d: Int = 0,
    var offsetY2d: Int = 0,
    var isStackable: Boolean = false,
    var price: Int = 1,
    var wearPos1: Int = 0,
    var wearPos2: Int = 0,
    var wearPos3: Int = 0,
    var colorFind: Array<Int?> = emptyArray(),
    var colorReplace: Array<Int?> = emptyArray(),
    var textureFind: Array<Int?> = emptyArray(),
    var textureReplace: Array<Int?> = emptyArray(),
    var isMembersOnly: Boolean = false,
    var groundActions: List<String> = listOf("null", "null", "Take", "null", "null"),
    var inventoryActions: List<String> = listOf("null", "null", "null", "null", "Drop"),
    var shiftClickIndex: Int = -2,
    var maleModel: Int = -1,
    var maleModel1: Int = -1,
    var maleOffset: Int = 0,
    var femaleModel: Int = -1,
    var femaleModel1: Int = -1,
    var femaleOffset: Int = 0,
    var maleModel2: Int = -1,
    var femaleModel2: Int = -1,
    var maleHeadModel: Int = -1,
    var maleHeadModel2: Int = -1,
    var femaleHeadModel: Int = -1,
    var femaleHeadModel2: Int = -1,
    var note: Int = -1,
    var noteTemplate: Int = -1,
    var resizeX: Int = 128,
    var resizeY: Int = 128,
    var resizeZ: Int = 128,
    var ambient: Int = 0,
    var contrast: Int = 0,
    var team: Int = 0,
    var isTradeable: Boolean = false,
    var unnotedId: Int = -1,
    var notedId: Int = -1,
    var placeholder: Int = -1,
    var placeholderTemplate: Int = -1,
    var params: Map<Int, @Contextual Any> = mapOf(),
) : EntryType(id)
