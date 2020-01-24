package in.easyapp.easysubscription.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import in.easyapp.easysubscription.models.ProjectRequestMdl;

@Repository
public interface AppRepository extends MongoRepository<ProjectRequestMdl, String> {
	
	List<ProjectRequestMdl> findAllByCreatedBy(String createdBy);

	ProjectRequestMdl findByAppId(String appId);

}
