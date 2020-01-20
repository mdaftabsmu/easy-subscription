package in.easyapp.easysubscription.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import in.easyapp.easysubscription.models.LicenseMdl;

@Repository
public interface DownloadRepository extends MongoRepository<LicenseMdl, String> {

}
