package de.mycraftnote.code_channlenge.data.mapper

internal interface Mapper<FROM, TO> {
  fun map(from: FROM): TO
}