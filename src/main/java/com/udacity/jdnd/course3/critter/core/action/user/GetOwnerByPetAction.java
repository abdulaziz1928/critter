package com.udacity.jdnd.course3.critter.core.action.user;

import com.udacity.jdnd.course3.critter.core.domain.user.common.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GetOwnerByPetAction {

    public Customer execute(long petId){
        return null;
    }
}
