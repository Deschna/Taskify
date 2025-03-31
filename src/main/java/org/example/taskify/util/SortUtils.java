package org.example.taskify.util;

import java.util.Arrays;
import java.util.List;
import org.springframework.data.domain.Sort;

public class SortUtils {

    public static Sort parseSort(String[] sortParams, String defaultProperty) {
        if (sortParams == null || sortParams.length == 0) {
            return Sort.by(Sort.Direction.ASC, defaultProperty);
        }

        List<Sort.Order> orders = Arrays.stream(sortParams)
                .map(SortUtils::parseSortOrder)
                .toList();

        return Sort.by(orders);
    }

    private static Sort.Order parseSortOrder(String sortParam) {
        String[] sortParts = sortParam.split(":");
        String field = sortParts[0].trim();
        Sort.Direction direction = (sortParts.length > 1)
                ? Sort.Direction.fromString(sortParts[1].trim())
                : Sort.Direction.ASC;

        return new Sort.Order(direction, field);
    }
}
