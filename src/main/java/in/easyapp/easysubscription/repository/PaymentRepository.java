package in.easyapp.easysubscription.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import in.easyapp.easysubscription.models.SubscnOrderMdl;

@Repository
public interface PaymentRepository extends MongoRepository<SubscnOrderMdl, String> {

}
