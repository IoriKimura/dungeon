package com.dragon.dungeon.services.character;

import org.springframework.stereotype.Service;

import com.dragon.dungeon.dto.models.characterModels.CharacterModel;
import com.dragon.dungeon.dto.request.AddCharacterRequest;
import com.dragon.dungeon.entities.character.StatsEntity;
import com.dragon.repositories.character.StatsRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CharacterServiceImpl implements CharacterService {

    private final StatsRepo statsRepo;
    
    @Override
    public CharacterModel create(AddCharacterRequest request) {

        //Вынести в сервис другой
        StatsEntity stats = StatsEntity.builder()
                .bonus(request.getStats().getBonus())
                .strenght(request.getStats().getStrenght())
                .dexterity(request.getStats().getDexterity())
                .constitution(request.getStats().getConstitution())
                .intelligence(request.getStats().getIntelligence())
                .wisdom(request.getStats().getWisdom())
                .charisma(request.getStats().getCharisma())
                .armor(request.getStats().getArmor())
                .initiative(request.getStats().getInitiative())
                .speed(request.getStats().getSpeed())
                .hitDice(request.getStats().getHitDice())
                .hp(request.getStats().getHp())
            .build();
        
        stats = statsRepo.save(stats);

        // UserEntity user = userDao.getUserEntityByEmail(request.getEmail());

        // EventEntity event = eventDao.getEventFromName(request.getEventName());

        // TicketEntity ticket = TicketEntity.builder()
        //         .owner(user)
        //         .event(event)
        //         .ticketType(TicketType.valueOf(request.getTicketType()))
        //         .price(request.getPrice())
        //         .isRedeemed(false)
        //         .build();

        // ticket = ticketDao.createTicket(ticket);

        // OrderEntity order = OrderEntity.builder()
        //         .owner(user)
        //         .ticket(ticket)
        //         .paymentStatus(PaymentStatus.CREATED)
        //         .build();

        // return orderDao.createOrder(order, ticket);
    }
    
}
