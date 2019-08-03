package br.com.consultemed.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ConvertStringToLocalDate {

	public static LocalDate convertToLocalDate(String dataString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		// convert String to LocalDate
		LocalDate dataAgendamentoFormatter = LocalDate.parse(dataString, formatter);

		return dataAgendamentoFormatter;
	}

	public static Date convertLocalDateToDate(LocalDate dataAconverter) {
		
		Date dataConvertida = Date.from(dataAconverter.atStartOfDay(ZoneId.systemDefault()).toInstant());
		return dataConvertida;
	}
}
