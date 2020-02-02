package in.easyapp.easysubscription.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import in.easyapp.easysubscription.models.ProjectMdl;

@Repository
public interface AppRepository extends MongoRepository<ProjectMdl, String> {
	
	List<ProjectMdl> findAllByCreatedBy(String createdBy);

	ProjectMdl findByAppId(String appId);

}
