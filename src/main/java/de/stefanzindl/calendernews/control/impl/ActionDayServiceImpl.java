package de.stefanzindl.calendernews.control.impl;

import de.stefanzindl.calendernews.control.ActionDayService;
import de.stefanzindl.calendernews.model.v1.ActionDay;
import de.stefanzindl.calendernews.repository.ActionDayRepository;
import de.stefanzindl.calendernews.repository.TopicRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class ActionDayServiceImpl implements ActionDayService {

    ActionDayRepository actionDayRepository;
    TopicRepository topicRepository;

    public ActionDayServiceImpl(ActionDayRepository actionDayRepository){
        this.actionDayRepository = actionDayRepository;
    }

    @Override
    public ActionDay save(ActionDay toSave) {
        return actionDayRepository.save(toSave);
    }

    @Override
    public List<ActionDay> saveAll(List<ActionDay> toSaveList) {
        return actionDayRepository.saveAll(toSaveList);
    }

    @Override
    public ActionDay loadByIdentifier(UUID identifier) {
        return null;
    }

    @Override
    public List<ActionDay> findAll() {
        return actionDayRepository.findAll();
    }

    @Override
    public List<ActionDay> loadByDate(LocalDate date) {
        return actionDayRepository.findByDate(date);
    }

    @Override
    public ActionDay findOneByUuid(UUID actionDayIdentifier) {
        return actionDayRepository.findByActionDayIdentifier(actionDayIdentifier);
    }
}
