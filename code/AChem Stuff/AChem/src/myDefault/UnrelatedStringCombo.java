package myDefault;

import java.math.BigDecimal;
import java.util.ArrayList;

public class UnrelatedStringCombo {
	static String[] allTitles = new String[] { "DesireForBanana", "Single", "MessyOrNeat", "IntrovertedOrExtroverted",
			"WarmOrCoolLight", "DimOrBrightLight", "IMsPerYear", "DepartmentSympathy", "AssignmentAIUsage",
			"ShowersPerWeek", "AlcoholConsumptionLastWeek", "GPA", "r", "g", "b", "h", "s", "v", "GenderMaleish",
			"GenderFemaleish", "GenderOther", "upper_classman_housing", "lowwer_classmen_housing", "off_campus_housing",
			"SleepHours", "Department_Bio/BME", "Department_CS/SE", "Department_Chem/Biochem", "Department_ChemE",
			"Department_Civil/Environmental", "Department_ECE/CPE", "Department_EMGT", "Department_EngD",
			"Department_ME", "Department_Math", "Department_Ph/OE/Nano", "Ethnicity_Asian", "Ethnicity_Other",
			"Ethnicity_White" };
	static String[] allCoefs = new String[] {"4.29718622e-01",  "3.33590124e-01", "-2.07179164e-03",  "6.35449251e-01",
		       "-1.76682898e-01",  "6.78729616e-03", "-1.05453959e-01", "-3.82902260e-01",
		       "-2.58684895e-01", "-2.03525484e-01",  "1.35891071e-01", " 4.10798098e-01",
		       "-6.81352944e-01", "-7.38519105e-01", "-3.18263436e-02", " 4.95494994e-02",
		       "-2.73069862e-01", " 4.33468449e-01",  "8.72986510e-01", "-7.19821422e-01",
		       "-3.79554304e-01", "-4.22682714e-01",  "2.33625623e-01", " 2.38645904e-01",
		        "4.83714382e-01", "-1.00682323e+00",  "1.95506799e-01", "-3.61586199e+00",
		       "-5.62869770e-01", " 6.31575172e-01",  "1.21683062e+00",  "4.82530507e+00",
		       "-2.74093273e+00", "-2.36370401e-01",  "1.44748382e+00", "-1.53843360e-01",
		       "-1.38964290e+00", " 2.08455485e-01",  "1.18118741e+00"};
	static double[] allCoefs2 = new double[] {4.29718622e-01,  3.33590124e-01, -2.07179164e-03,  6.35449251e-01,
		       -1.76682898e-01,  6.78729616e-03, -1.05453959e-01, -3.82902260e-01,
		       -2.58684895e-01, -2.03525484e-01,  1.35891071e-01,  4.10798098e-01,
		       -6.81352944e-01, -7.38519105e-01, -3.18263436e-02,  4.95494994e-02,
		       -2.73069862e-01,  4.33468449e-01,  8.72986510e-01, -7.19821422e-01,
		       -3.79554304e-01, -4.22682714e-01,  2.33625623e-01,  2.38645904e-01,
		        4.83714382e-01, -1.00682323e+00,  1.95506799e-01, -3.61586199e+00,
		       -5.62869770e-01,  6.31575172e-01,  1.21683062e+00,  4.82530507e+00,
		       -2.74093273e+00, -2.36370401e-01,  1.44748382e+00, -1.53843360e-01,
		       -1.38964290e+00,  2.08455485e-01,  1.18118741e+00};

	static String[] numMeans = new String[] { "DesireForBanana               1.061689e-18",
			"Single                       -1.941374e-17", "MessyOrNeat                   1.581158e-16",
			"IntrovertedOrExtroverted      1.698702e-16", "WarmOrCoolLight               1.019221e-16",
			"DimOrBrightLight             -2.426717e-17", "IMsPerYear                    3.882747e-17",
			"DepartmentSympathy            2.171912e-16", "AssignmentAIUsage             6.794808e-17",
			"ShowersPerWeek                0.000000e+00", "AlcoholConsumptionLastWeek   -5.945457e-17",
			"GPA                           5.532915e-16", "r                            -5.824121e-17",
			"g                             1.698702e-17", "b                             1.456030e-17",
			"h                             1.456030e-16", "s                            -1.358962e-16",
			"v                            -1.067755e-16", "GenderMaleish                 6.794808e-17",
			"GenderFemaleish               9.706868e-18", "GenderOther                   4.853434e-18",
			"upper_classman_housing        2.426717e-17", "lowwer_classmen_housing       1.941374e-17",
			"off_campus_housing            3.882747e-17", "SleepHours                    3.688610e-16" };
	static String[] catMeans = new String[] { "Department_Bio/BME                0.076503",
			"Department_CS/SE                  0.300546", "Department_Chem/Biochem           0.005464",
			"Department_ChemE                  0.038251", "Department_Civil/Environmental    0.054645",
			"Department_ECE/CPE                0.147541", "Department_EMGT                   0.005464",
			"Department_EngD                   0.038251", "Department_ME                     0.267760",
			"Department_Math                   0.032787", "Department_Ph/OE/Nano             0.032787",
			"Ethnicity_Asian                   0.092896", "Ethnicity_Other                   0.131148",
			"Ethnicity_White                   0.775956" };
	static String[] catSTD = new String[] { "Department_Bio/BME                0.266530",
			"Department_CS/SE                  0.459754", "Department_Chem/Biochem           0.073922",
			"Department_ChemE                  0.192329", "Department_Civil/Environmental    0.227909",
			"Department_ECE/CPE                0.355617", "Department_EMGT                   0.073922",
			"Department_EngD                   0.192329", "Department_ME                     0.444006",
			"Department_Math                   0.178567", "Department_Ph/OE/Nano             0.178567",
			"Ethnicity_Asian                   0.291083", "Ethnicity_Other                   0.338488",
			"Ethnicity_White                   0.418095" };
	static String[] numSTD = new String[] { "DesireForBanana                3.358349",
			"Single                         4.097532", "MessyOrNeat                    2.065667",
			"IntrovertedOrExtroverted       2.174695", "WarmOrCoolLight                2.651306",
			"DimOrBrightLight               2.148345", "IMsPerYear                    14.038364",
			"DepartmentSympathy             1.661771", "AssignmentAIUsage              2.720358",
			"ShowersPerWeek                 5.771765", "AlcoholConsumptionLastWeek     1.527977",
			"GPA                            0.548944", "r                             90.093903",
			"g                             72.803763", "b                             83.401402",
			"h                              0.277382", "s                              0.282157",
			"v                             58.874444", "GenderMaleish                  0.468679",
			"GenderFemaleish                0.380892", "GenderOther                    0.355617",
			"upper_classman_housing         0.496671", "lowwer_classmen_housing        0.406738",
			"off_campus_housing             0.481508", "SleepHours                     2.615011" };

	public static void main(String[] args) {
		// need GPA + SUM(Gender)+68
		// IF(EQUAL({{2dr89gc2}}, 0), 6, 0.5)
		String all= "";
		int k =0;
		for(String title:allTitles) {
			all = all + "("+(allCoefs2[k]*1.0)+"(("+title + "-"+getOutOf(numMeans,title)+getOutOf(catMeans,title)+")/"+getOutOf(numSTD,title)+getOutOf(catSTD,title)+"))";
			k++;
		}
		System.out.println(all);
		System.out.println(numSTD.length);
		
		
	}

	private static String getOutOf(String[] stringArray, String string) {
		for(String snipe:stringArray) {
			if(snipe.contains(string)) {
				return ""+(new BigDecimal(Double.parseDouble(snipe.substring(snipe.lastIndexOf(" ")))).toPlainString());
			}
		}
		return "";
	}
}
