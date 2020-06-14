package com.example.eswebdemo.service;

import com.example.eswebdemo.mapper.IndicatorItemMapper;
import com.example.eswebdemo.model.IndicatorItem;
import com.example.eswebdemo.util.EsUtils;
import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class IndicatorItemServiceImpl implements IndicatorItemService {

    @Resource
    private IndicatorItemMapper indicatorItemMapper;

    @Override
    public List<IndicatorItem> getAllIndicatorItems() {
        return indicatorItemMapper.getAll();
    }

    @Override
    public Map<String, Object> exportIndicatorItemsToEs() {
        List<IndicatorItem> indicatorItemList = indicatorItemMapper.getAll();
        EsUtils.bulk("indicator_item", "_doc", indicatorItemList);
        return ImmutableMap.of("code", 0);
    }

}
