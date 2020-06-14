package com.example.eswebdemo.service;

import com.example.eswebdemo.model.IndicatorItem;

import java.util.List;
import java.util.Map;

public interface IndicatorItemService {

    List<IndicatorItem> getAllIndicatorItems();

    Map<String, Object> exportIndicatorItemsToEs();

}