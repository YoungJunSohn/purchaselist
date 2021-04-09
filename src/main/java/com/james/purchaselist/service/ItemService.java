package com.james.purchaselist.service;

import com.james.purchaselist.domain.model.entity.Items;
import com.james.purchaselist.domain.model.network.CrudInterface;
import com.james.purchaselist.domain.model.network.Header;
import com.james.purchaselist.domain.model.network.request.ItemRequest;
import com.james.purchaselist.domain.model.network.response.ItemResponse;
import com.james.purchaselist.repository.ItemsRepository;
import com.james.purchaselist.repository.PartnersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class ItemService implements CrudInterface<ItemRequest, ItemResponse> {

    private final ItemsRepository itemsRepository;
    private final PartnersRepository partnersRepository;

    @Override
    public Header<ItemResponse> create(Header<ItemRequest> request) {
        log.debug("1");

        ItemRequest itemRequest = request.getData();

        log.debug("{}", itemRequest);

        log.debug("2");
        Items item = Items.builder()
                .status(itemRequest.getStatus())
                .name(itemRequest.getName())
                .title(itemRequest.getTitle())
                .content(itemRequest.getContent())
                .price(itemRequest.getPrice())
                .brandName(itemRequest.getBrandName())
                .registeredAt(LocalDateTime.now())
                .partner(partnersRepository.getOne(itemRequest.getPartnerId()))
                .build();

        log.debug("3");
        Items newItem = itemsRepository.save(item);

        log.debug("4");
        return toResponse(newItem);
    }

    @Override
    public Header<ItemResponse> read(Long id) {
        Optional<Items> optionalItem = itemsRepository.findById(id);
        return optionalItem.map(item -> toResponse(item)
        )
                .orElseGet(() -> Header.error("해당 물품 없음"));
    }

    @Override
    public Header<ItemResponse> update(Header<ItemRequest> request) {

        ItemRequest itemRequest = request.getData();

        Optional<Items> optionalItem = itemsRepository.findById(itemRequest.getId());


        return optionalItem.map(item -> {
            item.setName(itemRequest.getName())
                    .setStatus(itemRequest.getStatus())
                    .setTitle(itemRequest.getTitle())
                    .setContent(itemRequest.getContent())
                    .setPrice(itemRequest.getPrice())
                    .setBrandName(itemRequest.getBrandName())
                    .setUnregisteredAt(itemRequest.getUnregisteredAt());
            return item; //item modified

        })
                .map(modifiedItem -> toResponse(modifiedItem))
                .orElseGet(() -> Header.error("해당 물품이 없습니다."));
    }

    @Override
    public Header delete(Long id) {

        return itemsRepository.findById(id)
                .map(item -> {
                    itemsRepository.delete(item);
                    return Header.ok();
                })
                .orElseGet(() -> Header.error("해당 물품이 없습니다."));
    }//delete()

    //response
    public Header<ItemResponse> toResponse(Items item) {
        ItemResponse resp = ItemResponse.builder()
                .id(item.getId())
                .status(item.getStatus())
                .name(item.getName())
                .title(item.getTitle())
                .content(item.getContent())
                .price(item.getPrice())
                .brandName(item.getBrandName())
                .registeredAt(item.getRegisteredAt())
                .partnerId(item.getPartner().getId())
                .unregisteredAt(item.getUnregisteredAt()).build();

        return Header.ok(resp);
    }
}
