package in.easyapp.easysubscription.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import in.easyapp.easysubscription.models.LicenseMdl;

@Repository
public interface LicensingRepository extends MongoRepository<LicenseMdl, String> {

	List<LicenseMdl> findAllByAppIdAndServiceId(String appId, String serviceId);
	
	LicenseMdl findByAppIdAndServiceId(String appId, String serviceId);
	

}
