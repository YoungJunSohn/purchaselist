package com.james.purchaselist.controller;

import com.james.purchaselist.domain.model.network.CrudInterface;
import com.james.purchaselist.domain.model.network.Header;
import com.james.purchaselist.domain.model.network.request.ItemRequest;
import com.james.purchaselist.domain.model.network.response.ItemResponse;
import com.james.purchaselist.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/item")
public class ItemController implements CrudInterface<ItemRequest, ItemResponse> {

    private final ItemService itemService;

    @Override
    @PostMapping("")
    public Header<ItemResponse> create(@RequestBody Header<ItemRequest> request) {
        log.info("ItemController : create / {}", request);
        return itemService.create(request);
    }

    @Override
    @GetMapping("/{id}")
    public Header<ItemResponse> read(@PathVariable Long id) {
        log.info("ItemController : read / {}", id);
        return itemService.read(id);
    }

    @Override
    @PutMapping()
    public Header<ItemResponse> update(@RequestBody Header<ItemRequest> request) {
        log.info("ItemController : update / {}", request);
        return itemService.update(request);
    }

    @Override
    @DeleteMapping("/{id}")
    public Header<ItemResponse> delete(@PathVariable Long id) {
        log.info("ItemController : delete / {}", id);
        return itemService.delete(id);
    }
}
