package me.bj.jpashop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchMemberResponse<T> {
    private int count;
    private T data;
}
