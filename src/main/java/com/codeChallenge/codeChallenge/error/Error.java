package com.codeChallenge.codeChallenge.error;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter 
@Getter 
@RequiredArgsConstructor
@NoArgsConstructor
public class Error {

 

    @NonNull
    private String description;
    

}
