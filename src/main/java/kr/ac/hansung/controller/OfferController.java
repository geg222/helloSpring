package kr.ac.hansung.controller;

import jakarta.validation.Valid;
import kr.ac.hansung.model.Offer;
import kr.ac.hansung.servcie.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

 // 이 클래스는 Spring MVC의 컨트롤러로 사용됨
@Controller
public class OfferController {
    // OfferService 빈을 자동 주입하여 서비스 계층의 메서드를 호출 가능하게 함
    @Autowired
    private OfferService offerService; // service 호출


    @GetMapping("/offers")
    public String showOffers(Model model) {
        List<Offer> offers = offerService.getAllOffers(); // OfferService를 통해 전체 Offer 목록을 가져옴
        model.addAttribute("id_offers", offers); // 모델에 "id_offers" 이름으로 offers 리스트를 저장하여 뷰에서 접근 가능하게 함

        return "offers"; // "offers.jsp" 뷰로 이동
    }


    @GetMapping("/createoffer")
    public String createOffer(Model model) {
        model.addAttribute("offer", new Offer()); // 새로운 빈 Offer 객체를 모델에 추가하여 폼에 바인딩할 수 있도록 설정
        return "createoffer"; // "createoffer.jsp" 뷰로 이동
    }

    @PostMapping("/docreate")
    public String docreateOffer(Model model, @Valid Offer offer, BindingResult result) {

        if(result.hasErrors()) {
            System.out.println("== Form data does not validated ==");

            List<ObjectError> errors = result.getAllErrors();

            for(ObjectError error:errors) {
                System.out.println(error.getDefaultMessage());
            }

            return "createoffer";
        }
        // Controller -> Service -> Dao
        offerService.insertOffer(offer);
        return "offercreated";
    }
}
