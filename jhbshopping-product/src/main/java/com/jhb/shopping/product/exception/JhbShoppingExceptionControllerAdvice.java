package com.jhb.shopping.product.exception;

import com.jhb.common.exception.BizCodeEnum;
import com.jhb.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice(basePackages = "com.jhb.shopping.product.controller")
public class JhbShoppingExceptionControllerAdvice {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleVaildException(MethodArgumentNotValidException e){
        log.error("数据校验出现问题{}", e.getMessage());
        BindingResult result = e.getBindingResult();
        Map<String, String> errorData = new HashMap<>();
        result.getFieldErrors().forEach(item ->{
            String message = item.getDefaultMessage();
            String field = item.getField();
            errorData.put(field, message);
        });
        return R.error(BizCodeEnum.VALID_EXCEPTION.getCode(),
                BizCodeEnum.VALID_EXCEPTION.getMessage()).put("data", errorData);
    }

    @ExceptionHandler(value = Throwable.class)
    public R handleVaildException(Throwable e){
        log.error("全局异常{}", e.getMessage());
        return R.error(BizCodeEnum.UNKNOWN_EXCEPTION.getCode(),
                BizCodeEnum.UNKNOWN_EXCEPTION.getMessage());
    }
}
