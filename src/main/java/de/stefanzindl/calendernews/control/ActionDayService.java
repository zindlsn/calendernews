package de.stefanzindl.calendernews.control;

import de.stefanzindl.calendernews.model.v1.ActionDay;

import java.time.LocalDate;
import java.util.List;

public interface ActionDayService extends Service<ActionDay>{
    List<ActionDay> loadByDate(LocalDate date);
    List<ActionDay> loadByTopicNames(List<String> names);
}
