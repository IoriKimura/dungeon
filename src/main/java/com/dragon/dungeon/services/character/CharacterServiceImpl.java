package com.dragon.dungeon.services.character;

import org.springframework.stereotype.Service;

import com.dragon.dungeon.dao.UserDao;
import com.dragon.dungeon.dao.character.AttackSpellsDao;
import com.dragon.dungeon.dao.character.CharacterDao;
import com.dragon.dungeon.dao.character.FeaturesDao;
import com.dragon.dungeon.dao.character.InventoryDao;
import com.dragon.dungeon.dao.character.SkillsDao;
import com.dragon.dungeon.dao.character.StatsDao;
import com.dragon.dungeon.dao.character.ThrowsDao;
import com.dragon.dungeon.dto.models.characterModels.CharacterModel;
import com.dragon.dungeon.dto.request.AddCharacterRequest;
import com.dragon.dungeon.dto.request.CollectionRequest;
import com.dragon.dungeon.dto.response.CollectionResponse;
import com.dragon.dungeon.entities.UserEntity;
import com.dragon.dungeon.entities.character.AttackSpellsEntity;
import com.dragon.dungeon.entities.character.CharacterEntity;
import com.dragon.dungeon.entities.character.FeaturesEntity;
import com.dragon.dungeon.entities.character.InventoryEntity;
import com.dragon.dungeon.entities.character.SavingThrowsEntity;
import com.dragon.dungeon.entities.character.SkillsEntity;
import com.dragon.dungeon.entities.character.StatsEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CharacterServiceImpl implements CharacterService {

    private final StatsDao statsDao;

    private final UserDao userDao;

    private final ThrowsDao throwsDao;

    private final SkillsDao skillsDao;

    private final InventoryDao inventoryDao;

    private final AttackSpellsDao attackSpellsDao;

    private final FeaturesDao featuresDao;

    private final CharacterDao characterDao;
    
    @Override
    public CharacterModel create(AddCharacterRequest request, String uMail) {

        UserEntity user = userDao.getUserEntityByEmail(uMail);

        StatsEntity stats = statsDao.saveEntity(request.getStats());

        SavingThrowsEntity sThrows = throwsDao.saveEntity(request.getSThrows());

        SkillsEntity skills = skillsDao.saveEntity(request.getSkills());

        InventoryEntity inventory = inventoryDao.saveEntity(request.getInventory());

        AttackSpellsEntity attackSpells = attackSpellsDao.saveEntity(request.getAttack());

        FeaturesEntity features = featuresDao.saveEntity(request.getFeatures());
        
        CharacterEntity character = CharacterEntity.builder()
                .owner(user)
                .stats(stats)
                .sThrows(sThrows)
                .skills(skills)
                .inventory(inventory)
                .attack(attackSpells)
                .features(features)
                .cName(request.getCName())
                .cRace(request.getCRace())
                .cClass(request.getCClass())
                .background(request.getBackground())
                .level(request.getLevel())
            .build();

        return characterDao.saveCharacter(character);
    }

    @Override
    public CollectionResponse getCollection(String uMail) {
        return CollectionResponse.builder()
        .collection(characterDao.getCollection(uMail))
        .build();
    }

    @Override
    public CharacterModel getCharacter(String uMail, String cId) {
        UserEntity user = userDao.getUserEntityByEmail(uMail);
        return characterDao.getCharacter(user, cId);
    }
    
}
