package in.easyapp.easysubscription.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import in.easyapp.easysubscription.models.ProjectRequestMdl;

@Repository
public interface AppRepository extends MongoRepository<ProjectRequestMdl, String> {

}
