package com.yog.fw.core.services;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.yog.fw.core.annotations.Validation;
import com.yog.fw.core.utils.DateUtils;
import com.yog.mt.models.BaseModel;

@Service
public class ModelService implements IModelService {
	
	private static final long serialVersionUID = 1L;
	
	public static final Logger logger = LogManager.getLogger(ModelService.class);

	public void validate(BaseModel model) throws Exception {
		String msg = "";

		Field[] fields = model.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			if (field.isAnnotationPresent(Validation.class)) {
				Validation validation = field.getAnnotation(Validation.class);
				Object value;
				try {
					value = field.get(model);
				} catch (IllegalArgumentException | IllegalAccessException ex) {
					logger.log(Level.ERROR, ex);
					continue;
				}
				if (validation.required()) {
					if (value == null) {
						msg += field.getName() + ": should not be null\n";
						continue;
					}
				}

				if (value == null)
					continue;
				/**
				 * Date
				 * */
				long l = 0;
				Date date = null;
				if (validation.isDate()) {
					String type = field.getType().getSimpleName();
					if (type.equals("Long")) {
						Long ll = (Long) field.get(model);
						l = ll.longValue();
					}
					if (type.equals("Date")) {
						date = (Date) field.get(model);
						l = date.getTime();
					}
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					if(!validation.minDate().isEmpty()) {
						Date minDate = null;
						
						if(validation.minDate().equals("now")) {
							minDate = new Date();
						} else minDate = sdf.parse(validation.minDate());
						
						long minDateTs = DateUtils.getDateInMillis(minDate);
						if (l < minDateTs) {
							msg += field.getName() + ": You can't use past time\n";
						}
					}

					if(!validation.maxDate().isEmpty()) {
						Date maxDate = null;
						
						if(validation.maxDate().equals("now")) {
							maxDate = new Date();
						} else maxDate = sdf.parse(validation.maxDate());
						
						long maxDateTs = DateUtils.getDateInMillis(maxDate);
						if (l > maxDateTs) {
							msg += field.getName() + ": You can't use future time\n";
						}
					}
					continue;
				}
				/**
				 * Min and Max
				 * */
				if (field.getType().getSimpleName().equals("int") || field.getType().getSimpleName().equals("Integer")) {
					Integer i = (Integer) field.get(model);
					l = i.intValue();
				} else if (field.getType().getSimpleName().equals("long") || field.getType().getSimpleName().equals("Long")) {
					Long ll = (Long) field.get(model);
					l = ll.longValue();
				} else if (field.getType().getSimpleName().equals("String")) {
					String str = (String) field.get(model);
					l = str.length();
				} else if (field.getType().getSimpleName().equals("char[]")) {
					char[] chrs = (char[]) field.get(model);
					l = chrs.length;
				}

				if (l > validation.max()) {
					msg += field.getName() + ": should not be greater then " + validation.max() + " value\n";
				} else if (l < validation.min()) {
					msg += field.getName() + ": should not be less then " + validation.min() + "\n";
				}

			}

			if (!msg.isEmpty())
				throw new Exception(msg);
		}
	}
}
