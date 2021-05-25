package JavaProject.hrms.core.adapters.mernis;

import java.util.Locale;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements UserCheckService {

	@Override
	public boolean validate(String nationalityId, String firstName, String lastName, int birthYear) {
		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();
		boolean result = false;
		try {
			result = kpsPublicSoapProxy.TCKimlikNoDogrula(Long.parseLong(nationalityId),
					firstName.toUpperCase(new Locale("tr")), lastName.toUpperCase(new Locale("tr")), birthYear);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return result;
	}

}
