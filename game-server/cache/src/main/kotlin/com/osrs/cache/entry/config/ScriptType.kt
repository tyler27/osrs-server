package com.osrs.cache.entry.config

enum class ScriptType(
    val key: Char,
    val fullName: String
) {
    INTEGER('i', "integer"),
    BOOLEAN('1', "boolean"),
    SEQ('A', "seq"),
    COLOUR('C', "colour"),
    COMPONENT('I', "component"),
    IDKIT('K', "idkit"),
    MIDI('M', "midi"),
    SYNTH('P', "synth"),
    STAT('S', "stat"),
    COORDGRID('c', "coordgrid"),
    GRAPHIC('d', "graphic"),
    FONTMETRICS('f', "fontmetrics"),
    ENUM('g', "enum"),
    JINGLE('j', "jingle"),
    LOC('l', "loc"),
    MODEL('m', "model"),
    NPC('n', "npc"),
    OBJ('o', "obj"),
    NAMEDOBJ('O', "namedobj"),
    STRING('s', "string"),
    SPOTANIM('t', "spotanim"),
    INV('v', "inv"),
    TEXTURE('x', "texture"),
    CHAR('z', "char"),
    MAPSCENEICON('£', "mapsceneicon"),
    MAPELEMENT('µ', "mapelement"),
    HITMARK('×', "hitmark"),
    STRUCT('J', "struct");
}
