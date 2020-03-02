package in.easyapp.easysubscription.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import in.easyapp.easysubscription.models.ServiceMdl;

@Repository
public interface ServiceRepository extends MongoRepository<ServiceMdl, String>{

	ServiceMdl findByServiceId(String serviceId);

	// Need to discuss
	void findByAppId(String appId);
}
