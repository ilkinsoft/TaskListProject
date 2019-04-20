package com.wap.model.result;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultData<T> extends Result {
    private T data;
}
