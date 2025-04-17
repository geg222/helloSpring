package kr.ac.hansung.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name ="Offers")
public class Offer {

    @Id // 엔티티의 기본 키
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB에서 자동 증가(AUTO_INCREMENT) 되는 방식으로 키를 생성하라는 의미
    private int id;

    @Size(min =2, max= 100, message = "이름은 2~100 사이 글자로 입력해주세요")
    private String name;

    @Email(message="이메일 형식으로 입력해주세요")
    @NotEmpty(message = "이메일을 입력해주세요")
    private String email;

    @Size(min=5, max=100, message = "5~100사이 글자수로 입력해주세요")
    private String text;
}
