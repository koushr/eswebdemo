package com.example.eswebdemo.controller;

import com.example.eswebdemo.model.IndicatorItem;
import com.example.eswebdemo.service.IndicatorItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author shengruikou
 */
@RestController
@RequestMapping("/indicatorItem")
public class IndicatorItemController {

    @Autowired
    private IndicatorItemService indicatorItemService;

    @RequestMapping("/getAll")
    public List<IndicatorItem> getAllIndicatorItems() {
        return indicatorItemService.getAllIndicatorItems();
    }

    @RequestMapping("/exportToEs")
    public Map<String, Object> exportIndicatorItemsToEs() {
        return indicatorItemService.exportIndicatorItemsToEs();
    }

}
