
package ru.taxi.orderprocessor_final.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ApiErrorType { //Тип ошибки API

    //@JsonProperty(“name”) – эта говорит, что данный атрибут в JSON будет именоваться как name
    @JsonProperty("validation")
    VALIDATION,
    @JsonProperty("business")
    BUSINESS,
    @JsonProperty("system")
    SYSTEM;

    private ApiErrorType() {
    }


}
