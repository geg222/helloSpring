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

    public List<Offer> getAllOffers() {
        return offerDao.getOffers();
    }
}
