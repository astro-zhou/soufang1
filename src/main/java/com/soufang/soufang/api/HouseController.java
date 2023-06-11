package com.soufang.soufang.api;

import com.soufang.soufang.base.ApiResponse;
import com.soufang.soufang.dto.HouseDTO;
import com.soufang.soufang.dto.HouseParams;
import com.soufang.soufang.dto.HouseSearchParams;
import com.soufang.soufang.service.HouseService;
import com.soufang.soufang.service.SearchService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/houses")
public class HouseController {
    private SearchService searchService;
    private HouseService houseService;

    public HouseController(SearchService searchService, HouseService houseService) {
        this.searchService = searchService;
        this.houseService = houseService;
    }

    // 输入 花园
    // 返回结果： 花园小区、花园房
    @GetMapping("/suggestions")
    public ApiResponse<List<String>> autocompletion(@RequestParam String prefix) {
        return ApiResponse.success(searchService.autocompletion(prefix));
    }

    @PostMapping("/search")
    public ApiResponse<Page<HouseDTO>> searchHouses(@RequestBody HouseSearchParams params) {
        return ApiResponse.success(searchService.search(params));
    }

    @PostMapping
    public ApiResponse<Long> createHouses(@RequestBody HouseParams params) {
        return ApiResponse.success(houseService.create(params));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Object> deleteHouses(@PathVariable Long id) {
        houseService.delete(id);
        return ApiResponse.success();
    }
}
