package kr.ac.hansung.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Offer {
    private int id;
    private String name;
    private String email;
    private String text;
}
