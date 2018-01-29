package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.*;
import java.io.*;


// не додумал решение задачи
// не до конца оперировал объектами в голове
// если даешь вменяемое название переменной - то это 90% того, что код, написанный тобой, будет адекватным
// если никак не можешь назвать переменную - значит что-то идет не так
public class ApplianceDAOImpl implements ApplianceDAO {

	private static String sourceName;// его можно сделать final

	static {
		SourceNameReader sourceNameReader = SourceNameReader.getInstanse();
		sourceName = sourceNameReader.read();
	}

	@Override
	public <E> Appliance find(Criteria<E> criteria) { //должна возвращать ссылку типа Appliance, т.е. на объект

		Appliance appliance = null;
		String entityType = criteria.getApplianceType();
		String fileLine;
		Map<String, Object> fileLineMeanings = new HashMap<>();// перевожу названия - осмыслялки (иначе во множественном числе не получается) строк в файле
		List<Object> valuesOfFileLine = new ArrayList<>(); // значения файловых строк
		// данные из файла действительно надо осмыслять? да и какая мне разница - строками они там записаны или столбиком - эту информацию должен уже знать конкретный ридер
		boolean flag = false; // просто флаг, зачем он - догадывайся

		try {
			FileInputStream fstream = new FileInputStream(sourceName);
			BufferedReader buffer = new BufferedReader(new InputStreamReader(fstream));// метод close на этом объекте Пушкин будет вызывать?

			while ((fileLine = buffer.readLine()) != null) {        //считываем строку из файла

				String fileLineType = fileLine.split(" ")[0];

				if (entityType.equals(fileLineType)) { //поиск строки по типу дженерика -> да не строки нужно искать, а данные

					FileLineParser.parseLine(fileLine, fileLineMeanings,valuesOfFileLine);// этому методу нужно возвращать парсинг, иначе криво получается
					flag = ComparatorForFileLineAndCriteriaParameters.compare(fileLineMeanings,
							criteria.getCriteria());
				}
				if (flag) {
					appliance = ApplianceCreator.create(valuesOfFileLine, criteria.getApplianceType());
					break;
				}
			}
		} catch (IOException e) {
			System.out.println("File error " + e);
			return null;// на будущее, null является валидным возвращаемым значением и не фвляется палочкой-спасабочкой при исключениях
			// да и гасить исключения просто так нельзя
		}
		return appliance;
	}
}

