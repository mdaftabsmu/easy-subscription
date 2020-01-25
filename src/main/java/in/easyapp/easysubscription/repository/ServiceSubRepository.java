package in.easyapp.easysubscription.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import in.easyapp.easysubscription.models.ServiceSubscriptionMdl;

@Repository
public interface ServiceSubRepository extends MongoRepository<ServiceSubscriptionMdl, String>   {

	List<ServiceSubscriptionMdl> findAllByAppId(String appId);

}
