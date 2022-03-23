package ru.maksewsha.testtask.data

import ru.maksewsha.testtask.data.models.Character
import ru.maksewsha.testtask.data.models.Characters
import ru.maksewsha.testtask.domain.models.CharacterDomain
import ru.maksewsha.testtask.domain.models.CharactersDomainModel
import ru.maksewsha.testtask.domain.utils.EntityMapper

class DataMapper : EntityMapper<Characters, CharactersDomainModel> {
    override fun mapFromEntity(entity: Characters): CharactersDomainModel {
        when (entity) {
            is Characters.Success -> {
                return CharactersDomainModel.Success(
                    entity.data.map { ent ->
                        CharacterDomain(
                            ent.charId,
                            ent.name,
                            ent.birthday,
                            ent.occupation,
                            ent.img,
                            ent.status,
                            ent.appearance,
                            ent.nickname,
                            ent.portrayed
                        )
                    }
                )
            }
            is Characters.Fail -> {
                return CharactersDomainModel.Fail(entity.errorMessage)
            }
        }
    }
}