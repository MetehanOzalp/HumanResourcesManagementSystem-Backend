package JavaProject.hrms.entities.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingFilter {

	private List<Integer> cityId;
	private List<Integer> jobPositionId;
	private List<Integer> wayOfWorkingId;
	private List<Integer> typeOfWorkingId;

}
