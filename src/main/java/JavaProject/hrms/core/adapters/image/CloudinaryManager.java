package JavaProject.hrms.core.adapters.image;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import JavaProject.hrms.core.utilities.results.DataResult;
import JavaProject.hrms.core.utilities.results.ErrorDataResult;
import JavaProject.hrms.core.utilities.results.SuccessDataResult;

public class CloudinaryManager implements ImageService {

	Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", "metcloud", "api_key", "944519468684757",
			"api_secret", "CPqAjCpyyURWvcg84ix4CPnQaWY"));

	@Override
	public DataResult<?> uploadImage(MultipartFile file) {
		try {
			Map upload = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(upload);
		} catch (IOException e) {
			e.printStackTrace();
			return new ErrorDataResult<Map>();
		}
	}

}
