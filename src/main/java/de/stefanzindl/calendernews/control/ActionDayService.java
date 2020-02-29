package de.stefanzindl.calendernews.control;

import de.stefanzindl.calendernews.model.v1.ActionDay;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ActionDayService extends Service<ActionDay>{
    List<ActionDay> loadByDate(LocalDate date);
}
