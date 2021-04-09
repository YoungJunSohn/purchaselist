package com.james.purchaselist.controller;

import com.james.purchaselist.domain.model.network.CrudInterface;
import com.james.purchaselist.domain.model.network.Header;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
public abstract class CrudController<Req, Resp> implements CrudInterface<Req, Resp> {

    //상속받는 클래스에서만 접근이 가능하며, Req와 Resp를 가지고 있는 baseService 선언
    protected CrudInterface<Req, Resp> baseService;

    @Override
    @PostMapping("")
    public Header<Resp> create(@RequestBody Header<Req> request) {
        log.info("CrudController [create]: ", request);
        return baseService.create(request);
    }

    @Override
    @GetMapping("/{id}")
    public Header<Resp> read(@PathVariable Long id) {
        log.info("CrudController [read]: ", id);
        return baseService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<Resp> update(@RequestBody Header<Req> request) {
        log.info("CrudController [update]: ", request);
        return baseService.update(request);
    }

    @Override
    @DeleteMapping("/{id}")
    public Header<Resp> delete(@PathVariable Long id) {
        log.info("CrudController [delete]: ", id);
        return baseService.delete(id);
    }
}
