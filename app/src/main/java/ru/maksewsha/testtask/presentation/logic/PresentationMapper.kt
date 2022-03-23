package ru.maksewsha.testtask.presentation.logic

import ru.maksewsha.testtask.data.models.Characters
import ru.maksewsha.testtask.domain.models.CharacterDomain
import ru.maksewsha.testtask.domain.models.CharactersDomainModel
import ru.maksewsha.testtask.domain.utils.EntityMapper
import ru.maksewsha.testtask.presentation.models.CharacterPresentation
import ru.maksewsha.testtask.presentation.models.CharactersUIModel

class PresentationMapper : EntityMapper<CharactersDomainModel, CharactersUIModel> {
    override fun mapFromEntity(entity: CharactersDomainModel): CharactersUIModel {
        when (entity) {
            is CharactersDomainModel.Success -> {
                return CharactersUIModel.Success(
                    entity.data.map { ent ->
                        CharacterPresentation(
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
            is CharactersDomainModel.Fail -> {
                return CharactersUIModel.Fail(entity.errorMessage)
            }
        }
    }

}