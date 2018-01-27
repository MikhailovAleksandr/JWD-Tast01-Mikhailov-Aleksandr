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

public class ApplianceDAOImpl implements ApplianceDAO {

	private static String sourceName;

	static {
		SourceNameReader sourceNameReader = SourceNameReader.getInstanse();
		sourceName = sourceNameReader.read();
	}

	@Override
	public <E> Appliance find(Criteria<E> criteria) { //должна возвращать ссылку типа Appliance, т.е. на объект

		Appliance appliance = null;
		String entityType = criteria.getApplianceType();
		String fileLine;
		Map<String, Object> fileLineMeanings = new HashMap<>();
		List<Object> valuesOfFileLine = new ArrayList<>();
		boolean flag = false;

		try {
			FileInputStream fstream = new FileInputStream(sourceName);
			BufferedReader buffer = new BufferedReader(new InputStreamReader(fstream));

			while ((fileLine = buffer.readLine()) != null) {        //считываем строку из файла

				String fileLineType = fileLine.split(" ")[0];

				if (entityType.equals(fileLineType)) { //поиск строки по типу дженерика

					FileLineParser.parseLine(fileLine, fileLineMeanings,valuesOfFileLine);
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
			return null;
		}
		return appliance;
	}
}

