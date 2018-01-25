package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.util.regex.*;
import java.io.*;

public class ApplianceDAOImpl implements ApplianceDAO {

	@Override
	public <E> Appliance find(Criteria<E> criteria) { //должна возвращать ссылку типа Appliance, т.е. на объект
		try {
			FileInputStream fstream = new FileInputStream("../resources/appliances_db.txt");
			BufferedReader buffer = new BufferedReader(new InputStreamReader(fstream));	//открываем файл

			String strLine;
			Pattern patternForSearch = Pattern.compile("\\S+[=](\\w+\\W\\w|\\w+)"); //рег-е выражение
			Appliance appliance = null;	//ссылка на объект

			while ((strLine = buffer.readLine()) != null) {		//считываем строку из файла

				appliance =  ApplianceSearcher.searcher(strLine, criteria, patternForSearch);

					if ( appliance != null ) {
						return appliance;
					}
				}
			return appliance;

		} catch (IOException e) {
			System.out.println("File error " + e);
			return null;
		}
	}
}

