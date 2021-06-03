package JavaProject.hrms.core.adapters.image;

import org.springframework.web.multipart.MultipartFile;

import JavaProject.hrms.core.utilities.results.DataResult;

public interface ImageService {

	DataResult<?> uploadImage(MultipartFile file);

}
