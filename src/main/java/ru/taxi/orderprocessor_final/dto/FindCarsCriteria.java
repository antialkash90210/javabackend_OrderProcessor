
package ru.taxi.orderprocessor_final.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindCarsCriteria {

    private ECriteria criteria;
    @Valid
    private Sort sort;

}
