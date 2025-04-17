package kr.ac.hansung.servcie;

import kr.ac.hansung.dao.OfferDao;
import kr.ac.hansung.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {
    @Autowired
    private OfferDao offerDao; // Dao 호출

    //모든 offer 가져오가
    public List<Offer> getAllOffers() {
        return offerDao.getOffers();
    }

    //offer 값 넣어주기
    public void insertOffer(Offer offer) {
        offerDao.insert(offer);
    }
}
