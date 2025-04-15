package kr.ac.hansung.controller;

import kr.ac.hansung.model.Offer;
import kr.ac.hansung.servcie.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OfferController {
    @Autowired // 컨테이너의 OfferService Bean 삽입
    private OfferService offerService; // service 호출

    @GetMapping("/offers")
    public String showOffers(Model model) {
        List<Offer> offers = offerService.getAllOffers();
        model.addAttribute("id_offers", offers); // model에 저장

        return "offers"; // offers.jsp 뷰로 넘김
    }
}
